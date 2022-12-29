import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MilesTracker {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int totalMiles = 0;

    try (BufferedReader reader = new BufferedReader(new FileReader("miles.txt"))) {
      String line;
      while ((line = reader.readLine()) != null) {
        totalMiles += Integer.parseInt(line);
      }
    } catch (IOException e) {
      System.out.println("Error reading from file: " + e.getMessage());
    }

    while (true) {
      System.out.println("Enter the number of miles run today (-1 to quit): ");
      int miles = scanner.nextInt();

      if (miles == -1) {
        break;
      }

      totalMiles += miles;
      System.out.println("Total miles run this month: " + totalMiles);

      try (FileWriter writer = new FileWriter("miles.txt", false)) {
        writer.write(Integer.toString(totalMiles) + "\n");
      } catch (IOException e) {
        System.out.println("Error writing to file: " + e.getMessage());
      }
    }
  }
}
