class Solution {
    private static final long MOD = 1_000_000_007L;

    public int countGoodNumbers(long n) {
        long evenIndices = (n + 1) / 2;
        long oddIndices = n / 2;
        long evenChoices = power(5, evenIndices);
        long oddChoices = power(4, oddIndices);
        
        return (int) ((evenChoices * oddChoices) % MOD);
    }

    private long power(long base, long exp) {
        long result = 1;
        base = base % MOD;
        
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        
        return result;
    }
}
