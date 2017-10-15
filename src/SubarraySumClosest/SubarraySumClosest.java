package SubarraySumClosest;
/*
最接近零的子数组和
给定一个整数数组，找到一个和最接近于零的子数组。返回第一个和最有一个指数。你的代码应该返回满足要求的子数组的起始位置和结束位置


样例
给出[-3, 1, 1, -3, 5]，返回[0, 2]，[1, 3]， [1, 1]， [2, 2] 或者 [0, 4]。

挑战
O(nlogn)的时间复杂度
 */

import java.util.Arrays;
import java.util.Comparator;

class Pair{
    int sum;
    int index;
    public Pair(int sum, int index){
        this.sum = sum;
        this.index = index;
    }

}

public class SubarraySumClosest {
    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */

    public int[] subarraySumClosest(int[] nums) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0){
            return res;
        }
        int len = nums.length;
        if(len == 1){
            res[0] = res[1] = 0;
            return res;
        }
        Pair[] prefixSums = new Pair[len+1];
        int prev = 0;
        prefixSums[0] = new Pair(0, 0);
        for(int i = 1; i <= len; i++){
            prefixSums[i] = new Pair(prev + nums[i-1], i);
            //prefixSum[i] = prefixSum[i-1].sum + nums[i-1]
            //      -->prefixSum[i] 代表 前i个数之和，也就是 下标区间在 0 ~ i-1 这一段的和，
            //    而 prefixSum[i-1].sum是 前 0 ~ i-2 的和。(故 prefixSum[i] = 前 0 ~ i-2 的和 + nums[i-1])

            //prefixSums[1] = new Pair(0 + nums[0], 1);
            //prefixSums[2] = new Pair(prefixSums[1].sum + nums[1], 2);
            //    即 prefixSums[2].sum = prefixSums[1].sum + nums[1] = nums[0] + nums[1];
            //prefixSums[3] = new Pair(prefixSums[2].sum + nums[2], 2);
            //    即 prefixSums[3].sum = prefixSums[2].sum + nums[2] = nums[0] + nums[1] + nums[2];
            prev = prefixSums[i].sum;
        }
        Arrays.sort(prefixSums, new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.sum - b.sum;
            }
        });
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= len; i++){
            //WHY？
            if (ans > prefixSums[i].sum - prefixSums[i-1].sum) {
                ans = prefixSums[i].sum - prefixSums[i-1].sum;
                int[] temp = new int[]{prefixSums[i].index - 1, prefixSums[i-1].index - 1};
                Arrays.sort(temp);
                res[0] = temp[0] + 1;
                res[1] = temp[1];
            }
        }
        return res;
    }
}