/*
//法①
#include <iostream>
#include <cstdlib>
#include <vector>
#include <iterator>

using namespace std;

int LocalMaximum(const int* a, int size){
    int left = 0, right = size - 1, mid;
    while (left < right) {
        mid = (left + right) / 2;
        cout<< "mid: " << mid<<endl;
        if(a[mid]>a[mid+1]){
            right = mid;
        }else{
            left = mid+1;//勿忘+1！！！
        }
    }
    return left;
}

int main()
{
    int a[] = {0,1,2,5,3,1};
    int ret = LocalMaximum(a, sizeof(a)/sizeof(int));
    cout<< "局部最大值下标：" << ret <<endl;
    return 0;
}
*/

//法②
#include <iostream>
#include <cstdlib>
#include <vector>
#include <iterator>

using namespace std;

int LocalMaximum(const int* a, int size){
    if(!a || size == 0) return -1;
    int left = 0, right = size - 1, mid;
    while (left + 1 < right) {
        mid = (left + right) / 2;
        cout<< "mid: " << mid<<endl;
        if(a[mid]>a[mid+1]){
            right = mid;
        }else{
            left = mid;
        }
    }
    return a[left] > a[right] ? left : right;
}

int main()
{
    int a[] = {0,1,2,5,3,1};
    int ret = LocalMaximum(a, sizeof(a)/sizeof(int));
    cout<< "局部最大值下标：" << ret <<endl;
    return 0;
}