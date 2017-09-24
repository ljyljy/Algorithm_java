package Other;

/**
 * Created by ljyljy on 2017/7/10.
 */
public class Teacher {
    private Teacher(){}
    private static Teacher t=null;

    public synchronized static Teacher getTeacher(){
        if(t==null){
            t=new Teacher();
        }
        return t;
    }
}
