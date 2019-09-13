package Algorithms.Array;

// https://leetcode.com/problems/game-of-life/
public class GameOfLife {
    public static void run(int[][] board) {
        if (board.length <= 0) return;
        int rows = board.length;
        int cols = board[0].length;
        int[] prevRow = new int[cols];

        for (int row = 0; row < rows; row++) {
            int[] tempRow = new int[cols];

            for (int col = 0; col < cols; col++) {
                int lives = liveNeighbours(board, rows, cols, row, col);
                tempRow[col] = board[row][col];

                if (board[row][col] == 0 && lives == 3) {
                    tempRow[col] = 1;
                } else if (board[row][col] == 1) {
                    if (lives < 2 || lives > 3) tempRow[col] = 0;
                }
            }

            if (row > 0) board[row - 1] = prevRow;
            if (row == rows - 1) {
                board[row] = tempRow;
            } else {
                prevRow = tempRow;
            }
        }
    }

    public static void runV2(int[][] board) {
        if (board.length <= 0) return;
        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int lives = liveNeighboursV2(board, rows, cols, row, col);

                if (board[row][col] == 0 && lives == 3) {
                    board[row][col] = 2;
                }

                if (board[row][col] == 1) {
                    if (lives == 2 || lives == 3) board[row][col] = 3;
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                board[row][col] >>= 1;
            }
        }
    }

    private static int liveNeighbours(int[][] board, int rows, int cols, int row, int col) {
        int lives = 0;

        for (int r = Math.max(row - 1, 0); r <= Math.min(rows - 1, row + 1); r++) {
            for (int c = Math.max(col - 1, 0); c <= Math.min(cols - 1, col + 1); c++) {
                if (board[r][c] == 1) lives++;
            }
        }

        lives -= board[row][col];

        return lives;
    }

    private static int liveNeighboursV2(int[][] board, int rows, int cols, int row, int col) {
        int live = 0;

        for (int r = Math.max(row - 1, 0); r <= Math.min(rows - 1, row + 1); r++) {
            for (int c = Math.max(col - 1, 0); c <= Math.min(cols - 1, col + 1); c++) {
                live += board[r][c] & 1;
            }
        }

        live -= board[row][col] & 1;

        return live;
    }
}
