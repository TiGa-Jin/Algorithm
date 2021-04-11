

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
 */
public class No304 {
    int[][] matrix;
    public No304(int[][] matrix) {
        this.matrix = matrix;

    }

    //暴力循环
    public int sumRegion1(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = row1; i < row2 + 1; i++){
            for(int j = col1; j < col2 + 1; j++){
                sum += this.matrix[i][j];
            }
        }
        return sum;

    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};

        No304 numMatrix = new No304(matrix);
        int sum = numMatrix.sumRegion1(1, 1, 2, 2);
        System.out.println(sum);
    }
}
