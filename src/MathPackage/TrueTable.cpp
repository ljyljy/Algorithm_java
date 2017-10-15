//利用真值表求主析/合取范式.cpp
//或运算 |  , 与运算 &   ,单条件 ->  ,双条件 <=> ,非运算 !

#include <cstdio>
#include <iostream>
#include <vector>
#include <string>
#include <cstdlib>
#include <queue>
#include <stack>
#include <map>
#include <sstream>
#include <cmath>
#include <regex>
using namespace std;
string infixExpression; //中缀表达式
char postfixExpression[1000]; //后缀表达式
string alpha; //存放所有字母变量
map<char,int> M; //映射，将字母变量与0或1一一对应

struct note
{
    int a[100];
};
vector<note> trueTable; //不定长数组，存放主析取范式对应字母变量的 /1情况，也就是表达式真值为T
vector<note> falseTable;    //不定长数组，存放主合取范式对应字母变量的0/1情况，也就是表达式真值是F

/**
 * 预处理:
 *  去除中缀表达式中条件->中的'>', 和双条件<=>中的 '=' 和 '>' ,
 *  将这两个由多个字符组成的运算符分别当成某个字符处理，更方便
 *
 * while的内层for循环:
 *     凡遇到'>'或'='(from "->" 或 "<=>")，则将其从中缀表达式中删除。并重新进入while循环。
 */
void precompute()
{
    string::iterator i=infixExpression.begin();
    int flag=1;
    while(flag)
    {
        flag=0;
        for(i = infixExpression.begin(); i != infixExpression.end(); ++i)
        {
            if(*i=='>')
            {
                infixExpression.erase(i);
                flag=1;
                break;
            }
            if(*i=='=')
            {
                infixExpression.erase(i);
                flag=1;
                break;
            }
        }
    }
}

int icp(char a)//incoming priority(栈外优先级)
{
    if(a=='#') return 0;
    if(a=='(') return 12;
    if(a=='!') return 10;
    if(a=='&') return 8;
    if(a=='|') return 6;
    if(a=='-') return 4;
    if(a=='<') return 2;
    if(a==')') return 1;

    return 0;
}
int isp(char a)//in-stack priority
{
    if(a=='#') return 0;
    if(a=='(') return 1;
    if(a=='!') return 11;
    if(a=='&') return 9;
    if(a=='|') return 7;
    if(a=='-') return 5;
    if(a=='<') return 3;
    if(a==')') return 12;

    return 0;
}

/*
 * Convert infixExpression To ReversePolishNotation(postfixExpression)
 */
void convertToPost()    //中缀表达式转换后缀表达式,并存储于栈s中
{
    int j=0;
    stack<char> s;
    char ch,y;
    s.push('#');

    stringstream ss(infixExpression);
    regex pattern(".*[A-Za-z]{2,}.*");

    const char* p = infixExpression.c_str();

    if(regex_match( infixExpression, pattern ) /*|| !MatchParentheses(p)*/){
        printf("error input!\n");
        exit(0);
    }

    while(ss >> ch, ch != '#')
    {
        if(isalpha(ch))//①判断字符ch是否为英文字母，若为小写字母，返回2，若为大写字母，返回1。若不是字母，返回0
        {
            postfixExpression[j++] = ch;
            if(alpha.find(ch) == -1)//若输入的中缀表达式中的字母ch不在alpha中，则将其追加在alpha字符串后。
            {
                alpha.push_back(ch);
            }
        }
        else if(ch==')')//②去括号操作。
        {
            for(y=s.top(),s.pop();y!='(';y=s.top(),s.pop())
            {
                postfixExpression[j++]=y;
            }
        }
        else if(ch =='(' || ch == '|'||ch == '&'||ch =='!'||ch =='-'||
              ch == '<')   //③：对非"()"的运算符(<=>、->、|、&、!)的处理：icp(ch)<=isp(y)时，y出栈并输出于postfixExpression[j++]中。
        {
            for(y=s.top(),s.pop();icp(ch)<=isp(y);y=s.top(),s.pop())
            {
                postfixExpression[j++]=y;
            }
            s.push(y);//icp(ch)>isp(y): 刚弹出栈顶操作符的优先级低时，将其重新压栈
            s.push(ch);// 接着，将扫描到的ch压栈
        }
        else{

            cout<<"ERROR INPUT!"<<endl;
            exit(0);
        }
    }
    while(!s.empty())//ch=='#'，将栈s中的剩余项（运算符）输出到postfixExpression[j++]中
    {
        y=s.top();
        s.pop();
        if(y!='#')
        {
            postfixExpression[j++]=y;
        }
    }
    postfixExpression[j]='#';
}

int calc()  //对转换后的后缀表达式进行计算求真值
{
    stack<int> s;
    char ch;
    int j=0;
    int t1,t2;
    while(1)
    {
        ch=postfixExpression[j];
        if(ch=='#') break;
        if(ch==0) break;
        j++;
        if((ch>='A'&&ch<='Z')||(ch>='a'&&ch<='z'))
        {
            s.push(M[ch]);//将M[ch]对应的int型真值（1或0）压栈
        }
        else
        {
            if(ch=='!')
            {
                t1=s.top();
                s.pop();
                s.push(!t1);
            }
            else if(ch=='&')
            {
                t1=s.top();
                s.pop();
                t2=s.top();
                s.pop();
                if(t1==1&&t2==1)
                {
                    s.push(1);
                }
                else
                {
                    s.push(0);
                }
            }
            else if(ch=='|')
            {
                t1=s.top();
                s.pop();
                t2=s.top();
                s.pop();
                if(t1==0&&t2==0)
                {
                    s.push(0);
                }
                else
                {
                    s.push(1);
                }
            }
            else if(ch=='-')//指代"t2->t1"
            {
                t1=s.top();
                s.pop();
                t2=s.top();
                s.pop();
                if(t1==0&&t2==1)
                {
                    s.push(0);
                }
                else
                {
                    s.push(1);
                }
            }
            else if(ch=='<')//指代"t2<=>t1"(异或取反/真值相同)
            {
                t1=s.top();
                s.pop();
                t2=s.top();
                s.pop();
                if((t1==1&&t2==1)||(t1==0&&t2==0))
                {
                    s.push(1);
                }
                else
                {
                    s.push(0);
                }
            }
        }
}
    int ans=s.top();
    return ans;
}

/* 深搜: 递归枚举每一种字符变量的取值情况
 *   cur: 当前命题数组(alpha[])中的某个命题(如：P/Q/R)
 *   M[alpha[i]]: 命题alpha[i]所对应的真值
 *
 * 思路: 对转换后的后缀表达式进行计算求真值, 找到当前命题(alpha[i])
 *   所对应的真值(M[alpha[i]]),打印真值表。
 *
 * DFS注意点: ①递归终止条件。②递归分解
 */
void dfs(int cur)
{
    if(cur==alpha.size())
    {
        int ans=calc();
        for(int i=0;i<alpha.size();i++)
        {
            if(M[alpha[i]])
            {
                cout<<"T\t";
            }
            else
            {
                cout<<"F\t";
            }
        }
        if(ans==1)  //真值为T  计入到trueTable数组，以待后面主析取范式使用
        {
            cout<<"T"<<endl;
            note t;
            for(int i=0;i<alpha.size();i++)
            {
                t.a[i]=M[alpha[i]];
            }
            trueTable.push_back(t);
        }
        else    //真值为F  计入到falseTable数组，以待后面主合取范式使用
        {
            cout<<"F"<<endl;
            note t;
            for(int i=0;i<alpha.size();i++)
            {
                t.a[i]=M[alpha[i]];
            }
            falseTable.push_back(t);
        }
        return ;//①递归终止条件。回调。
    }
    M[alpha[cur]]=1;//②递归分解: 先假设当前命题(alpha[cur])为True，递归。
    dfs(cur+1);
    M[alpha[cur]]=0;//②递归分解: 再假设当前命题(alpha[cur])为false，递归。
    dfs(cur+1);
}
void BinToDec(string binary){
    int sum = 0;
    int n = binary.size();
    //        cout<<"\nstr3.size():"<<str3.size()<<endl;//输出调试
    for(int i = 0; i < n; i++){
    //            cout<<"\npow(2,"<< i<<"):"<<pow(2,i)<<endl;//输出调试
    //            cout<< "str3["<< i<<"]-'0':"<<str3[i]<<endl;//输出调试

        sum += (binary[i]-'0')*pow(2,n-i-1);
    //             cout<<"sum-ing:"<< sum <<endl;//输出调试
    }
    cout<<sum;
}

//函数功能实现反了，应该是二进制转十进制。该方法弃用。
//void BinToDec(string binary, int n){
//    int sum = 0;
//
//    for(int i = 0; i < n; i++){
//        cout<<"\nbinary[i]:"<<binary[i];
//        sum += binary[i]*pow(2,i);
//    }
//    cout<<sum;
//}
//    void BinToDec(string binary, int n){
//    stack<int> s;
////    cout<<"\n s.empty():"<<s.empty()<<endl;
//    while (binary) // 只要binary不等于0就循环
//        //从binary为用户输入的十进制数开始，一直到binary等于0为止
//    {
//        s.push(binary % 2);// binary除以2的余数(二进制的低位)入栈
//
//        //先压入的余数是八进制的低位，后压入的余数是二进制的高位
//        binary /= 2; //令binary等于binary整除以2的商，进入下轮循环
//    }
//    //输出s
//    while (!s.empty()) {
//        int token = s.top();
//        s.pop();
//        cout<<token;
//    }
//}
/*----------输出----------*/
// 无需用到queue，直接用string即可。故弃用。
//void printQueue(queue<int> &queue){
//    if(queue.empty())
//        return;
//    while (!queue.empty()) {
//        int token = queue.front();
//        queue.pop();
//        cout<<token;
//    }
//}

void printStr(string s,int n){
    for(int i=0;i<n;i++){
        cout<<s[i];
    }
}

int main()
{
    vector<string> vectorStr;
    int i;
    M.clear();
    alpha.clear();
    trueTable.clear();
    falseTable.clear();
    cout<<"或运算为 |  , 与运算为 &   ,单条件为 ->  ,双条件为 <=> ,非运算为 !\n" << endl;
    cout<<"请输入表达式,回车结束\n" << endl;
    cin>>infixExpression;
    infixExpression.append("#");
    precompute();
    convertToPost();
    for(i=0;i<alpha.size();i++)
    {
        cout<<alpha[i]<<"\t";
    }
    cout<<"表达式真值"<<endl;
    dfs(0);

    /*--------------主析取范式-----------------*/
    //trueTable[i].a: 合式公式为true的trueTable中的，第i行数组a[]。
    cout<<"主析取范式为"<<endl;//小、析、true
    int lena=trueTable.size();
    cout<<"① ";
    for(i=0;i<lena;i++)
    {
        if(i!=0) cout<<" ∨ ";
        int *p=trueTable[i].a;//真值表中第i行。从合式公式为true的trueTable中打印。指针p指向数组a的首地址。
        cout<<"(";
        for(int j=0;j<alpha.size();j++)
        {
            if(j!=0) cout<<"∧";
            if(p[j]==1)
            {
                cout<<alpha[j];
            }
            else
            {
                cout<<"￢"<<alpha[j];
            }
        }
        cout<<")";
    }

        cout<<"\n② ";
        for(i=0;i<lena;i++)
        {
            string str1 = "";
            //            queue<int> queue;
            if(i!=0)
                cout<<" ∨ ";
            cout<<"m";
            int *p=trueTable[i].a;
            for(int j=0;j<alpha.size();j++)
            {
                if(p[j]==1){
                str1 += "1";
                //                queue.push(1);
                }
                else{
                    str1 += "0";
                //                queue.push(0);
                }
            }
            int size1 = sizeof(str1)/sizeof(int);
            printStr(str1, size1);
            //            printQueue(queue);
        }

    cout<<"\n③ ";
    cout<<"Σ";
    for(i=0;i<lena;i++)
    {
        string str1 = "";
        if(i!=0) cout<<",";
        int *p=trueTable[i].a;//当前指针指向合式公式真值为false的真值表中，第i个
        for(int j=0;j<alpha.size();j++)
        {
            if(p[j]==0)
            {
                str1 += "0";
            }
            else
            {
                str1 += "1";
            }
        }
    //        cout<<"\nstr3:"<<str3<<endl;//输出调试
    //        cout<<"n:"<<n<<endl;//输出调试
        BinToDec(str1);
    }

    /*--------------主合取范式-----------------*/
    cout<<"\n主合取范式为\n";//大、合、false
    cout<<"①";
    for(i=0;i<falseTable.size();i++)
    {
        if(i!=0) cout<<" ∧ ";
        int *p=falseTable[i].a;
        cout<<"(";
        for(int j=0;j<alpha.size();j++)
        {
            if(j!=0) cout<<"v";
            if(p[j]==0)
            {
                cout<<alpha[j];
            }
            else
            {
                cout<<"￢"<<alpha[j];
            }
        }
        cout<<")";
    }
    cout<<"\n② ";
    //        for(i=0;i<falseTable.size();i++)//弃用
    //        {
    //            queue<int> queue2;
    //            if(i!=0) cout<<" ∧ ";
    //            int *p=falseTable[i].a;//当前指针指向合式公式真值为false的真值表中，第i个
    //            cout<<"M";
    //            for(int j=0;j<alpha.size();j++)
    //            {
    //                if(p[j]==0)
    //                {
    //                    queue2.push(1);
    //                }
    //                else
    //                {
    //                    queue2.push(0);
    //                }
    //            }
    //            printQueue(queue2);
    //        }
    for(i=0;i<falseTable.size();i++)
    {
        string str2 = "";
        if(i!=0) cout<<" ∧ ";
        int *p=falseTable[i].a;//当前指针指向合式公式真值为false的真值表中，第i个
        cout<<"M";
        for(int j=0;j<alpha.size();j++)
        {
            if(p[j]==0)
            {
                str2 += "0";
            }
            else
            {
                str2 += "1";
            }
        }
        int size2 = sizeof(str2)/sizeof(int);
        printStr(str2,size2);
    }

    cout<<"\n③ ";
    cout<<"Π";
    for(i=0;i<falseTable.size();i++)
    {
        string str3 = "";
        if(i!=0) cout<<",";
        int *p=falseTable[i].a;//当前指针指向合式公式真值为false的真值表中，第i个
        for(int j=0;j<alpha.size();j++)
        {
            if(p[j]==0)
            {
                str3 += "0";
            }
            else
            {
                str3 += "1";
            }
        }
//        cout<<"\nstr3:"<<str3<<endl;//输出调试
//        cout<<"n:"<<n<<endl;//输出调试
        BinToDec(str3);
    }

    cout<<"\n\n";

    return 0;
}
/*-----------end-----------*/






//
////附1：
///*----------弃用的方法---------*/
////@deprecated
//bool IsLeftParentheses(char c)
//{
//    return (c == '(');
//}
////@deprecated
//bool IsMatch(char left, char c)
//{
//    if(left == '(')
//        return c == ')';
//    return false;
//}
////@deprecated
//bool MatchParentheses(const char* p)
//{
//    stack<char> s;
//    char cur;//current
//    while (*p) {
//        cur = *p;
//        if(IsLeftParentheses(cur)){
//            s.push(cur);//将左括号压栈
//        }else{//当前为右括号：看当前栈s中是否有与之匹配的左括号（栈顶s.top()）
//            if(s.empty() || !IsMatch(s.top(), cur))//若栈已经为空，说明缺少左括号与之匹配
//                return false;
//            s.pop();//若与栈顶（离cur最近的左括号）匹配，则将与之匹配的左括号从栈s中弹出。
//        }
//        p++;
//        }
//        if(s.empty()){
//            cout<<"括号不匹配！"<<endl;
//        }
//    return s.empty();//看最后栈s中有无未匹配的左括号 -> 若有，则括号不匹配。
//}
//
///*-----------弃用的方法-----------*/


////附2：
/*----------后期异常处理测试----------*/
//#include <cstdio>
//#include <iostream>
//#include <string>
//#include <regex>
//#include "../deelx.h"
//using namespace std;
//
////将old value从元字符串中去除
//string   replace_all(string   str,const   string&   old_value1,const   string&   old_value2,const   string&   new_value)
//{
//    while(true)   {
//        string::size_type   pos(0);
//        if(   (pos=str.find(old_value1))!=string::npos )
//            str.replace(pos,old_value1.length(),new_value);
//        else if( (pos=str.find(old_value2))!=string::npos ){
//            str.replace(pos,old_value2.length(),new_value);
//        }else
//            break;
//    }
//    return   str;
//}
//
//int main()
//{
//regex1
//^!{0,1}[A-Za-z]{1}(((->)?|(<=>)?|(|)?|(&)?){1}(!{0,1}[A-Za-z]{1}))*$
//
//regex2
//^\(*!{0,1}[A-Za-z]{1}\)*\(*((->)?|(<=>)?|(|)?|(&)?){1}\)*\(*!{0,1}[A-Za-z]{1}\)* (\(*((->)?|(<=>)?|(|)?|(&)?){1}\)*\(*!{0,1}[A-Za-z]{1}\)*)*$
//
//
//    string s = "(P->Q&R)<=>Y";
//     string ss = replace_all(s, "(",")", "");
//    cout<<ss<<endl;
//    regex pattern1(".*[A-Za-z]{2,}.*");
//
//        if(regex_search(s, pattern1)){
//            printf("Error Input!\n");
//        }
//        else
//        {
//            printf("Bingo!\n");
//        }
//
//
/*------------ "deelx.h"-------------*/
//    //	// 表达式对象
//    //	CRegexpT <char> re("^{0,1}!{0,1}[A-Za-z]{1} ((->)?|(<=>)?|(|)?|(&)?){1} !{0,1}[A-Za-z]{1}$", IGNORECASE | SINGLELINE | EXTENDED);
//    //
//    //	// 匹配结果
//    //	MatchResult result = re.MatchExact("P->Q");
//    //
//    //	if (result.IsMatched()) {
//    //		printf("Bingo!\n");
//    //	}
//    //	else
//    //	{
//    //		printf("Error Input\n");
//    //	}
//    return 0;
//}


