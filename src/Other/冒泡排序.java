package Other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by lujingyi on 2017/5/24.
 */
public class 冒泡排序 {
    static final int SIZE=10;
    public static void bubbleSort(int[] arr){
        int tmp;
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<arr.length-i;j++){
                if(arr[j]<arr[j+1]){
                    tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
            System.out.print("第"+i+"步：");
            for(int k=0;k<arr.length;k++){
                System.out.print(" "+arr[k]);
            }
            System.out.println();
        }
        printArr(arr);

    }
    public static void printArr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args){
        int arr[]=new int[SIZE];
        int i;
        for(i=0;i<arr.length;i++) {
            arr[i] = (int) (Math.random() * (101));
        }
        //赋值后 删除重复
        for(i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                while (arr[i]==arr[j]){
                    arr[i] = (int) (Math.random() * (101));
                }
            }
        }

        System.out.print("排序前：");
        printArr(arr);
//法①：降序排序
        Arrays.sort(arr);
        System.out.print("\n\n先升序：");   printArr(arr);

        List list=new ArrayList();
        for(i=0;i<arr.length;i++){
            list.add(arr[i]);
        }
        Collections.reverse(list);
        System.out.print("\n降序排序后：");
        list.forEach(obj->System.out.print(obj+" "));

//法②：降序排序：
        System.out.println("\n冒泡排序后：");
        bubbleSort(arr);

    }
}
