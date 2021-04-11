package everyday;

public class No74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int numsRow = matrix.length;
        int numsCol = matrix[0].length;
        int i = 0;
        int j = numsCol - 1;
        while (i < numsRow && j >= 0){
            if (target == matrix[i][j])
                return true;
            else if (target < matrix[i][j]){
                j--;
                continue;
            }
            else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //int[][]matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][]matrix = {{1}};
        int target = 1;
        No74 solution = new No74();
        System.out.println(solution.searchMatrix(matrix, target));
    }
}
