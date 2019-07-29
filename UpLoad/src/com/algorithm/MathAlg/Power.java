package com.algorithm.MathAlg;
//数值的整数次方，要考虑exponent为负数和0的情况
public class Power {
    public double ower(double base, int exponent) {
        if(exponent == 0){
            return (double)1;
        }     double ret = base;
        if(exponent < 0){
            int reverse = -exponent;
            for(int i = reverse;i > 1;i--){
                ret = ret*base;
            }
            ret = 1/ret;
        }
        if(exponent > 0){
            for(int i = exponent;i > 1;i--){
                ret = ret*base;
            }
        }
        return ret;
    }
}
