package com.mycompany;

import java.util.Arrays;

/**
 * This class provides the ability to work with Polynomials
 *
 * @author Mikhail Kurakin
 */
public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double... coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = coeffs.length - 1; i > 1; i--) {
            sb.append(coeffs[i] + "x^" + i + "+");
        }
        sb.append(coeffs[1] + "x" + "+");
        sb.append(coeffs[0] + "");
        return sb.toString();
    }

    public double evaluate(double x) {
        double result = 0.0;
        for (int i = coeffs.length - 1; i >= 0; i--) {
            result += coeffs[i] * Math.pow(x, i);
        }
        return result;
    }

    public MyPolynomial add(MyPolynomial right) {
        int size = Math.max(coeffs.length, right.coeffs.length);
        double[] resCoeffs = new double[size];
        for (int i = 0; i < coeffs.length; i++) {
            resCoeffs[i] = coeffs[i];
        }
        for (int i = 0; i < right.coeffs.length; i++) {
            resCoeffs[i] += right.coeffs[i];
        }

        return new MyPolynomial(resCoeffs);
    }

    public MyPolynomial multiply(MyPolynomial right) {
        double[] resCoeffs = new double[coeffs.length + right.coeffs.length - 1];

        for (int i = 0; i < coeffs.length; i++) {
            for (int j = 0; j < right.coeffs.length; j++) {
                resCoeffs[i + j] += coeffs[i] * right.coeffs[j];
            }
        }
        return new MyPolynomial(resCoeffs);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyPolynomial that = (MyPolynomial) o;

        return Arrays.equals(coeffs, that.coeffs);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(coeffs);
    }
}
