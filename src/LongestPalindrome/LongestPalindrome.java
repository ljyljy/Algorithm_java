package LongestPalindrome;

import java.util.HashSet;
import java.util.Set;

/*
        [Longest Palindrome]
        Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
        This is case sensitive, for example “Aa” is not considered a palindrome here.
        Notice
        Assume the length of given string will not exceed 1010.

        给出一个包含大小写字母的字符串。求出由这些字母构成的最长的回文串的长度是多少。

        数据是大小写敏感的，也就是说，”Aa” 并不会被认为是一个回文串。
        i 注意事项

        假设字符串的长度不会超过 1010。

        样例
        给出 s = “abccccdd” 返回 7
        一种可以构建出来的最长回文串方案是 “dccaccd”。

        tags
        Hash Table, Amazon
*/
public class LongestPalindrome {
    public static int longestPalindromeNum(String s) {
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            if(set.contains(c)){//
                set.remove(c);//将重复的元素 从set中删去
            }else{
                set.add(c);//set中只保留不重复的元素
            }
        }
        int remove = set.size();//remove为不重复元素的个数
        if(remove > 0){
            remove -= 1;//若remove>0,最后返回的个数应+1，也就是删去的个数-1
            //（because it can be put in the middle）
        }
        return s.length() - remove;
    }
    public static void main(String[] args){
        String s = "abccccdd";
        int num = longestPalindromeNum(s);
        System.out.println(num);
    }
}
