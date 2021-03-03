//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
// 此外，你可以假设该网格的四条边均被水包围。
//
//
//
// 示例 1：
//
//
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
//
//
// 示例 2：
//
//
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] 的值为 '0' 或 '1'
//
// Related Topics 深度优先搜索 广度优先搜索 并查集
// 👍 1002 👎 0


package com.leetcode.editor.cn;

public class NumberOfIslands{
    public static void main(String[] args) {
         Solution solution = new NumberOfIslands().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        int max = 0;
        for (int r = 0;r < grid.length;r++){
            for (int c = 0;c < grid[0].length;c++){
                if (grid[r][c] == '1'){
                    max++;
                    area(grid,r,c);
                }
            }
        }
        return max;
    }

    private void area(char[][] grid,int r,int c){
        if (!inArea(r,c,grid)){
            return;
        }
        if (grid[r][c] != '1'){
            return;
        }
        grid[r][c] = '2';
        area(grid,r,c-1);
        area(grid,r,c+1);
        area(grid,r+1,c);
        area(grid,r-1,c);
    }


    private boolean inArea(int r,int c,char[][] grid){
        return r >=0 && r <grid.length && c>=0 && c < grid[0].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
