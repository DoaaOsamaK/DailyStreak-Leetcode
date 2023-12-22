import java.math.*;
class Solution {
public String multiply(String num1, String num2) {
BigInteger m= new BigInteger(num1);
BigInteger n= new BigInteger(num2);
return String.valueOf(m.multiply(n));
}
}