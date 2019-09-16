// TL;DR holds two students that are matched.

public class StudentPair {
    public Student s1;
    public Student s2;

    public StudentPair(Student s1, Student s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    // Returns the string with the appropriate amount of spaces between names
    public String returnString(int max) {
        String ret = s1 + " ";

        for (int i = 0; i < max - s1.toString().length(); i++) {
            ret += " ";
        }

        ret += " " + s2;
        return ret;
    }

    // Changes the student pair to avoid mutability
    public void changeTo(StudentPair pair) {
        this.s1 = pair.s1;
        this.s2 = pair.s2;
    }

    // Clones the student pair to avoid mutability
    public StudentPair clone() {
        return new StudentPair(new Student(s1.firstName, s1.lastName), new Student(s2.firstName, s2.lastName));
    }
}
