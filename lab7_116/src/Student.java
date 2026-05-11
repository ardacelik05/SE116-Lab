
public class Student {
private int id;
private String name;
private double grade;
private double performanceGrade;

    public Student(int id, String name, double grade, double performanceGrade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.performanceGrade = performanceGrade;
    }
    public void setGrade(double grade){
        this.grade=grade;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public double getPerformanceGrade() {
        return performanceGrade;
    }

    public void displayInfo(){
        System.out.println("ID: " + id);
        System.out.println("Name:" + name);
        System.out.println("Grade: " + grade);
        System.out.println("Performance grade: " + performanceGrade);
    }
}