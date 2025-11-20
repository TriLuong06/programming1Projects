package edu.ntnu.iir.bidata;

import java.time.LocalDateTime;

/**
 * DiaryEntry class is the core entity class of the workout diary application.
 *
 * <p>It is responsible for the diary entry object that is a diary entry with information
 * that a diary entry/workout session should contain.
 *
 * @author Tri Minh Luong
 * @version 2.1
 */
public class DiaryEntry {

  private final Author author;
  private String diaryText;
  private String entryTitle;
  private String activityType;
  private int durationMinutes;
  private int intensityLevel;
  private final LocalDateTime createdAt;
  private LocalDateTime lastModified;

  /**
   * Constructor that initializes a DiaryEntry object with the correct data.
   *
   * @param author              the author that created the diary entry.
   * @param inputTitle          the title of the diary entry/workout session.
   * @param inputActivityType   the activity type of workout session.
   * @param inputDuration       the duration (minutes) of workout session.
   * @param inputIntensityLevel the intensity level of workout session.
   * @throws IllegalArgumentException if the value is null, blank or out of the valid range.
   */
  public DiaryEntry(Author author, String inputTitle, String inputActivityType,
                    String diaryText, int inputDuration, int inputIntensityLevel) {

    if (diaryText == null || diaryText.isBlank()) {
      throw new IllegalArgumentException("diary text cannot be null or blank!");
    }

    if (author == null) {
      throw new IllegalArgumentException("Author cannot be null!");
    }

    if (inputTitle == null || inputTitle.isBlank()) {
      throw new IllegalArgumentException("The title for this session can not be empty!");
    }

    if (inputActivityType == null || inputActivityType.isBlank()) {
      throw new IllegalArgumentException("Activity type can not be blank!");
    }

    if (inputDuration <= 0) {
      throw new IllegalArgumentException("Workout must last longer than 0 minutes");
    }

    if (inputIntensityLevel < 1 || inputIntensityLevel > 10) {
      throw new IllegalArgumentException("The intensity level must be rated between 1 and 10");
    }

    this.diaryText = diaryText;
    this.author = author;
    this.entryTitle = inputTitle;
    this.activityType = inputActivityType;
    this.durationMinutes = inputDuration;
    this.intensityLevel = inputIntensityLevel;
    this.createdAt = LocalDateTime.now();
    this.lastModified = LocalDateTime.now();
  }

  /**
   * Returns the text content in the diary entry.
   *
   * @return the text written by the author in the diary.
   */
  public String getDiaryText() {
    return diaryText;
  }

  /**
   * Updates the text content in the diary entry.
   * ALso updates the last modified time.
   *
   * @param diaryText the new diary text to mutate.
   * @throws IllegalArgumentException if the text is null or blank.
   */
  public void setDiaryText(String diaryText) {
    if (diaryText == null || diaryText.isBlank()) {
      throw new IllegalArgumentException("diary text cannot be null or blank!");
    }
    this.diaryText = diaryText;
    this.lastModified = LocalDateTime.now();
  }


  /**
   * Mutator method that mutates the entry title.
   * The entry title must not be blank or null otherwise an exception will be thrown.
   *
   * @param entryTitle the new name of the entry title.
   * @throws IllegalArgumentException if the entry title is null or blank.
   */
  public void setEntryTitle(String entryTitle) {
    if (entryTitle == null || entryTitle.isBlank()) {
      throw new IllegalArgumentException("The new title can not be empty!");
    } else {
      this.entryTitle = entryTitle;
      this.lastModified = LocalDateTime.now();
    }
  }


  /**
   * Mutator method that mutates the activity type of  workout session.
   * The activity type cannot be null or blank otherwise an IllegalArgumentException will be thrown.
   *
   * @param activityType the activity type of  workout session.
   * @throws IllegalArgumentException if the activity type is null or blank.
   */
  public void setActivityType(String activityType) {
    if (activityType == null || activityType.isBlank()) {
      throw new IllegalArgumentException("Please enter the new activity type!");
    } else {
      this.activityType = activityType;
      this.lastModified = LocalDateTime.now();
    }
  }


  /**
   * Mutator method that mutates the duration (minutes) of the workout session.
   * The duration of the workout session cannot be 0 or negative otherwise an
   * IllegalArgumentException will be thrown.
   *
   * @param durationMinutes the duration of the workout session (minutes).
   * @throws IllegalArgumentException if the duration is 0 or negative.
   *
   */
  public void setDurationMinutes(int durationMinutes) {
    if (durationMinutes > 0) {
      this.durationMinutes = durationMinutes;
      this.lastModified = LocalDateTime.now();
    } else {
      throw new IllegalArgumentException("Duration must be more than 0 minutes");
    }
  }


  /**
   * Mutator method that mutates the intensity level of the workout session.
   * The intensity level must be in the valid range (1-10).
   *
   * @param intensityLevel the intensity level of the workout session.
   * @throws IllegalArgumentException if the intensity level is out of the valid range (1-10).
   */
  public void setIntensityLevel(int intensityLevel) {
    if (intensityLevel > 0 && intensityLevel <= 10) {
      this.intensityLevel = intensityLevel;
      this.lastModified = LocalDateTime.now();
    } else {
      throw new IllegalArgumentException("New intensity level must be between 1 and 10!");
    }

  }

  /**
   * Accessor method that returns the author.
   *
   * @return the author of the diary entry.
   */
  public Author getAuthor() {
    return this.author;
  }


  /**
   * Accessor method that returns diary entry title.
   *
   * @return the title of a diary entry.
   */
  public String getEntryTitle() {
    return entryTitle;
  }


  /**
   * Accessor method that returns the activity type of workout session.
   *
   * @return the activity type of workout session.
   */
  public String getActivityType() {
    return activityType;
  }


  /**
   * Accessor method that return the duration of the workout session.
   *
   * @return the duration of the workout session.
   */
  public int getDurationMinutes() {
    return durationMinutes;
  }

  /**
   * Accessor method that return the intensity level of the workout session.
   *
   * @return the intensity level of the workout session.
   */
  public int getIntensityLevel() {
    return intensityLevel;
  }

  /**
   * Accessor method that returns the creation date and time for the workout entry.
   *
   * @return the creation date of the workout entry.
   */
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  /**
   * Accessor method that returns the last time the diary entry was last modified.
   *
   * @return the last time the diary entry was last modified.
   */
  public LocalDateTime getLastModified() {
    return lastModified;
  }


}

