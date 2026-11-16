class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int plus = num1.indexOf('+');
        int r1 = Integer.parseInt(num1.substring(0, plus));
        int i1 = Integer.parseInt(num1.substring(plus + 1, num1.length() - 1));
        int plus2 = num2.indexOf('+');
        int r2 = Integer.parseInt(num2.substring(0, plus2));
        int i2 = Integer.parseInt(num2.substring(plus2 + 1, num2.length() - 1));
        int r = r1 * r2 - i1 * i2;
        int i = r1 * i2 + r2 * i1;
        return r + "+" + i + "i";
    }
}
