package Other; /**
 * Created by lujingyi on 2017/7/6.
 */
import java.util.Scanner;

public class os2 {
    public static void add2(String n1, String n2) {
        StringBuffer result = new StringBuffer();

        // 1、反转字符串
        n1 = new StringBuffer(n1).reverse().toString();
        n2 = new StringBuffer(n2).reverse().toString();

        int len1 = n1.length();
        int len2 = n1.length();
        int maxLen = len1 > len2 ? len1 : len2;
        boolean nOverFlow = false; // 是否越界

        // 2.把两个字符串补齐，即短字符串的高位用0补齐
        if (len1 < len2) {
            for (int i = len1; i < len2; i++) {
                n1 += "0";
            }
        } else if (len1 > len2) {
            for (int i = len2; i < len1; i++) {
                n2 += "0";
            }
        }

        // 3.把两个正整数相加，一位一位的加并加上进位
        int nTakeOver = 0; // 溢出数量
        for (int i = 0; i < maxLen; i++) {
            int nSum = Integer.parseInt(n1.charAt(i) + "") + Integer.parseInt(n2.charAt(i) + "");
            if ((nSum + nTakeOver) >= 10) {
                if (i == (maxLen - 1)) {
                    nOverFlow = true;
                }
                result.append(nSum + nTakeOver - 10);
                nTakeOver=1;
            } else {
                result.append(nSum + nTakeOver);
                nTakeOver = 0;
            }
        }

        // 如果溢出的话表示位增加了
        if (nOverFlow) {
            result.append(1);
        }
//        String strr=n1 + " + " + n2 + " = " + result.reverse().toString();
//        return strr;
        System.out.println(n1 + " + " + n2 + " = " + result.reverse().toString());
    }

    public static void main(String[] args){
        String a,b;
        int T;
        Scanner sc2=new Scanner(System.in);
        T=sc2.nextInt();

//        Scanner sc=new Scanner(System.in);
//        while (sc.hasNextLine()) {
//            a = sc.nextLine();
//            b = sc.nextLine();
//            add2(a, b);
//        }
//        String strr="";

            int i=1;
            Scanner sc=new Scanner(System.in);
            String[] aa=new String[T-1];

            while (sc.hasNextLine()) {
                for(int ii=0;ii<T-1;ii++){
                    a = sc.nextLine();
                    b = sc.nextLine();
                    System.out.println("Case " + (i++) + ":");
                    add2(a,b);
//                strr=add2(a, b);
//                System.out.println(a+"\n"+b);
//                System.out.println(strr);
                }
             }
//        for(int k=0;k<T;k++){
//            System.out.println("Case " + (i++) + ":");
//            System.out.println(aa[k]);
//            System.out.println();
//        }

    }
}

