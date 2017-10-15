//package MathPackage;
//import java.util.*;
//
//
//class note{
//    int[] arr = new int[100];
//}
//
//public class TrueTable {
//
//    public static StringBuffer infixExpression = new StringBuffer();//中缀表达式
//    public static List<StringBuffer> postfixExpression = new ArrayList<>();   //后缀表达式(ljy: 原char[])
//    public static String alpha = "";   //存放所有字母变量
//    public static Map<Character,Integer> M = new HashMap<>();   //映射，将字母变量与0或1一一对应
//
//    public static  Vector<note> trueTable;  //不定长数组，存放主析取范式对应字母变量的01情况，也就是表达式真值为T
//    public static Vector<note> falseTable;  //不定长数组，存放主合取范式对应字母变量的01情况，也就是表达式真值是F
//
//    /**
//     *预处理
//     *去除中缀表达式中条件->中的'>', 和双条件<=>中的 '=' 和 '>' ,
//     * 将这两个运算符当成一个字符处理，更方便
//     *
//     * while的内层for循环：
//     *     凡遇到'>'或'='(from "->" 或 "<=>")，则将其从中缀表达式中删除。并重新进入while循环。
//     */
//    public static void precompute(){
//        int flag = 1;
//        while (flag == 1){
//            flag = 0;
//            for(int i=0;i<infixExpression.length();i++){
//                if(infixExpression.charAt(i)=='>'||infixExpression.charAt(i)=='='){
//                    infixExpression.deleteCharAt(i);
//                    flag = 1;
//                    break;
//                }
//            }
//        }
//    }
//
//    //incoming priority(栈外优先级)
//    public static int icp(char a)
//    {
//        if(a=='#') return 0;
//        if(a=='(') return 12;
//        if(a=='!') return 10;
//        if(a=='&') return 8;
//        if(a=='|') return 6;
//        if(a=='-') return 4;
//        if(a=='<') return 2;
//        if(a==')') return 1;
//
//        return 0;
//    }
//
//    //in-stack priority
//    public static int isp(char a)
//    {
//        if(a=='#') return 0;
//        if(a=='(') return 1;
//        if(a=='!') return 11;
//        if(a=='&') return 9;
//        if(a=='|') return 7;
//        if(a=='-') return 5;
//        if(a=='<') return 3;
//        if(a==')') return 12;
//
//        return 0;
//    }
//
//    /*
//     * Convert infixExpression To Reverse Polish Notation(postfixExpression)
//     */
//    public static void convertToPost(){
//        int j = 0;
//        Stack<Character> stack = new Stack<>();
//        char ch,y;
//        stack.push('#');
//        char t1,t2;
////        for()
//    }
//
//
//    public static void main(String[] args){
//
//    }
//}