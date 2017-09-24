package Other;

/**
 * Created by ljyljy on 2017/7/10.
 */
public class studentDemo {
    public static void main(String[] args){
        student s1= student.getStudent();
        student s2= student.getStudent();
        System.out.println(s1==s2);
        //student.s=null;
        //student类中的实例对象s以为私有成员，外界不可修改
    }
}
