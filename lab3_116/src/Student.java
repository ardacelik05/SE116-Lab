public class Student implements Comparable<Student> {
    private int studentID;
    private double gpa;
    private String name;

        public Student(int studentID, String name, double gpa){
            this.studentID=studentID;
            this.name=name;
            this.gpa=gpa;
        }

    public int getStudentID() {
        return studentID;
    }
    public String getName(){
            return name;
    }
    public double getGpa(){
            return gpa;
    }
    public void setStudentID(int studentID){
            this.studentID=studentID;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public void setName(String name){
            this.name=name;
    }

    public void printInfo(){
        System.out.printf("Student name is: %s / Student id is: %d / student gpa is: %.2f%n" ,name,studentID,gpa);
    }

    @Override
    public int compareTo(Student other) {
        return this.studentID - other.studentID;
    }

}
