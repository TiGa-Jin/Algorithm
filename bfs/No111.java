package bfs;

import sun.reflect.generics.tree.Tree;

import java.time.temporal.Temporal;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 * 对树进行广度优先遍历，一层一层的从左到右遍历每一个节点，找到第一个叶子节点，所遍历的深度就是
 *
 */

public class No111 {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int minDepth(TreeNode root){
        if(root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);//加入队列
        
        int depth = 1;//root 本身也是一层，初始化为1
        
        while (!q.isEmpty()){
            int sz = q.size();
            
            // 将当前队列中的元素向四周扩散
            for (int i = 0; i < sz; i++) {
                TreeNode cur  = q.poll(); // 移除并返问队列头部的元素    如果队列为空，则返回null

                //判断是否到达终点
                if (cur.left == null && cur.right == null)
                    return depth;

                //将cur的相邻的节点加入队列
                if (cur.left != null)
                    q.offer(cur.left);
                if(cur.right != null)
                    q.offer(cur.right);
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {


    }
}
