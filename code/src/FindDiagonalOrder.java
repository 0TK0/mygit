/**
 * @Author ：zhuyuqing.
 * @Date ：Created in 7:52 下午 2021/2/24
 * @Description：对角线数组
 * @Modified By：
 * @Version: $
 */
public class FindDiagonalOrder {
    public static int[] findDiagonalOrder(int[][] matrix) {
        int n = matrix[0].length;
        int m =  matrix.length;
        int x = 0;
        int y = 0;
        boolean down = false;
        boolean change = false;
        int[] result = new int[m*n];
        result[0] = matrix[0][0];
        for (int i = 1;i < m*n;i++){
            if (y == 0 && !down){
                down = true;
                x++;
                result[i] = matrix[y][x];
                continue;
            }
            if (x == 0 && down){
                down = false;
                y++;
                result[i] = matrix[y][x];
                continue;
            }
            if (x == n){
                y++;
            }
            if (down){
                y++;
                x--;
            } else {
                y--;
                x++;
            }
            result[i] = matrix[y][x];

        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(matrix[1][0]);
        int[] diagonalOrder = findDiagonalOrder(matrix);

        System.out.println(diagonalOrder);
    }
}
