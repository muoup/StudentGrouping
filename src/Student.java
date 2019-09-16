// TL;DR holds the students full name for sorting.

public class Student {
    public String firstName;
    public String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Returns student's full name
    public String toString() {
        return firstName + " " + lastName;
    }
}
