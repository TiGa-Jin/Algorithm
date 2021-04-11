package everyday;
/**
 * 304. 二维区域和检索 - 矩阵不可变
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 *                 {{3, 0, 1, 4, 2},
 *                 {5, 6, 3, 2, 1},
 *                 {1, 2, 0, 1, 5},
 *                 {4, 1, 0, 1, 7},
 *                 {1, 0, 3, 0, 5}};
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 * */


/**
 * 方法：一维前缀和
 * 第 303 题中，初始化时对数组计算前缀和，每次检索即可在 O(1)的时间内得到结果。可以将第 303 题的做法应用于这道题，初始化时对矩阵的每一行计算前缀和，检索时对二维区域中的每一行计算子数组和，然后对每一行的子数组和计算总和。
 * 方法一虽然利用了前缀和，但是每次检索的时间复杂度是 O(m) m是矩阵的行数
 */
public class No304_2 {
    int[][] sum;

    public No304_2(int[][] matrix) {
        int rows = matrix.length;
        if(rows > 0){
            int clos = matrix[0].length;
            sum = new int[rows][clos + 1];
            for(int i = 0; i < rows; i++){
                //对每一行做前缀和
                for(int j = 0; j < clos; j++){
                    sum[i][j + 1] = sum[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sums = 0;
        //对每一行的前缀和进行累加
        for(int i = row1; i <= row2; i++){
            sums += sum[i][col2 + 1] - sum [i][col1];
        }

        return sums;

    }
    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};

        No304_2 numMatrix = new No304_2(matrix);
        int sum = numMatrix.sumRegion(2, 1, 4, 3);
        System.out.println(sum);
    }
}
