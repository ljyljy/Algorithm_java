package Other;

/**
 * Created by ljyljy on 2017/7/10.
 */
public class TeacherDemo {
    public static void main(String[] args){
        Teacher t1= Teacher.getTeacher();
        Teacher t2= Teacher.getTeacher();
        System.out.println(t1==t2);
    }
}
