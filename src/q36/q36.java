package q36;
class Solution {
    public boolean isValidSudoku(char[][] board) {
        //行是row
        //列是col
        boolean[][] rowExist = new boolean[9][10];
        boolean[][] colExist = new boolean[9][10];
        boolean[][][] blockExist = new boolean[3][3][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0';
                if (rowExist[i][num] || colExist[j][num] || blockExist[i/3][j/3][num]) return false;
                rowExist[i][num] = true;
                colExist[j][num] = true;
                blockExist[i/3][j/3][num] = true;
            }
        }
        return true;
    }
}
public class q36 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'.','.','4',  '.','.','.',  '6','3','.'},
                {'.','.','.',  '.','.','.',  '.','.','.'},
                {'5','.','.',  '.','.','.',  '.','9','.'},

                {'.','.','.',  '5','6','.',  '.','.','.'},
                {'4','.','3',  '.','.','.',  '.','.','1'},
                {'.','.','.',  '7','.','.',  '.','.','.'},

                {'.','.','.',  '5','.','.',  '.','.','.'},
                {'.','.','.',  '.','.','.',  '.','.','.'},
                {'.','.','.',  '.','.','.',  '.','.','.'}};
        Solution solution = new Solution();
        System.out.println(solution.isValidSudoku(board));
    }
    /*
    {
            {'.','.','4',  '.','.','.',  '6','3','.'},
            {'.','.','.',  '.','.','.',  '.','.','.'},
            {'5','.','.',  '.','.','.',  '.','9','.'},

            {'.','.','.',  '5','6','.',  '.','.','.'},
            {'4','.','3',  '.','.','.',  '.','.','1'},
            {'.','.','.',  '7','.','.',  '.','.','.'},

            {'.','.','.',  '5','.','.',  '.','.','.'},
            {'.','.','.',  '.','.','.',  '.','.','.'},
            {'.','.','.',  '.','.','.',  '.','.','.'}
      }
      */
}
