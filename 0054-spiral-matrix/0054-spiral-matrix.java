import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {
        
        
        List<Integer> result = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int dir = 0;

        do {
            switch (dir) {
                case 0: // left to right
                    for (int i = left; i <= right; i++) {
                        result.add(matrix[top][i]);
                    }
                    top++;
                    break;
                case 1: // top to bottom
                    for (int i = top; i <= bottom; i++) {
                        result.add(matrix[i][right]);
                    }
                    right--;
                    break;
                case 2: // right to left
                    for (int i = right; i >= left; i--) {
                        result.add(matrix[bottom][i]);
                    }
                    bottom--;
                    break;
                case 3: // bottom to top
                    for (int i = bottom; i >= top; i--) {
                        result.add(matrix[i][left]);
                    }
                    left++;
                    break;
            }

            dir = (dir + 1) % 4;

        } while (top <= bottom && left <= right);

        return result;
    }

}