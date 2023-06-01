package workshop01.pkg3;
import java.util.ArrayList;
import java.util.Scanner;
public class Workshop013 {
    public static void main(String[] args) {
    ArrayList<String> students = new ArrayList<String>();
    Scanner input = new Scanner(System.in);
    System.out.print("Enter student names separated by commas: ");
    String inputNames = input.nextLine();
    String[] names = inputNames.split(",");
    for (String name : names) {
      students.add(name.trim());
    }
    for (int i = 0; i < students.size(); i++) {
      String name = students.get(i);
      students.set(i, name.toUpperCase());
    }
    System.out.println("List of student names:");
    for (String name : students) {
      System.out.println(name);
    }
    }
    
}
