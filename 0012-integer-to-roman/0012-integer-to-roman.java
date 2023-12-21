class Solution {
    public String intToRoman(int num) {
        String n = String.valueOf(num) ;
        String[] ones = {"" , "I" , "II" , "III" , "IV" , "V", "VI" , "VII" , "VIII" , "IX" } ;
        String[] tens = { "" , "X" , "XX" , "XXX" , "XL" , "L", "LX" , "LXX" , "LXXX" , "XC" } ;
        String[] hundreds = {"" , "C" , "CC" , "CCC" , "CD" , "D", "DC" , "DCC" , "DCCC" , "CM" } ;
        String[] thousands = {"" , "M" , "MM" , "MMM" } ;
        
        String output = "" ;
        for (int i = 0 ; i < n.length() ; i++ ) {
            int p = (n.length() - i - 1) ;
            int n1 = ( n.charAt(i) - '0') * (int)(Math.pow(10 , p)) ;

            if (n1 >= 1 && n1 <= 9) {
                output += ones[n1] ;
            }
            else if (n1 >= 10 && n1 <= 90 ) {
                output += tens[n1 / 10 ] ;
            }
            else if (n1 >= 100 && n1 <= 900) {
                output += hundreds[n1 / 100 ] ;
            }
            else if (n1 >= 1000 && n1 <= 3000 ) {
                output += thousands[n1 / 1000] ;
            }
        }
        return output;
    }
}