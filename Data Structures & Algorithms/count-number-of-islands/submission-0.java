class Solution {
    public int numIslands(char[][] grid) {
        int numOfIsland = 0;
        int columnLength = grid.length;
        int rowLength = grid[0].length;
        for (int i =0; i < columnLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                if (grid[i][j] == '1') {
                    numOfIsland+=1;
                    checkIsland(grid, i, j);
                }
            }
        }
            return numOfIsland;
    }

    public void checkIsland(char[][] grid, int columnPos, int rowPos) {
        if(columnPos >= grid.length || columnPos < 0 || rowPos >= grid[0].length || rowPos < 0 || grid[columnPos][rowPos] == '0') return;
        grid[columnPos][rowPos] = '0';
        checkIsland(grid, columnPos - 1, rowPos);
        checkIsland(grid, columnPos + 1, rowPos);
        checkIsland(grid, columnPos, rowPos - 1);
        checkIsland(grid, columnPos, rowPos + 1);
    }
}