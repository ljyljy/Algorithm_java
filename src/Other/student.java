package Other;

/**
 * Created by ljyljy on 2017/7/10.
 */
public class student {
    //构造方法私有化
    private student(){}
    //1.静态方法只能访问静态成员变量
    //2.为了外界不可直接修改，加private
    private static student s=new student();

    //提供公共的对外访问方式
    //为了保证外界（main）课直接使用该方法，要用静态
    public static student getStudent(){
        return s;
    }
}
