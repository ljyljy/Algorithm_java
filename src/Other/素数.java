package Other; /**
 * Created by lujingyi on 2017/5/24.
 */

//打印3-100的素数
public class 素数 {
    public static void main(String[] args){
        System.out.println("3-100的素数：");
        boolean isPrime;
        int count=0;
        for(int i=3;i<=100;i++){
            isPrime=true;
            for(int j=2;j<=Math.sqrt(i);j++) {//或j<=i/2
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            //for循环结束后 再判断！
                if(isPrime){
                    System.out.print(i+"\t");
                    count++;
                    if(count%5==0){
                        System.out.println();
                    }
                }
            }
    }
}
