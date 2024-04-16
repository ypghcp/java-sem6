import java.util.*;

public class StudentNames {
    public static void main(String[] args) {
        // Check if command line arguments are provided
        if (args.length == 0) {
            System.out.println("No student names provided. Please provide names as command line arguments.");
            return;
        }

        // Create an ArrayList to store student names
        List<String> studentNamesList = new ArrayList<>();

        // Add command line arguments to the list
        for (String arg : args) {
            studentNamesList.add(arg);
        }

        // Display student names using Iterator interface
        System.out.println("Student Names (using Iterator):");
        Iterator<String> iterator = studentNamesList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Display student names using ListIterator interface (in reverse order)
        System.out.println("\nStudent Names (using ListIterator in reverse order):");
        ListIterator<String> listIterator = studentNamesList.listIterator(studentNamesList.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }
}

