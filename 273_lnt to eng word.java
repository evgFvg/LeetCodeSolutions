/*273. Integer to English Words

Convert a non-negative integer num to its English words representation.

 

Example 1:

Input: num = 123
Output: "One Hundred Twenty Three"
Example 2:

Input: num = 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: num = 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
*/


class Solution273 {
    private static String[] ones = {"", " One", " Two", " Three", " Four", " Five",
            " Six", " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve",
            " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen",
            " Eighteen", " Nineteen"};
            
    private static String[] tens = {"", " Ten", " Twenty", " Thirty", " Forty",
            " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};
            
    private static String[] thousands = {"", " Thousand", " Million", " Billion"};

    public String numberToWords(int num) {

        if (num < 1000) {
            return printLessThan1000(num);
        }
        return printBiggerThan1000(num);
    }

    private String printBiggerThan1000(int num) {
        for (int i = 3; i >= 0; --i) {
            if (num >= Math.pow(1000, i)) {
                return numberToWords((int) (num / Math.pow(1000, i))) + thousands[i] + numberToWords((int) (num % Math.pow(1000, i)));
            }
        }
        return "";
    }

    private String printLessThan1000(int num) {
        if (num == 0) {
            return "Zero";
        }
        if (num < 20) {
            return ones[num];
        }
        if (num < 100) {
            return getTens(num);
        }
        if (num < 1000) {
            return ones[num / 100] + " Hundred" + getTens(num % 100);
        }
        return "";
    }

    private String getTens(int num) {
        return tens[num / 10] + ones[num % 10];
    }
}

