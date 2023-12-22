class Solution {
    List<String> out = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    String[] p = new String[]{"(", ")"};
    int open, close; // count of open and close parenthesis

    public List<String> generateParenthesis(int n) {
        backtrack(n);
        return out;
    }

    private void backtrack(int n) {
        if (open > n || close > n || open < close) {
            return;
        } else if (path.length() == 2 * n) {
            out.add(path.toString());
            return;
        }

        for (int i = 0; i < 2; i++) {
            path.append(p[i]);
            String test = path.toString();
            if (i == 0) open++;
            else close++;
            backtrack(n);
            path.deleteCharAt(path.length() - 1);
            if (i == 0) open--;
            else close--;
        }
    }
}