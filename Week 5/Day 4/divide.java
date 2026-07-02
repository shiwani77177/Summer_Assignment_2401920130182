class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int finalQuotient = 0;

        while (absDividend >= absDivisor) {
            long shiftedDivisor = absDivisor;
            int bitMultiplier = 1;

            while (absDividend >= (shiftedDivisor << 1)) {
                shiftedDivisor <<= 1;
                bitMultiplier <<= 1;
            }

            absDividend -= shiftedDivisor;
            finalQuotient += bitMultiplier;
        }

        return isNegative ? -finalQuotient : finalQuotient;
    }
}