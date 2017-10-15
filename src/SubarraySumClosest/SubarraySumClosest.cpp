#include <iostream>
#include <cstdlib>
#include <algorithm>

using namespace std;

int MinSubarray(const int* a, int size){
    if(!a || size == 0)
        return NULL;
    int* sum = new int[size+1];
    sum[0]=0;
    int i;
    for(i=0; i<size; i++){
        sum[i+1] = sum[i] + a[i];
    }
    sort(sum, sum+size+1); //sort(start,end,comparator)
    int diff = abs(sum[1]-sum[0]);
    int res = diff;
    for(i=1; i<size; i++){
        diff = abs(sum[i+1] - sum[i]);
        res = min(diff, res);
    }
    delete[] sum;
    return res;
}

int main()
{
    int a[] = {5,7,8,9,-4,1,2,4};
    int ret = MinSubarray(a, sizeof(a)/sizeof(int));
    cout<<ret<<endl;
    return 0;
}

//v2
//class SubarraySumClosest {
//public:
//    /**
//     * @param nums: A list of integers
//     * @return: A list of integers includes the index of the first number
//     *          and the index of the last number
//     */
//    struct node {
//        node(int _value, int _pos):value(_value), pos(_pos) {}
//        int value, pos;
//        bool operator<(const node &o) const{
//            return (value < o.value || value == o.value && pos < o.pos);
//        }
//    };
//    vector<int> subarraySumClosest(vector<int> nums){
//        vector<node> s;
//        vector<int> results(2);
//        s.push_back(node(0,-1));
//        int sum = 0, len = nums.size();
//        for (int i = 0; i < len ; ++i) {
//            sum += nums[i];
//            s.push_back(node(sum, i));
//        }
//        sort(s.begin(), s.end());
//        len = s.size();
//        int ans = 0x7fffffff;
//        for (int i = 0; i < len-1; ++i)
//            if (abs(s[i+1].value - s[i].value) < ans) {
//                ans = abs(s[i+1].value - s[i].value);
//                results[0] = min(s[i].pos, s[i+1].pos)+1;
//                results[1] = max(s[i].pos, s[i+1].pos);
//            }
//        return results;
//    }
//};
//
