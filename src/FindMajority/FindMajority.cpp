/*
1.已知给定的N个整数A[1…N]存在绝对众数，以最低的时空复杂度计算该绝对众数。
(若某众数出现次数多于n/2，则称作绝对众数)


#include <iostream>
#include <cstdlib>
using namespace std;

int Mode(int* a, int size){
    int cnt = 0;
    int m = a[0];
    for(int i = 0; i<size; i++){
        if(cnt == 0){
            m = a[i];
            cnt = 1;
        }else if(m != a[i]){

        }else{// m == a[i]
            cnt++;
        }
    }
    return m;
}

int main()
{
    int a[] = {8,1,1,8,1,1,6,1,5,8,8};
    int m = Mode(a, sizeof(a)/sizeof(int));
    cout<<m<<endl;
    return 0;
}
*/


/*
二、1/k 众数 、 [要求：时间复杂度O(N), 空间复杂度O(k)]
1、如k=3时,求给定数组中的1/3众数。（即该众数的出现次数> N/3）
注：有可能这样的数不存在。
要求：时间复杂度O(N), 空间复杂度O(1)
*/
    #include <iostream>
    #include <cstdlib>
    #include <vector>
    #include <iterator>
    using namespace std;

    void FindMode(const int *a, int size, vector<int>& mode){
    int m,n;//候选值
    int cm = 0, cn = 0;//候选值m、n的个数
    int i;
    for(i=0; i<size; i++){
        if(cm == 0){
            m = a[i];
            cm = 1;
        }else if(cn == 0){
            n = a[i];
            cn = 1;
        }else if(m == a[i]){
            cm++;
        }else if(n == a[i]){
            cn++;
        }else{
            cm--;
            cn--;
        }
    }
    //↑ 运行到此处时的m、n一定是众数，同时也是可能存在的1/3众数。

    cm = cn = 0;//为确保一定存在（因为1/3众数可能不存在），一定要重新遍历统计出现次数
    for(i=0; i<size; i++){
        if(m == a[i]){
            cm++;
        }else if(n == a[i]){
            cn++;
        }
    }
    if(cm > size/3){
        mode.push_back(m);
//        cout<< m<<" ";
    }
    if(cn > size/3){
        mode.push_back(n);
//        cout<< n<<" ";
    }

}

void Print(vector<int> vector){
    for(int i=0; i<vector.size(); i++){
        cout<< vector[i]<<" ";
    }
    cout<<endl;
}

int main()
{
    int a[] = {8,1,1,8,1,1,6,1,5,8,8};
    vector<int> mode;
    FindMode(a, sizeof(a)/sizeof(int),mode);
    Print(mode);
    return 0;
}