
//二叉树叶子节点之和
//
//        计算二叉树的叶子节点之和
//
//        样例
//        1
//        / \
//        2   3
//        /
//        4
//        的叶子节点之和为 7。
//
//        标签
//        二叉树 二叉树遍历

package BinaryTree;
public class BinaryTreeLeafSum {//DFS
    public static int leafSum(TreeNode root){
        if(root == null){//空
            return 0;
        }
        if(root.left == null && root.right == null){//叶子节点: 直接返回其值
            return root.val;
        }
        return leafSum(root.left) + leafSum(root.right);//递归分解: 普通节点，则递归求和
    }
}
