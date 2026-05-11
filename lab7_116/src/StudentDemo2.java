import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class StudentDemo2 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(201, "Arda", 35.0, 80.0));
        students.add(new Student(202, "Helin", 88.0, 70.0));
        students.add(new Student(203, "Ekin", 55.0, 90.0));
        students.add(new Student(204, "Bahar", 32.0, 60.0));

        StudentManager manager = new StudentManager();


        GradeOperation normalizeOp = grade -> {
            if (grade >= 30 && grade <= 40) return 40.0;
            if (grade >= 85 && grade <= 90) return 90.0;
            return grade;
        };

        GradeOperation bonusOp = grade -> grade + 5;

        StudentChecker bonusEligible = s -> s.getPerformanceGrade() > 75;

        StudentChecker passChecker = s -> s.getGrade() >= 60;

        HashMap<String, GradeOperation> gradeOps = new HashMap<>();
        gradeOps.put("normalize", normalizeOp);
        gradeOps.put("addBonus", bonusOp);

        HashMap<String, StudentChecker> checkers = new HashMap<>();
        checkers.put("isEligible", bonusEligible);
        checkers.put("passFail", passChecker);

        for (Student s : students) {
            s.displayInfo(); // [cite: 70]

            double normGrade = manager.applyGradeOperation(s, gradeOps.get("normalize"));
            s.setGrade(normGrade);

            if (manager.checkStudent(s, checkers.get("isEligible"))) {
                double finalGrade = manager.applyGradeOperation(s, gradeOps.get("addBonus"));
                s.setGrade(finalGrade);
            }

            boolean passed = manager.checkStudent(s, checkers.get("passFail"));
            System.out.println("Status: " + (passed ? "Passed" : "Failed"));
            System.out.println("Updated Grade: " + s.getGrade());
            System.out.println("---------------------------");
        }

        Collections.sort(students, (s1, s2) -> Double.compare(s1.getGrade(), s2.getGrade()));
        System.out.println("\n--- Sorted by Grade (Ascending) ---");
        for (Student s : students) s.displayInfo();

        Collections.sort(students, (s1, s2) -> s1.getName().compareTo(s2.getName()));
        System.out.println("\n--- Sorted by Name (Alphabetical) ---");
        for (Student s : students) s.displayInfo();
    }
}