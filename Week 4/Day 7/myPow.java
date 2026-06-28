class Solution {
    public double myPow(double x, int n) {
        long exponent = n;
        
        if (exponent < 0) {
            x = 1.0 / x;
            exponent = -exponent;
        }
        
        double result = 1;
        double currentProduct = x;

        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result *= currentProduct;
            }
            currentProduct *= currentProduct;
            
            exponent >>= 1;
        }
        
        return result;
    }
}
