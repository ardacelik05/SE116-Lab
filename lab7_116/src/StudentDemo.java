import java.util.ArrayList;
import java.util.Collections;
public class StudentDemo {
    public static void main(String[] args) {

        ArrayList<Student> stdlist = new ArrayList<>();

        stdlist.add(new Student (101,"Arda",20,50));
        stdlist.add(new Student(102,"helin",30,20));
        stdlist.add(new Student(103,"ekin",70,80));
        stdlist.add(new Student(104,"bahar", 33,44));

        StudentManager manager = new StudentManager();

        for (Student s : stdlist) {
            s.displayInfo();

            if (manager.checkStudent(s, std -> std.getGrade() >= 30 && std.getGrade() <= 40)) {
                double newGrade = manager.applyGradeOperation(s, g -> 40.0);
                s.setGrade(newGrade);
            }

            if (manager.checkStudent(s, std -> std.getGrade() >= 85 && std.getGrade() <= 90)) {
                double newGrade = manager.applyGradeOperation(s, g -> 90);
                s.setGrade(newGrade);
            }

            System.out.println("Normalized grade: " + s.getGrade());

            s.setGrade(
                    manager.applyGradeOperation(s, grade -> {
                        if (manager.checkStudent(s, st -> st.getPerformanceGrade() > 75)) {
                            return grade + 5;
                        } else {
                            return grade;
                        }
                    })
            );

            System.out.println("Final grade: " + s.getGrade());
            boolean passed = manager.checkStudent(s, st -> st.getGrade() >= 60);
            System.out.println("Status: " + (passed ? "Passed" : "Failed"));
        }
            Collections.sort(stdlist, (s1, s2) -> Double.compare(s1.getGrade(), s2.getGrade()));

            System.out.println("\n--- Sorted by Grade (Ascending) ---");
            for (Student m : stdlist) m.displayInfo();

            Collections.sort(stdlist, (s1, s2) -> s1.getName().compareTo(s2.getName()));

            System.out.println("\n--- Sorted by Name (Alphabetical) ---");
            for (Student m : stdlist) m.displayInfo();
        }

    }

