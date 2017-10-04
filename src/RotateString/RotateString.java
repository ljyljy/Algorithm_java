package RotateString;

/*
 [旋转字符串]

（1）给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
（2）给定一个字符串S[0…N-1]，要求把S的前K个字符移动到S的尾部，如把字符串“abcdef”前面的2个字符‘a’、‘b’移动到字符串的尾部，得到新字符串“cdefab”：即字符串循环左移K。
循环左移n+k位和k位的效果相同。
循环左移k位等价于循环右移n-k位。

样例
对于字符串 “abcdefg”.

offset=0 => “abcdefg”
offset=1 => “gabcdef”
offset=2 => “fgabcde”
offset=3 => “efgabcd”

算法要求：
时间复杂度为O（n），空间复杂度为O（1）。
挑战
在数组上原地旋转，使用O(1)的额外空间
 */
public class RotateString {
    public static void rotateString(char[] str, int offset) {
        if (str == null || str.length == 0)
            return;//coding style:上来先判断null和0！！！

        offset = offset % str.length;//保护取余

//        第一步：对整个字符串逆转；[第一步、第二步可以互换，即①可以调至③后（②③①）]
//        第二步：分别逆转两个子字符串（两个子字符串是题目告诉我们的，是基于左旋多少位来计算的）；
        reverse(str, 0, str.length - 1);
        reverse(str, 0, offset - 1);
        reverse(str, offset, str.length - 1);
    }

    private static void reverse(char[] str, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }

    public static void printStr(char[] str){
        for(char c : str){
            System.out.print(c+" ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        char[] chars = {'a','b','c','d','e','f','g'};
        rotateString(chars,3);
        printStr(chars);
    }
}
