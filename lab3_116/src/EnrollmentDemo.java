import java.util.Collections;
public class EnrollmentDemo {
    public static void main(String[] args) {
        Student s1 = new Student(2020, "arda", 2.4);
        Student s2 = new Student(1010, "helin", 1.2);
        Student s3 = new Student(3030, "ekin", 2.5);
        Student s4 = new Student(11, "bahar", 4.0);
        s1.printInfo();
        s2.printInfo();
        s3.printInfo();
        s4.printInfo();


        Course mycourse = new Course("se115", "introduction programming");
        mycourse.addStudent(s1);
        mycourse.addStudent(s2);
        mycourse.addStudent(s3);
        mycourse.addStudent(s4);

        System.out.println("\n--- Student Details ---");

        mycourse.displayEnrolledStudents();

        System.out.println("öğrenci sayısı " + mycourse.getEnrolledStudentSize());

        mycourse.removeStudentbyID(11);
        mycourse.removeStudentbyID(22);
        System.out.println("öğrenci sayısı " + mycourse.getEnrolledStudentSize());

        Collections.sort(mycourse.getEnrolledStudents());
        System.out.println("\n--- Sorted by ID (Ascending) ---");
        mycourse.displayEnrolledStudents();

// 2. GPA'ya göre sıralama (Comparator kuralı çalışır)
        Collections.sort(mycourse.getEnrolledStudents(), new GpaComparator());
        System.out.println("\n--- Sorted by GPA (Descending) ---");
        mycourse.displayEnrolledStudents();
            }
}
