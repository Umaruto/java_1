import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.HashSet;

class StudentManager {
    private int id;
    private String name;
    private int age;
    HashSet<String> courses;

    public StudentManager(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        courses = new HashSet<>();
    }

    public void updateDetails(int id, String name, int age) {
        System.out.println("Student with ID " + this.id + " has updated.");
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void enrollToCourse(String course){
        this.courses.add(course);
        System.out.println(name + " has enrolled to " + course + " succesfully!");
    }

    public String getDetails() {
        return "Name: " + name + ", Age: " + age;  // Customize as needed
    }

    public int getId() {
        return id;

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public HashSet<String> getCourses() {
        return courses;
    }
}


public class SMSCF {
    public static void main(String[] args) {
        HashMap<Integer, StudentManager> students = new HashMap<>();

        StudentManager s = new StudentManager(100, "Umar", 19);
        addStudent(students, s);
        s.enrollToCourse("Java Programming");
        System.out.println("");


        StudentManager s2 = new StudentManager(101, "Deko", 18);
        addStudent(students, s2);
        s2.enrollToCourse("Python Programming");
        s2.updateDetails(103, "Barko", 19);
        System.out.println("");

        StudentManager s3 = new StudentManager(102, "Kolya", 20);
        addStudent(students, s3);
        s3.enrollToCourse("Java Programming");
        System.out.println("");

        System.out.println("");
        listStudentsByCourse(students , "Java Programming");

        displayAllStudentsSortedById(students);
        System.out.println("");

        searchStudentById(students, 102);
        System.out.println("");

        removeStudent(students, 102);
        System.out.println("");

        displayAllStudentsSortedById(students);
    }

    public static void removeStudent(HashMap<Integer, StudentManager> students, int id) {
        if (students.containsKey(id)) {
            students.remove(id);
            System.out.println("Student with ID " + id + " has been removed from list.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public static void addStudent(HashMap<Integer, StudentManager> students, StudentManager studentManager){
        students.put(studentManager.getId(), studentManager);
        System.out.println(studentManager.getName() + " has added to list");
    }

    public static void displayAllStudentsSortedById(HashMap<Integer, StudentManager> students) {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        TreeMap<Integer, StudentManager> sortedStudents = new TreeMap<>(students);

        for (Map.Entry<Integer, StudentManager> studen : sortedStudents.entrySet()) {
            int id = studen.getKey();
            StudentManager student = studen.getValue();
            System.out.println("ID: " + id + ", " + student.getDetails());
        }
    }

    public static void searchStudentById(HashMap<Integer, StudentManager> students, int id) {
        if (students.containsKey(id)) {
            StudentManager student = students.get(id);
            System.out.println("ID: " + id + ", " + student.getDetails());
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public static void listStudentsByCourse(HashMap<Integer, StudentManager> students, String courseName) {
        boolean found = false;

        for (Map.Entry<Integer, StudentManager> student1 : students.entrySet()) {
            StudentManager student = student1.getValue();


            if (student.getCourses().contains(courseName)) {
                System.out.println("ID: " + student1.getKey() + ", " + student.getDetails());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No students enrolled in the course: " + courseName);
        }
    }

}
