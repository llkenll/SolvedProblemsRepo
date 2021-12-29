import java.util.LinkedList;
import java.util.Queue;

class Solution {
    final int[][] DIRECTIONS = {{1,1}, {1,0}, {1,-1}, {0, 1}, {0, 0}, {0,-1}, {-1, 1}, {-1, 0}, {-1, -1}};
    int[][] matrix;
   public int shortestPathBinaryMatrix(int[][] grid) {
       this.matrix = grid;
       int rowLen = grid.length;
       int colLen = grid[0].length;
       if(grid[0][0] == 1 || grid[rowLen-1][colLen-1] == 1){
           return -1;
       }

       Queue<int[]> q = new LinkedList<>();
       Integer[][] visited = new Integer[rowLen][colLen];
       q.add(new int[]{0,0});
       visited[0][0] = 1;

       while(q.isEmpty() == false){
            int[] currenArr = q.remove();
            int currenRow = currenArr[0];
            int currenCol = currenArr[1];

            for(int[] neigh: getNei(currenArr)){
                int neiRow = neigh[0];
                int neiCol = neigh[1];

                //int neiDist = visited[neiRow][neiCol];
                if(visited[neiRow][neiCol] == null || visited[neiRow][neiCol] > visited[currenRow][currenCol] + 1){
                    visited[neiRow][neiCol] = visited[currenRow][currenCol]+1;
                    q.add(new int[]{neiRow, neiCol});
                }

            }

       }



       Integer res = visited[rowLen-1][colLen-1];
       return res == null ? -1:res;
   }

    private List<int[]> getNei(int[] cur){
        List<int[]> possibleNei = new LinkedList<>();
        for(int[] num: this.DIRECTIONS){
            int row = num[0] + cur[0];
            int col = num[1] + cur[1];
            if(row < 0 || row >= matrix.length)continue;
            if(col < 0 || col >= matrix[0].length)continue;
            if(matrix[row][col] == 1)continue;
            possibleNei.add(new int[]{row, col});
        }
        return possibleNei;
    }

}