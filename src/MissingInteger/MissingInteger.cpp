/*
在数组 A 中，包含 0 到 n 的整数，其中缺失了一个数。在这一问题中，我们难以仅用一个操作审查数组 A 中的所有整数。
如：
3，5，1，2，-3，7，14，8
输出4.
*/

#include <iostream>
#include <cstdlib>

using namespace std;

int FirstMissingNumber(int* a, int size){//需要在原数组上修改，故不可以传入const int* a
    if(!a || size == 0) return -1;
    a--;
    int i = 1;//从1开始数
    while(i<=size){
        if(a[i] == i){
            i++;
        }else if(a[i]>size|| a[i]<i /*0*/ ||a[i] == a[a[i]]){
            a[i]=a[size];
            size--;
        }else{
            swap(a[i], a[a[i]]);
        }
    }
    return i;
}

int main()
{
    int a[] = {3,5,1,2,-3,7,14,8};
    int ret = FirstMissingNumber(a, sizeof(a)/sizeof(int));
    cout<<ret<<endl;
    return 0;
}