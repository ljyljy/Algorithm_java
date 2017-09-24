package Other;

import java.util.*;

/**
 * Created by lujingyi on 2017/5/24.
 */
public class 插入排序ok {
    static final int SIZE=10;
//对应法④
    public static void insertionSort(int[] a){
        int i,j,tmp,h;
        for(i=1;i<a.length;i++){//注意：i的起始点为1！！确保j在i的后面
            tmp=a[i];
            j=i-1;
            while (j>=0 && tmp>a[j]){//降序排列 若后者大于前者（tmp），则将数组后移 然后将后者【tmp】插入空位
                a[j+1]=a[j];//数组后移（产生空位） 前者赋给后者，不可写 a[j]=a[j-1]（越界）
                j--;
            }
            a[j+1]=tmp;//之前j自减，应加1 空位下标为【j+1】
        }
        for(i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }

    public static void main(String[] args){
        int i,j;
        int[] arr=new int[SIZE];
        for(i=0;i<arr.length;i++){
            arr[i]=1+(int)(Math.random()*100+1);
        }
        for(i=0;i<arr.length;i++){//去除重复
            for(j=i+1;j<arr.length-1-1;j++){
                while(arr[i]==arr[j]){
                    arr[i]=(int)(Math.random()*100+1);
                }
            }
        }

//  法①：集合法
        Arrays.sort(arr);
        List list=new ArrayList();
        for(i=0;i<arr.length;i++){
            list.add(arr[i]);
        }
        System.out.println("升序数组：");
        list.forEach(obj->System.out.print(obj+" "));
        System.out.println("\n请输入你要插入的数：");
        Scanner sc=new Scanner(System.in);
        int a0=sc.nextInt();
        list.add(a0);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        list.forEach(obj->System.out.print(obj+" "));

//法②：数组 普通法
        System.out.println("\n----------------------------------\n");
        int[] arr2=new int[SIZE];
        for(i=0;i<arr2.length-1;i++){ //长度设为SIZE，但只给SIZE-1个数赋值,以便后面插入元素
            arr2[i]=1+(int)(Math.random()*100+1);
        }
        for(i=0;i<arr2.length-1;i++){//去除重复
            for(j=i+1;j<arr2.length-2;j++){
                while (arr2[i]==arr2[j]){
                    arr2[i]=(int)(Math.random()*100+1);
                }
            }
        }
        for(i=0;i<arr2.length-1;i++){
            System.out.print(arr2[i]+" ");
        }
        for (i = 0; i < arr2.length - 2; i++)//因为只给n-1个数赋值，所以把它先看做长度为n-1的数组，在未插入新元素时，最大下标看作为n-2
        {
            for (j = 0; j < arr2.length - 2 - i; j++)
            {
                if (arr2[j] > arr2[j + 1])
                {
                    int tmp = arr2[j];
                    arr2[j] = arr2[j + 1];
                    arr2[j + 1] = tmp;
                }
            }
        }
//        法3：不可取！因为会自动在前面补上0！不对！
//        Arrays.sort(arr2);
        int index;
        System.out.println("\n升序后：");
        for(i=0;i<arr2.length-1;i++){
            System.out.print(arr2[i]+" ");
        }
        System.out.println("\n请输入你要插入的数：");
        int key=sc.nextInt();
        for(i=0;i<arr2.length-1;i++){//遍历下标为：0~SIZE-2（因为此时尚未插入元素）
            if (key < arr2[i])
            {
                //index = i;//index用来保存要插入的数的下标
                break;//找到后就不用再找了，节约时间
            }//一直将要插入的数后移至合适的位置，之后再将原先该下标及后面的元素全部后移一格
        }
        index = i;
//index用来临时保存要插入的数的下标 （不要放在循环体内部 因为这样若加入比原数组中都大的数 则会出错，因为可能会无法满足key < arr[i]这一条件，而index = i这一条件是恒成立的，故应放在循环体外！！！！）

        for(i=arr2.length-1;i >=index+1;i--){//i从最大下标起，循环至index+1，数组后移
            arr2[i] = arr2[i - 1];//arr[9]=arr[8];arr[8]=arr[7]...arr[index+1]=arr[index]
        }
        //表示空位已经产生；下面需将key插入arr[index]
        arr2[index] = key;
        for(i=0;i<arr2.length;i++){//最后遍历时 长度为arr2的长度
            System.out.print(arr2[i]+" ");
        }
//        法4：插入排序2(非人为插入元素)
        int[] a=new int[SIZE];
        for(i=0;i<a.length;i++){
            a[i]=(int)(Math.random()*(100+1));
        }
        for(i=0;i<a.length;i++){//去除重复
            for(j=i+1;j<a.length;j++){
                while(a[i]==a[j]){
                    a[i]=(int)(Math.random()*(100+1));
                }
            }
        }
        System.out.println("\n插入排序前：");
        for(i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }

        System.out.println("\n插入排序后：");
        insertionSort(a);


    }
}
