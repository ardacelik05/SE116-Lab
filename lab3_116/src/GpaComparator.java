import java.util.Comparator;
public class GpaComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1 ,Student s2){
    if (s2.getGpa() > s1.getGpa()) return 1;
    if (s2.getGpa() < s1.getGpa()) return -1;
    return 0;
    }
}
