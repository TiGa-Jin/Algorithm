package everyday;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 这里 1 <= n <= 9
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 *

 */
public class No51 {
    //这个问题本质上跟全排列问题差不多，决策树的每一层表示棋盘上的每一行；每个节点可以做出的选择是，在该行的任意一列放置一个皇后。
    List<List<String>> res = new ArrayList<>();

    //直接套用框架
    public List<List<String>> solveNQueens(int n) {

        //初始化
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            board.add(new String(row));
        }

        backtrack(board, 0);

        return res;
    }

    public void backtrack(List<String> board, int row){

        // 触发结束条件
        if (row == board.size()){

            List<String> temp = new ArrayList<>();
            for (int i = 0; i < board.size() ; i++) {
                temp.add(board.get(i));
            }
            res.add(temp);
            return;
        }

        int n = board.get(row).length();

        for (int col = 0; col < n; col++) {
            //  触发结束条件
            if(!isValid(board, row, col))
                continue;

            // 做选择
            char[] str1 = board.get(row).toCharArray();
            str1[col] = 'Q';
            board.set(row, new String(str1));


            //进入下一行决策树
            backtrack(board, row + 1);

            //撤销选择
            char[] str2  = board.get(row).toCharArray();
            str2[col] = '.';
            board.set(row, new String(str2));
        }
    }

    //* 是否可以在 board[row][col] 放置皇后？ */
    public boolean isValid(List<String> board, int row, int col){

        int n = board.size();

        //检查上面列是否有皇后冲突
        for (int i = 0; i < n; i++){
            char[] str = board.get(i).toCharArray();
            if(str[col] == 'Q'){
                return false;
            }

        }

        //检查右上方是否有皇后冲突
        for (int i = row - 1, j = col + 1; (0 <= i) && (j < n); i--, j++) {
            char[] str = board.get(i).toCharArray();
            if(str[j] == 'Q')
                return false;
        }

        //检查左上方是否有皇后冲突
        for (int i = row - 1, j = col - 1; 0 <= i && 0 <= j; i--, j--) {
            char[] str = board.get(i).toCharArray();
            if(str[j] == 'Q')
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        No51 no51 = new No51();

        List<List<String>> back = no51.solveNQueens(4);

        for (List<String> list : back){
            for (String str: list) {
                System.out.println(str);

            }
            System.out.println("_____");
        }

    }


}

