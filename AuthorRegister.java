package edu.ntnu.iir.bidata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Represents the register class for the author class and is
 * responsible to store and manage all the authors in this diary.
 *
 * <p>Allows the user to add, search, delete, get and remove authors.<p/>
 *
 * @author Tri Minh Luong
 * @version 1.0
 */

public class AuthorRegister {
  private final List<Author> authors;


  /**
   * Constructor that initializes the author register.
   */
  public AuthorRegister() {
    authors = new ArrayList<>();
  }

  /**
   * Adds a new author to the author register.
   *
   * @param author the author to be added.
   * @return true if the author was added successfully or false if not.
   * @throws IllegalArgumentException if author to be added is null.
   *
   */
  public boolean addAuthor(Author author) {
    if (author == null) {
      throw new IllegalArgumentException("Author cannot be null");
    }
    for (Author a : authors) {
      // Compares two authors by their ID to check for duplicate (same author).
      if (a.getId() == author.getId()) {
        return false;
      }
    }
    authors.add(author);
    return true;
  }

  /**
   * Returns a copy of the list of all the authors that are in the register.
   *
   * @return a list of all authors.
   */
  public List<Author> getAllAuthors() {
    return new ArrayList<>(authors);
  }

  /**
   * Returns the amount of authors that are in the register.
   *
   * @return number of authors.
   */
  public int getAuthorCount() {
    return authors.size();
  }


  /**
   * Search for a user in the register by name, ignores upper and lower cases.
   *
   * @param name the name of the author to search for.
   * @return a list of all authors that matches the name or an empty list if no matches.
   * @throws IllegalArgumentException if name of the user is null or blank.
   */
  public List<Author> searchAuthorByName(String name) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("Author name cannot be null or blank");
    }
    List<Author> nameList = new ArrayList<>();
    for (Author author : authors) {
      if (author.getName().equalsIgnoreCase(name)) {
        nameList.add(author);
      }
    }
    return nameList;
  }

  /**
   * Accessor method to get the author by ID.
   *
   * @param id the unique ID of an author.
   * @return the author that matches the given ID and null if no authors matches the ID.
   */
  public Author getAuthorById(int id) {
    for (Author author : authors) {
      if (author.getId() == id) {
        return author;
      }
    }
    return null;
  }


  /**
   * Removes the specific author from the AuthorRegister by their id number.
   *
   * @param id the id of the author.
   * @return true if the author was successfully removed or false if not.
   * @throws IllegalArgumentException if the author ID is less than 1.
   */
  public boolean removeAuthor(int id) {
    if (id <= 0) {
      throw new IllegalArgumentException("Author ID cannot be less than 1");
    }
    Iterator<Author> iterator = authors.iterator();
    while (iterator.hasNext()) {
      if (iterator.next().getId() == id) {
        iterator.remove();
        return true;
      }
    }
    return false;
  }


}
