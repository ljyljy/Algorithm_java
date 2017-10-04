package FindPeakElement;

/*
Find Peak Elemen
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1],
    3 is a peak element and your function should return the index number 2.
 */
public class FindPeakElement {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public static int findPeak(int[] A) {
        int start = 1, end = A.length-2; // 1.答案在之间，2.不会出界
        while(start + 1 <  end) {
            int mid = (start + end) / 2;
            if(A[mid] < A[mid - 1]) {
                end = mid;
            } else if(A[mid] < A[mid + 1]) {// && (A[mid] >= A[mid - 1])
                start = mid;
            } else {//if((A[mid] >= A[mid - 1]) || (A[mid] >= A[mid + 1]))
                end = mid;
            }
        }
        if(A[start] < A[end]) {
            return end;
        } else {
            return start;
        }
    }

    public static void main(String[] args){
        int[] a = {0,1,2,5,3,1,7,5,2,3,-2};
        int index = findPeak(a);
        System.out.println(index);
    }
}
