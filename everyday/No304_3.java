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
 * 为了将每次检索的时间复杂度降到 O(1)，需要使用二维前缀和，在初始化的时候计算二维前缀和数组。
 *  f(i,j)为二维前缀和
 * 当i 或者 j都为0 时计算 f(i,j)只需要对矩阵matrix 的最上边的行和最左边的列分别计算前缀和即可。
 * 当 i 和 j都大于 0 时：f(i,j) = f(i-1,j) + f(i,j-1) - f(i-1,j-1) + matrix[i][j] (画图就可以直观地看出
 *
 */
public class No304_3 {
    int[][] sums;

    public No304_3(int[][] matrix) {
        int rows = matrix.length;
        if (0 < rows){
            int clos = matrix[0].length;
            sums = new int[rows + 1][clos + 1];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    sums[i + 1][j + 1] = sums[i + 1][j] + sums[i][j + 1] - sums[i][j] + matrix[i][j];
                }

            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];

    }

    }

