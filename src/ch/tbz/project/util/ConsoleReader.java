package ch.tbz.project.util;

import ch.tbz.project.model.*;

import java.sql.Time;
import java.util.Scanner;

public class ConsoleReader {
  private static Scanner scan = new Scanner(System.in);

  /**
   * Prints the instruction for the User on what to do
   *
   * @param instruction Is the Instruction, also a question to the User
   */
  private static void printInstruction(String instruction) {
    System.out.print(instruction + "\n>");
  }

  /**
   * Reads an Integer and catches Exception. Asks until User has given a valid answer
   *
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
   *
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

      if (input.trim().length() == 0) continue;

      break;
    }
    return input;
  }

  /**
   * Reads a Time and catches Exception. Asks until User has given a valid answer
   *
   * @param instruction Is the Instruction, also a question to the User
   * @return input
   */
  public static Time readTime(String instruction) {
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
   *
   * @param instruction Is the Instruction, also a question to the User
   * @return input
   */
  public static Color readColor(String instruction) {
    Color input;
    while (true) {
      try {
        printInstruction(instruction);
        int colorIndex = readInteger(getColorsMenu());
        input = Color.values()[colorIndex - 1];
      } catch (IndexOutOfBoundsException arrayex) {
        System.out.println("Index is invalid");
        continue;
      }

      break;
    }

    return input;
  }

  /**
   * Reads a Sponsor and catches Exception. Asks until User has given a valid answer
   *
   * @param instruction Is the Instruction, also a question to the User
   * @return input
   */
  public static Sponsor readSponsor(String instruction) {
    Sponsor input;
    while (true) {
      try {
        printInstruction(instruction);
        int sponsorIndex = readInteger(getSponsorsMenu());
        input = Sponsor.values()[sponsorIndex - 1];
      } catch (IndexOutOfBoundsException arrayex) {
        System.out.println("Index is invalid");
        continue;
      }

      break;
    }

    return input;
  }

  /**
   * Reads a Brand and catches Exception. Asks until User has given a valid answer
   *
   * @param instruction Is the Instruction, also a question to the User
   * @return input
   */
  public static Brand readBrand(String instruction) {
    Brand input;
    while (true) {
      try {
        printInstruction(instruction);
        int brandIndex = readInteger(getBrandsMenu());
        input = Brand.values()[brandIndex - 1];
      } catch (IndexOutOfBoundsException arrayex) {
        System.out.println("Index is invalid");
        continue;
      }

      break;
    }

    return input;
  }

  /**
   * Reads a Gender and catches Exception. Asks until User has given a valid answer
   *
   * @param instruction Is the Instruction, also a question to the User
   * @return input
   */
  public static Gender readGender(String instruction) {
    Gender input;
    while (true) {
      try {
        printInstruction(instruction);
        int genderIndex = readInteger(getGendersMenu());
        input = Gender.values()[genderIndex - 1];
      } catch (IndexOutOfBoundsException arrayex) {
        System.out.println("Index is invalid");
        continue;
      }

      break;
    }

    return input;
  }

  /**
   * Reads a Position and catches Exception. Asks until User has given a valid answer
   *
   * @param instruction Is the Instruction, also a question to the User
   * @return input
   */
  public static Position readPosition(String instruction) {
    Position input;
    while (true) {
      try {
        printInstruction(instruction);
        int positionIndex = readInteger(getPositionsMenu());
        input = Position.values()[positionIndex - 1];
      } catch (IndexOutOfBoundsException arrayex) {
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
  private static String getColorsMenu() {
    int i = 1;
   StringBuilder colors = new StringBuilder();
    for (Color color : Color.values()) {
      colors.append("[").append(i).append("] ").append(color.name()).append("\n");
      i++;
    }
    return colors.toString();
  }

  /**
   * Displays all the Sponsor
   */
  private static String getSponsorsMenu() {
    int i = 1;
    StringBuilder sponsors = new StringBuilder();
    for (Sponsor sponsor : Sponsor.values()) {
      sponsors.append("[").append(i).append("] ").append(sponsor.name()).append("\n");
      i++;
    }
    return sponsors.toString();
  }

  /**
   * Displays all the Brand
   */
  private static String getBrandsMenu() {
    int i = 1;
    StringBuilder brands = new StringBuilder();
    for (Brand brand : Brand.values()) {
      brands.append("[").append(i).append("] ").append(brand.name()).append("\n");
      i++;
    }
    return brands.toString();
  }

  /**
   * Displays all the Gender
   */
  private static String getGendersMenu() {
    int i = 1;
    StringBuilder genders = new StringBuilder();
    for (Gender gender : Gender.values()) {
      genders.append("[").append(i).append("] ").append(gender.name()).append("\n");
      i++;
    }
    return genders.toString();
  }

  /**
   * Displays all the Position
   */
  private static String getPositionsMenu() {
    int i = 1;
    StringBuilder positions = new StringBuilder();
    for (Position position : Position.values()) {
      positions.append("[").append(i).append("] ").append(position.name()).append("\n");
      i++;
    }
    return positions.toString();
  }
}
