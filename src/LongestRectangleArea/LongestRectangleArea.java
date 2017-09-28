package LongestRectangleArea;

import java.util.Stack;


/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
find the area of largest rectangle in the histogram.
 [no image]
Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 [no image]
The largest rectangle is shown in the shaded area, which has area = 10 unit.
 */

public class LongestRectangleArea {
        public static int largestRectangleArea(int[] height) {
            if (height == null || height.length == 0) {
                return 0;
            }
            Stack<Integer> stack = new Stack<Integer>();    //为方便计算横向距离width，存入栈中的是height[]各个元素的索引，而非值！
            int max = 0;
            for (int i = 0; i <= height.length; i++) {
                //当遍历到最后一个元素时，i为height.length，已经跑出了height[]数组。
                //trick：此时,为保证数组最后一个元素的最大矩形面积也被计算，
                //       增加height[height.length] = -1
                int curt = (i == height.length ? -1 : height[i]);//此句勿漏！！！
                while (!stack.isEmpty() && /*height[i]*/ curt <= height[stack.peek()]) {
                    //非if-clause!!!
                    int h = height[stack.pop()];
                    //注意：①栈中存入的是height[]的下标！②每次计算的都是新栈顶的最大矩形，其他的元素不参与计算。故为pop(), 非peek()
                    int width = stack.isEmpty()? i : i - stack.peek() - 1;
                    int answer = h * width;
                    max = Math.max(answer, max);
                }
                stack.push(i);
            }
            return max;
        }
        public static void main(String[] args){
            int[] height = {2,1,5,6,2,3};
            int maxArea = largestRectangleArea(height);
            System.out.println(maxArea);
        }
}
