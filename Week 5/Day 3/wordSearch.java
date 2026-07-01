class Solution {
    private int rows;
    private int cols;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        }

        this.rows = board.length;
        this.cols = board[0].length;
        char[] targetWord = word.toCharArray();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == targetWord[0]) {
                    if (backtrackPath(board, r, c, targetWord, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtrackPath(char[][] board, int r, int c, char[] word, int letterIdx) {
        if (letterIdx == word.length) {
            return true;
        }

        if (r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != word[letterIdx]) {
            return false;
        }

        char originalChar = board[r][c];
        board[r][c] = '#';

        boolean pathFound = backtrackPath(board, r + 1, c, word, letterIdx + 1) ||
                            backtrackPath(board, r - 1, c, word, letterIdx + 1) ||
                            backtrackPath(board, r, c + 1, word, letterIdx + 1) ||
                            backtrackPath(board, r, c - 1, word, letterIdx + 1);

        board[r][c] = originalChar;

        return pathFound;
    }
}