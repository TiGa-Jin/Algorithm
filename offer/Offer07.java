/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
package offer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Offer07 {
    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> indexMap){
        if(preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int indexRoot = indexMap.get(root.val);//获得根节点再在中序遍历中的数组编号

        int leftNums = indexRoot - inStart;//根节点左子树节点的个数

        root.left = myBuildTree(preorder, inorder, preStart + 1, preStart + leftNums, inStart, indexRoot - 1, indexMap);
        root.right = myBuildTree(preorder, inorder, preStart + leftNums + 1, preEnd, indexRoot + 1, inEnd, indexMap);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap =  new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            indexMap.put(inorder[i], i);
        }
        int preStart = 0;
        int preEnd = preorder.length - 1; ;
        int inStart = 0;
        int inEnd = inorder.length - 1;

        return myBuildTree(preorder, inorder, preStart, preEnd, inStart, inEnd, indexMap);

    }

    public static void main(String[] args) {

        int[]  preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        Offer07 offer07 = new Offer07();
        TreeNode treeNode = offer07.buildTree(preorder, inorder);
        System.out.println(treeNode.val);


    }
}

