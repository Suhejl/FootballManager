package ch.tbz.project.util;

import ch.tbz.project.model.Brand;
import ch.tbz.project.model.Color;
import ch.tbz.project.model.Sponsor;

import java.sql.Time;
import java.util.Scanner;

public class ConsoleReader {
  private static Scanner scan = new Scanner(System.in);

  /**
   * Prints the instruction for the User on what to do
   * @param instruction Is the Instruction, also a question to the User
   */
  private static void printInstruction(String instruction) {
    System.out.print(instruction + "\n>");
  }

  /**
   * Reads an Integer and catches Exception. Asks until User has given a valid answer
   * @param instruction Is the Instruction, also a question to the User
   * @return input
   */
  public static int readInteger(String instruction) {
    int input;
    while (true) {
      try {
        printInstruction(instruction);
        input = Integer.parseInt(scan.nextLine());
      } catch (NumberFormatException nuex) {
        System.out.println("Number format is invalid");
        continue;
      }
      break;
    }
    return input;
  }

  /**
   * Reads a String and catches Exception. Asks until User has given a valid answer
   * @param instruction Is the Instruction, also a question to the User
   * @return input
   */
  public static String readString(String instruction) {
    String input;
    while (true) {
      try {
        printInstruction(instruction);
        input = scan.nextLine();
      } catch (NumberFormatException nuex) {
        continue;
      }

      if(input.trim().length() == 0) continue;

      break;
    }
    return input;
  }

  /**
   * Reads a Time and catches Exception. Asks until User has given a valid answer
   * @param instruction Is the Instruction, also a question to the User
   * @return input
   */
  public static Time readTime(String instruction){
    Time input;
    while (true) {
      try {
        printInstruction(instruction);
        input = Time.valueOf(scan.nextLine());
      } catch (IllegalArgumentException illexargex) {
        System.out.println("Time format is invalid");
        continue;
      }

      break;
    }

    return input;
  }

  /**
   * Reads a Color and catches Exception. Asks until User has given a valid answer
   * @param instruction Is the Instruction, also a question to the User
   * @return input
   */
  public static Color readColor(String instruction){
    Color input;
    while (true) {
      try {
        printInstruction(instruction);
        displayColors();
        input = Color.values()[readInteger("") - 1];
      } catch (ArrayIndexOutOfBoundsException arrayex) {
        System.out.println("Index is invalid");
        continue;
      }

      break;
    }

    return input;
  }

  /**
   * Reads a Sponsor and catches Exception. Asks until User has given a valid answer
   * @param instruction Is the Instruction, also a question to the User
   * @return input
   */
  public static Sponsor readSponsor(String instruction){
    Sponsor input;
    while (true) {
      try {
        printInstruction(instruction);
        displaySponsors();
        input = Sponsor.values()[readInteger("") - 1];
      } catch (ArrayIndexOutOfBoundsException arrayex) {
        System.out.println("Index is invalid");
        continue;
      }

      break;
    }

    return input;
  }

  /**
   * Reads a Brand and catches Exception. Asks until User has given a valid answer
   * @param instruction Is the Instruction, also a question to the User
   * @return input
   */
  public static Brand readBrand(String instruction){
    Brand input;
    while (true) {
      try {
        printInstruction(instruction);
        displayBrands();
        input = Brand.values()[readInteger("") - 1];
      } catch (ArrayIndexOutOfBoundsException arrayex) {
        System.out.println("Index is invalid");
        continue;
      }

      break;
    }

    return input;
  }

  /**
   * Displays all the Colors
   */
  private static void displayColors(){
    int i = 1;
    System.out.println();
    for (Color color : Color.values()) {
      System.out.println("[" + i +"] " + color.name());
      i++;
    }
  }

  /**
   * Displays all the Sponsor
   */
  private static void displaySponsors(){
    int i = 1;
    System.out.println();
    for (Sponsor sponsor : Sponsor.values()) {
      System.out.println("[" + i +"] " + sponsor.name());
      i++;
    }
  }

  /**
   * Displays all the Brand
   */
  private static void displayBrands(){
    int i = 1;
    System.out.println();
    for (Brand brand : Brand.values()) {
      System.out.println("[" + i +"] " + brand.name());
      i++;
    }
  }

}
