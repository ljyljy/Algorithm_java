package Other;

/**
 * Created by lujingyi on 2017/5/24.
 */

//计算1+1/3+...+1/(2*n+1)的和，计算到1/(2*n+1)<0.00001为止
// 【所以，while的条件 应该为tmp>=0.00001】!!!
public class Sum1 {
    static int n=1;
    public static void main(String[] args){

        double sum=1.0,tmp;
        do{
            tmp=1.0/(2*n+1);//1.0!!!!!因为是double 不要让它自动转型为int（失精度）！
            sum+=tmp;
            n++;
        }while (tmp>=0.00001);
        System.out.println("循环结束时的n："+(n-1));
        System.out.println("Result="+sum);

    }
}
