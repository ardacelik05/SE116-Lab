/*
 * This prototype was written quickly and may contain style problems,
 * logic errors, boundary bugs, and missing validation.
 * Your task is to improve it without rewriting the assignment from scratch.
 */



/*
Grade criterias that i used:
90-100 -> AA 4,00
85-89-> BA 3,50
80-84-> BB 3,00
75-79 > CB 2,50
70-74 -> CC 2,00
65-69 ->DC 1,50
60-64 -> DD 1,00
50-59 > FD 0,50
0-49 -> FF 0,00

Describtion: This Projects helps to identify lettergrades and than define
coefficent finally program calculates GPA.
g(int x) : calculate şetter grades (AA-BB-CC...)
c(String l) translate letter grade to coeffecent (AA->4.00).
p(ArrayList<Integer> grades) find the lessons that student passed.



Problems:
1-) Naming: Method and array names are hard to understand program what to do (g, c, avg, p),
2-) Logic: letter grades identify wrongly
3-) Logic: in g methods there are invalid letter grades(AB, BC, CD).
4-) Logic: System accept invalid notes like over 100 or negative numbers.
5-)  Run time: i<=grades.size cause IndexOutofBoundsException, i cant equal to size.
 */
import java.util.ArrayList;

public class GradeEstimator {

    public static final int AA_MIN = 90;
    public static final int BA_MIN = 85;
    public static final int BB_MIN = 80;
    public static final int CB_MIN = 75;
    public static final int CC_MIN = 70;
    public static final int DC_MIN = 65;
    public static final int DD_MIN = 60;
    public static final int FD_MIN = 50;

    public static final double AA_COEFF = 4.00;
    public static final double BA_COEFF = 3.50;
    public static final double BB_COEFF = 3.00;
    public static final double CB_COEFF = 2.50;
    public static final double CC_COEFF = 2.00;
    public static final double DC_COEFF = 1.50;
    public static final double DD_COEFF = 1.00;
    public static final double FD_COEFF = 0.50;
    public static final double FF_COEFF = 0.00;

    // method name g->gradeToLetterGrade
    public static String gradeToLetterGrade(int score) {
        if (!isValidGrade(score)) return "INVALID";
        if (score >= AA_MIN) {
            return "AA";
        } else if (score >= BA_MIN) {
            return "BA";
        } else if (score >= BB_MIN) {
            return "BB";
        } else if (score >= CB_MIN) {
            return "CB";
        } else if (score >= CC_MIN) {
            return "CC";
        } else if (score >= DC_MIN) {
            return "DC";
        } else if (score >= DD_MIN) {
            return "DD";
        } else if (score >= FD_MIN) {
            return "FD";
        } else {
            return "FF";
        }
    }

    // check note is valid or not
    public static boolean isValidGrade (int grade){
        return grade >= 0 && grade <= 100;
    }

// method name c-> letterGradeToCoefficient
    public static double letterGradeToCoefficient(String letter) {
        if (letter == null || letter.equals("INVALID")) return 0.0;
        if(letter.equals(("AA"))) return AA_COEFF;
        if (letter.equals("BA")) return BA_COEFF;
        if (letter.equals("BB")) return BB_COEFF;
        if (letter.equals("CB")) return CB_COEFF;
        if (letter.equals("CC")) return CC_COEFF;
        if (letter.equals("DC")) return DC_COEFF;
        if (letter.equals("DD")) return DD_COEFF;
        if (letter.equals("FD")) return FD_COEFF;
        return 0;
    }



    // avg -> calculateGPA
    public static double calculateGpa(ArrayList<Integer> grades, ArrayList<Integer> ects) {
        // Defensive check for null or empty lists
        if (grades == null || ects == null || grades.isEmpty() || grades.size() != ects.size()) {
            return -1.0;
        }

        double totalWeightedPoints = 0;
        int totalECTS = 0;

        // Note:  i <= scores.size() .> (i < scores.size())
        for (int i = 0; i < grades.size(); i++) {
            String letter = gradeToLetterGrade(grades.get(i));
            double coefficient = letterGradeToCoefficient(letter);
            totalWeightedPoints = totalWeightedPoints + (coefficient * ects.get(i));
            totalECTS = totalECTS + ects.get(i);
        }

        return totalWeightedPoints / totalECTS;
    }

    //  method name changed: p -> countPassedCourses
    public static int countPassedCourses(ArrayList<Integer> grades) {
        int passedCount = 0;
        for (int i = 0;  i < grades.size(); i++) {

            if (grades.get(i) >= 60) {
                passedCount++;
            }
        }
        return passedCount;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nGrades = new ArrayList<>();
        ArrayList<Integer> nEcts = new ArrayList<>();
        System.out.println("TEST");
        nGrades.add(90); nGrades.add(72); nGrades.add(58);
        nEcts.add(6); nEcts.add(5); nEcts.add(4);

    }
}
