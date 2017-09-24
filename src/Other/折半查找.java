package Other;

/**
 * Created by lujingyi on 2017/5/25.
 */
public class 折半查找 {
    public static final int SIZE=10;
    static void quickSort(int[] arr,int left,int right){
        int f,tmp,ltemp,rtemp;
        ltemp=left;rtemp=right;
        f=arr[(left+right)/2];

        while (ltemp<rtemp){
            while (arr[ltemp]<f){
                ++ltemp;
            }
            while (arr[rtemp]>f){
                --rtemp;
            }
            if(ltemp<=rtemp){
                tmp=arr[rtemp];
                arr[rtemp]=arr[ltemp];
                arr[ltemp]=tmp;
                ++ltemp;
                --rtemp;
            }
        }
        if(ltemp==rtemp){
            ltemp++;
        }
        if(ltemp<right){
            quickSort(arr,rtemp+1,right);
        }
        if(rtemp>left){
            quickSort(arr,left,ltemp-1);
        }
    }

    public static void main(String[] args){

    }
}
