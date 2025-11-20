package edu.ntnu.iir.bidata;

/**
 * This class represents an immutable author object in the diary.
 * Each author receives a unique ID number to make them unique despite if they have the same name.
 *
 * @author Tri Minh Luong
 * @version 1.0
 */

public final class Author {
  private final String name;
  private static int newId = 1; // A counter for ID to give each author a unique ID
  private final int id;


  /**
   * Constructor that initializes a new author with name and a unique ID.
   *
   * @param name the name of the author.
   * @throws IllegalArgumentException if the name of the author is blank or null.
   */
  public Author(String name) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("Name of author cannot be null or blank");
    }
    this.name = name;
    // Each author object receives an ID when they are initialized,
    // increases for next object.
    this.id = newId++;

  }

  /**
   * An accessor method to get the ID of each author object.
   *
   * @return the ID of the author object.
   */
  public int getId() {
    return id;
  }


  /**
   * An accessor method to get the name for an author.
   *
   * @return the name of the author.
   */
  public String getName() {
    return name;
  }


  /**
   * Compares two author objects by their ID number to check for uniqueness.
   * Each object is unique by their given ID number not their name.
   *
   * @param obj the reference object with which to compare.
   * @return true if both author objects has the same id, false if they don't.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Author other)) {
      return false;
    }
    return this.id == other.id;
  }


  /**
   * Uses the same field to match equals method.
   * Auto generates hash value for each author ID.
   *
   * @return a hash value from the ID of the author.
   */
  @Override
  public int hashCode() {
    return Integer.hashCode(id);
  }

  /**
   * Displays a string representation of the author and their ID number
   * to show unique authors by the same name.
   *
   * @return the name of the author as a string and ID number of author.
   */
  @Override
  public String toString() {
    return name + " (ID: " + id + ")";
  }
}



