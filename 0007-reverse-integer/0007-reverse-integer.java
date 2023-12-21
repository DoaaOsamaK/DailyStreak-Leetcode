class Solution {

 public int reverse(int x) {
    int ans = 0;
    boolean isNegative = x < 0;

    // Handling edge case for -2147483648
    if (x <= Integer.MIN_VALUE) {
        return 0;
    }

    if (isNegative) {
        x = -x; // Making x positive to work with it
    }

    while (x != 0) {
        int rem = x % 10;
        if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && rem > 7)) {
            return 0;
        }
        
        ans = ans * 10 +rem;
        x = x / 10;
    }

    return isNegative ? -ans : ans;
}

}