package edu.ntnu.iir.bidata;

import java.time.LocalDateTime;
import java.util.*;


/**
 * DiaryRegister class is responsible for managing all diary entries in the application.
 * It maps each author to a list of their own DiaryEntry objects.
 *
 * @author Tri Minh Luong
 * @version 2.0
 */


public class DiaryRegister {
  private final Map<Author, List<DiaryEntry>> diaryMap;


  /**
   * Constructor that initializes an empty register.
   */
  public DiaryRegister() {
    diaryMap = new HashMap<>();
  }

  /**
   * Adds a diary entry to the diary register.
   *
   * @param entry the diary entry to be added.
   * @return true if the entry was added successfully or false if the diary entry already exist.
   * @throws IllegalArgumentException if the entry to be added is null or
   *                                  the author is null.
   */
  public boolean addDiaryEntry(Author author, DiaryEntry entry) {
    if (author == null || entry == null) {
      throw new IllegalArgumentException("Author or entry cannot be null");
    }
    if (entry.getAuthor().getId() != author.getId()) {
      throw new IllegalArgumentException("Diary entry author doesn't belong to this author");
    }
    diaryMap.putIfAbsent(author, new ArrayList<>()); // recommended by (OpenAI, 2025)
    List<DiaryEntry> diaryEntries = diaryMap.get(author);

    if (diaryEntries.contains(entry)) {
      return false;
    }
    diaryEntries.add(entry);
    return true;

  }

  /**
   * Deletes a diary entry from a specific author in the diary.
   *
   * @param author the author who wrote the entry.
   * @param entry  the diary entry to be removed.
   * @return true if the entry existed and was removed and false if it was not.
   * @throws IllegalArgumentException if entry or author is null.
   */
  public boolean deleteDiaryEntry(Author author, DiaryEntry entry) {
    if (entry == null || author == null) {
      throw new IllegalArgumentException("Diary entry or author cannot be null");
    }
    List<DiaryEntry> diaryEntries = diaryMap.get(author);
    if (diaryEntries == null) {
      return false;
    }
    Iterator<DiaryEntry> iterator = diaryEntries.iterator();
    while (iterator.hasNext()) {
      DiaryEntry diaryEntry = iterator.next();
      if (diaryEntry.equals(entry)) {
        iterator.remove();
        return true;
      }
    }
    return false;
  }

  /**
   * Allows the user to search for a diary entry/entries by date range.
   *
   * @param fromDate the date to search from.
   * @param toDate   the date to search to.
   * @return a list with the entry/entries that matches the date range searched in between,
   * or an empty list if no entries was found.
   * @throws IllegalArgumentException if fromDate or toDate is null or fromDate is after toDate.
   */
  public List<DiaryEntry> searchByDate(LocalDateTime fromDate, LocalDateTime toDate) {
    if (fromDate == null || toDate == null) {
      throw new IllegalArgumentException("fromDate or toDate cannot be null");
    }
    if (fromDate.isAfter(toDate)) {
      throw new IllegalArgumentException("fromDate cannot be after toDate!");
    }
    List<DiaryEntry> match = new ArrayList<>();
    for (List<DiaryEntry> diaryEntries : diaryMap.values()) {
      for (DiaryEntry entry : diaryEntries) {
        if (entry.getCreatedAt().isAfter(fromDate) && entry.getCreatedAt().isBefore(toDate)) {
          match.add(entry);
        }
      }
    }
    return match;
  }

  /**
   * Returns a sorted list with entries in the register by creation date from newest to oldest.
   *
   * @return a sorted list with the newest to oldest entries.
   */
  public List<DiaryEntry> getSortedEntries() {
    List<DiaryEntry> allEntries = new ArrayList<>();
    for (List<DiaryEntry> diaryEntries : diaryMap.values()) {
      allEntries.addAll(diaryEntries);
    }
    allEntries.sort((a, b) -> b.getCreatedAt().compareTo(a.getCreatedAt()));

    return allEntries;
  }

  /**
   * Clears all the entries from the diary register.
   *
   * @return true if the register was cleared successfully or false if the register was empty.
   */
  public boolean clearEntries() {
    if (diaryMap.isEmpty()) {
      return false;
    }
    diaryMap.clear();
    return true;
  }

  /**
   * Returns all diary entries by the given author.
   *
   * @param author the entries to get for the given author.
   * @return entry/entries that is connected to the author, an empty list if no entries exist.
   * @throws IllegalArgumentException if the author is null.
   */

  public List<DiaryEntry> getAllEntriesByAuthor(Author author) {
    if (author == null) {
      throw new IllegalArgumentException("Author cannot be null");
    }
    return diaryMap.getOrDefault(author, new ArrayList<>());
  }

  /**
   * Returns a map of how many entries every author has written.
   *
   * @return a map of every author as the key and how many entries they have as the value.
   *
   */

  public Map<Author, Integer> getTotalEntriesByAuthors() {
    Map<Author, Integer> totalEntries = new HashMap<>();
    // Loop structure recommended by Copilot 2025
    for (Map.Entry<Author, List<DiaryEntry>> entry : diaryMap.entrySet()) {
      Author author = entry.getKey();
      int count = entry.getValue().size();
      totalEntries.put(author, count);
    }
    return totalEntries;
  }

  /**
   * Searches for all diary entries containing that specific word in their diary text.
   *
   * @param word the word to search for.
   * @return a list of all entries that contains the searched word.
   * @throws IllegalArgumentException if the word is null or blank.
   */

  public List<DiaryEntry> searchEntryByWord(String word) {
    if (word == null || word.isBlank()) {
      throw new IllegalArgumentException("word cannot be null or blank!");
    }
    String lowerCaseWord = word.toLowerCase();
    List<DiaryEntry> entriesWithWord = new ArrayList<>();
    for (List<DiaryEntry> diaryEntries : diaryMap.values()) {
      for (DiaryEntry entry : diaryEntries) {
        if (entry.getDiaryText().toLowerCase().contains(lowerCaseWord)) {
          entriesWithWord.add(entry);
        }
      }
    }
    return entriesWithWord;
  }
}

