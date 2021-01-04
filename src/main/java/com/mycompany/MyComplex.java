package com.mycompany;

import java.util.Objects;

/**
 * This class provides the ability to work with complex numbers
 *
 * @author Mikhail Kurakin
 */

public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex() {
        this.real = 0.0;
        this.imag = 0.0;
    }

    public MyComplex(double real, double imag) {
        setValue(real, imag);
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        String sign = (imag < 0) ? "" : "+";
        return "(" + real + sign + imag + "i)";
    }

    public boolean isReal() {
        return (Double.compare(real, 0.0) == 0) ? true : false;
    }

    public boolean isImaginary() {
        return (Double.compare(imag, 0.0) == 0) ? true : false;
    }

    public boolean equals(double real, double imag) {
        return Double.compare(this.real, real) == 0 && Double.compare(this.imag, imag) == 0;
    }

    public boolean equals(MyComplex another) {
        if (this == another) return true;
        return equals(another.real, another.imag);
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(real, 2) + Math.pow(imag, 2));
    }

    public double argument() {
        double arg = 0.0;
        if (real > 0) {
            arg = Math.atan(imag / real);
        } else if ((real < 0) && (imag > 0)) {
            arg = Math.PI + Math.atan(imag / real);
        } else if ((real < 0) && (imag < 0)) {
            arg = -Math.PI + Math.atan(imag / real);
        }
        return arg;
    }

    MyComplex add(MyComplex right) {
        real = real + right.getReal();
        imag = imag + right.getImag();
        return this;
    }

    MyComplex addNew(MyComplex right) {
        double re = real + right.getReal();
        double im = imag + right.getImag();
        return new MyComplex(re, im);
    }

    MyComplex subtract(MyComplex right) {
        real = real - right.getReal();
        imag = imag - right.getImag();
        return this;
    }

    MyComplex subtractNew(MyComplex right) {
        double re = real - right.getReal();
        double im = imag - right.getImag();
        return new MyComplex(re, im);
    }

    MyComplex multiply(MyComplex right) {
        double re = real * right.getReal() - imag * right.getImag();
        double im = real * right.getImag() + imag * right.getReal();
        return new MyComplex(re, im);
    }

    MyComplex divide(MyComplex right) {
        double re = real;
        double im = imag;
        double sqMagnitude = Math.pow(right.magnitude(), 2);

        real = ((re * right.getReal()) + (im * right.getImag())) / sqMagnitude;
        imag = ((right.getReal() * im) - (re * right.getImag())) / sqMagnitude;
        return this;
    }

    MyComplex conjugate() {
        imag = -imag;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyComplex myComplex = (MyComplex) o;

        if (Double.compare(myComplex.real, real) != 0) return false;
        return Double.compare(myComplex.imag, imag) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(real);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(imag);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
