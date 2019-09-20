import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

// Name: Zachary Verlardi
// Date: 9/16/19
// Lab Name: Student Grouping

public class Main {
    // Instantiate variables
    private static ArrayList<Student> studentList;
    private static ArrayList<Student> randomizedList;
    private static ArrayList<StudentPair> pairs;
    private static Student[] student = {
            student("Adrianna", "Bordonaro"),
            student("Julian", "DeLucia"),
            student("Pardesh", "Dhakal"),
            student("Agranya", "Ketha"),
            student("Sharon", "Lin"),
            student("Patrick", "Lioanag"),
            student("Ananya", "Nadendla"),
            student("Benjamin", "Osias"),
            student("Jordan", "Ryder"),
            student("Amith", "Shetty"),
            student("Filip", "Sigda"),
            student("Humna", "Sultan"),
            student("Harish", "Sundar"),
            student("Elijah", "Uribe"),
            student("Sai", "Veeramachaneni"),
            student("Zachary", "Verlardi")
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 1;

            // Instantiate Variables
            studentList = new ArrayList<Student>();
            randomizedList = new ArrayList<Student>();
            pairs = new ArrayList<StudentPair>();
            Collections.addAll(studentList, student);
            Random random = new Random();

            // Randomize the randomizedList array list.
            // This randomly takes out students from the studentList variable until it is empty
            while (!studentList.isEmpty()) {
                int rindex = random.nextInt(studentList.size());
                Student rStudent = studentList.get(rindex);

                randomizedList.add(rStudent);
                studentList.remove(rindex);
            }

            // Create pairs with a round robin system now that the array has been randomized.
            for (int i = 0; i < randomizedList.size(); i++) {
                StudentPair pair = new StudentPair(randomizedList.get(i), randomizedList.get((i + 1 == randomizedList.size()) ? 0 : i + 1));

                pairs.add(pair);
            }

        while (choice != 0) {
            ArrayList<StudentPair> alphabet = alphabetize(pairs, choice);

            int length = longestLength(alphabet);

            // This student is just used to line up Tester and Coder with the other names since there is already a method for a student pair
            StudentPair pseudoStudent = new StudentPair(student("Tester:", ""), student("Coder:", ""));

            System.out.println(pseudoStudent.returnString(length));

            System.out.println("-------------------------------------------");

            // Print out all of the other alphabetized lists.
            for (StudentPair a : alphabet) {
                System.out.println(a.returnString(length));
            }

            // Give the use an option to resort the list via different metrics

            System.out.println();
            System.out.println("Would you like to: ");
            System.out.println("1. Resort by Tester First Name");
            System.out.println("2. Resort by Tester Last Name");
            System.out.println("3. Resort by Coder First Name");
            System.out.println("4. Resort by Coder Last Name");
            System.out.println("5. Close Program");
            System.out.println();

            choice = scanner.nextInt();

            System.out.println();
        }
    }

    // Just a cleaner way to instantiate the original list ArrayList
    private static Student student(String firstName, String lastName) {
        return new Student(firstName, lastName);
    }

    // Alphabetize the ArrayList with different choices.
    private static ArrayList<StudentPair> alphabetize(ArrayList<StudentPair> arrayList, int organization) {
        ArrayList<StudentPair> array = (ArrayList<StudentPair>) arrayList.clone();

        boolean compareTo = false;
        while (!compareTo) {
            compareTo = true;
            for (int i = 0; i < array.size() - 1; i++) {
                int compare = 0;
                switch (organization) {
                    case 1:
                        compare = array.get(i).s1.firstName.compareTo(array.get(i + 1).s1.firstName);
                        break;
                    case 2:
                        compare = array.get(i).s1.lastName.compareTo(array.get(i + 1).s1.lastName);
                        break;
                    case 3:
                        compare = array.get(i).s2.firstName.compareTo(array.get(i + 1).s2.firstName);
                        break;
                    case 4:
                        compare = array.get(i).s2.lastName.compareTo(array.get(i + 1).s2.lastName);
                        break;
                    default:
                        System.out.println("Shutting Down");
                        System.exit(0);
                }
                if (compare > 0) {
                    StudentPair swap = array.get(i).clone();
                    array.get(i).changeTo(array.get(i + 1));
                    array.get(i + 1).changeTo(swap);
                    compareTo = false;
                }
            }
        }

        return array;
    }

    // Finds the longest name for formatting to line up the names
    private static int longestLength(ArrayList<StudentPair> array) {
        // Determines the length of the longest name so that the names can be neat and lined up
        int longest = 0;

        // If either of the persons' (Sai's) names are longer than the established longest, set that to the longest
        for (StudentPair pair : array) {
            String name1 = pair.s1.toString();

            if (longest < name1.length()) {
                longest = name1.length();
            }
        }

        return longest;
    }
}