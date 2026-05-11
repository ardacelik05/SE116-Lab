import java.util.ArrayList;
public class Course {
    private String courseCode;
    private String courseName;
    private ArrayList<Student> enrolledStudents;

    public Course(String courseCode, String courseName){
        this.courseCode=courseCode;
        this.courseName=courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public void addStudent(Student s){
            enrolledStudents.add(s);
        System.out.println("enrolled succesfully " +s.getName());
            }


            public void displayEnrolledStudents(){
                System.out.println("-----enrolled students----- "+ courseCode);
                for (Student s : enrolledStudents){
                    s.printInfo();
                }
    }

    public void removeStudentbyID(int id){
        boolean bulundu=false;
     for(int i= 0;i<enrolledStudents.size();i++){

         if(enrolledStudents.get(i).getStudentID() == id){
             enrolledStudents.remove(i);
             System.out.println("Student [" + id + "] has been removed.");
             bulundu=true;
             break;
         }
         }
        if (!bulundu){
            System.out.println("id bulunamadı ");
     }
    }

    public int getEnrolledStudentSize(){
        return enrolledStudents.size();
        }
    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
}

