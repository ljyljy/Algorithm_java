package ReverseInteger;

public class ReverseInteger {
    //BASIC
//    public class reverseIntegerV1 {
//        /*
//         * @param number: A 3-digit number.(1)
//         * @return: Reversed number.
//         */
//        public int reverseInteger(int number) {
//            // write your code here
//            return number % 10 * 100 + number / 10 % 10 * 10 + number / 100;
//        }
//    }

   /*
    (2) [ReverseInteger]
    将一个整数中的数字进行颠倒，当颠倒后的整数溢出时，返回 0 (标记为 32 位整数)。

    样例
    给定 x = 123，返回 321
    给定 x = -123，返回 -321
    */
   /*
     * @param n: the integer to be reversed
     * @return: the reversed integer
     */
   public static int reverseIntegerV2(int n) {
       int reversed_n = 0;
       while(n != 0){
           int temp = reversed_n * 10 + n % 10;//将每次获取的n的末位数（ n % 10）加到自己本身的个位（reversed_n * 10 + n % 10）
           n = n / 10;
           if(temp / 10 != reversed_n){//出现了异常情况(整数过大溢出)
               //注意判断溢出，溢出返回0.
               reversed_n = 0;
               break;
           }
           reversed_n = temp;
       }
       return reversed_n;
   }
   public static void main(String[] args){
       int n = -875426;
       int reversed_n = reverseIntegerV2(n);
       System.out.println(reversed_n);
   }
}
