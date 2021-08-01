class PowNx {

    // https://leetcode.com/problems/powx-n/

    private double power(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double val = power(x, n / 2);
        if (n%2 == 0) {
            return val * val;
        } else {
            return val * val * x;
        }
    }
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n >= 0) {
            return power(x, n);
        } else {
            return (1.0) / power(x, n);
        }
    }
}