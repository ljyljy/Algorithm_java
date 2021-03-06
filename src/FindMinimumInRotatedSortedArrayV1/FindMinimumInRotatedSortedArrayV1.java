package FindMinimumInRotatedSortedArrayV1;

public class FindMinimumInRotatedSortedArrayV1 {
    public static int findMin(int[] nums){
        if(nums==null || nums.length==0){
            return -1;
        }
        int start = 0;
        int end = nums.length-1;
        int target = nums[nums.length-1];

        while (start+1 < end){
            int mid = start + (end-start)/2;
            if(nums[mid] > target){
                start = mid;
            }else {
                end = mid;
            }
        }
//        if (nums[start] <= target) {
//            return nums[start];
//        } else {
//            return nums[end];
//        }
        return nums[start] <= target ? nums[start]:nums[end];
    }
    public static void main(String[] args){
        int[] nums = {4,5,6,7,0,1,2};
        int min = findMin(nums);
        System.out.println(min);
    }
}
