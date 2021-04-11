/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package offer;

public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        boolean flag = false;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;

        while (row < rows && column >= 0) {
            if(matrix[row][column] == target){
                flag = true;
                break;
            }
            else if(matrix[row][column] < target){
                row++;
            }
            else if (matrix[row][column] > target){
                column--;
            }
        }
        return flag;

    }

    public static void main(String[] args) {
        int[][] ma = {{1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        int ta = 5;
        Offer04 offer04 = new Offer04();
        boolean flag = offer04.findNumberIn2DArray(ma,ta);
        System.out.println(flag);

    }
}
