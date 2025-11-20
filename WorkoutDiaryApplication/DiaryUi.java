package edu.ntnu.iir.bidata;

/**
 * This class is the user-interface for the workout diary application.
 *
 * @author Tri Minh Luong
 * @version 2.1
 */
public class DiaryUi {

  private final DiaryRegister diary = new DiaryRegister();
  private final AuthorRegister author = new AuthorRegister();

  /**
   * Initializes the application entries.
   */
  public void init() {
    Author bjorn = new Author("Bjorn");
    Author polo = new Author("Polo");
    Author olav = new Author("olav");
    Author ola = new Author("ola");

    author.addAuthor(bjorn);
    author.addAuthor(polo);
    author.addAuthor(olav);
    author.addAuthor(ola);


    diary.addDiaryEntry(bjorn, new DiaryEntry(bjorn, "Jumping", "cardio",
        "Fun jumping day, burned the legs", 20, 4));

    diary.addDiaryEntry(polo, new DiaryEntry(polo, "Arm curls", "strength",
        "Really tough arm day, made me get a huge pump", 10, 8));

    diary.addDiaryEntry(olav, new DiaryEntry(olav, "evening run", "cardio",
        "Cold run, need to put on a jacket next time", 15, 2));

    diary.addDiaryEntry(ola, new DiaryEntry(ola, "morning run", "running",
        "Great weather really warm", 45, 7));
  }

  /**
   * Starts the application and prints entries.
   */
  public void start() {
    System.out.println("-WorkoutDiary-");
    for (DiaryEntry obj : diary.getSortedEntries()) {
      printEntry(obj);
      System.out.println("**********");
    }
  }

  /**
   * Prints a diary entry example with details.
   *
   * @param obj the diary entry to print.
   */
  public void printEntry(DiaryEntry obj) {
    System.out.println("Author: " + obj.getAuthor());
    System.out.println("Title: " + obj.getEntryTitle());
    System.out.println("Activity: " + obj.getActivityType());
    System.out.println("Duration: " + obj.getDurationMinutes() + " minutes");
    System.out.println("Intensity: " + obj.getIntensityLevel());
    System.out.println("Diary Text: " + obj.getDiaryText());
    System.out.println("Created at" + obj.getCreatedAt());
  }


}
