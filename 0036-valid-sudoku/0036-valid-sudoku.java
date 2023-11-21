class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Check each row
        for (int i = 0; i < 9; i++) {
            if (!isRowValid(board, i)) {
                return false;
            }
        }

        // Check each column
        for (int j = 0; j < 9; j++) {
            if (!isColumnValid(board, j)) {
                return false;
            }
        }

        // Check each 3x3 sub-grid
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                if (!isSubgridValid(board, row, col)) {
                    return false;
                }
            }
        }

        // If all checks pass
        return true;
    }

    private boolean isRowValid(char[][] board, int row) {
        boolean[] seen = new boolean[9];
        for (int col = 0; col < 9; col++) {
            if (board[row][col] != '.') {
                if (seen[board[row][col] - '1']) {
                    return false;
                }
                seen[board[row][col] - '1'] = true;
            }
        }
        return true;
    }

    private boolean isColumnValid(char[][] board, int col) {
        boolean[] seen = new boolean[9];
        for (int row = 0; row < 9; row++) {
            if (board[row][col] != '.') {
                if (seen[board[row][col] - '1']) {
                    return false;
                }
                seen[board[row][col] - '1'] = true;
            }
        }
        return true;
    }

    private boolean isSubgridValid(char[][] board, int startRow, int startCol) {
        boolean[] seen = new boolean[9];
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                if (board[row][col] != '.') {
                    if (seen[board[row][col] - '1']) {
                        return false;
                    }
                    seen[board[row][col] - '1'] = true;
                }
            }
        }
        return true;
    }
}