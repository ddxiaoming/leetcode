package q37;

import java.util.ArrayList;

class Solution {
    private boolean valid = false;
    public void solveSudoku(char[][] board) {
        ArrayList<EmptyNode> emptyNodes = new ArrayList<>();
        boolean[][] rowExist = new boolean[9][10];
        boolean[][] colExist = new boolean[9][10];
        boolean[][][] blockExist = new boolean[3][3][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') emptyNodes.add(new EmptyNode(i, j));
                else {
                    int num = board[i][j] - '0';
                    rowExist[i][num] = true;
                    colExist[j][num] = true;
                    blockExist[i / 3][j / 3][num] = true;
                }
            }
        }
        dfs(board,0,emptyNodes,rowExist,colExist,blockExist);
    }
    private void dfs(char[][] board, int index, ArrayList<EmptyNode> emptyNodes, boolean[][] rowExist, boolean[][] colExist, boolean[][][] blockExist) {
        if (index == emptyNodes.size()) {
            valid = true;
            return;
        }
        EmptyNode emptyNode = emptyNodes.get(index);
        int x = emptyNode.getX();
        int y = emptyNode.getY();
        for (int num = 1; num < 10 && !valid; num++) {
            if (!rowExist[x][num] && !colExist[y][num] && !blockExist[x / 3][y / 3][num]) {
                rowExist[x][num] = true;
                colExist[y][num] = true;
                blockExist[x / 3][y / 3][num] = true;
                board[x][y] = (char) (num + '0');
                dfs(board, index + 1, emptyNodes, rowExist, colExist, blockExist);
                //board[x][y] = '.';
                rowExist[x][num] = false;
                colExist[y][num] = false;
                blockExist[x / 3][y / 3][num] = false;
            }
        }
    }
}

class EmptyNode {
    private int x;
    private int y;
    EmptyNode (int x, int y) {
        this.x = x;
        this.y = y;
    }
    EmptyNode () {}

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
public class q37 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        solution.solveSudoku(board);
        System.out.println(1);
    }
}
