package com.example.demo.mathUtil;

import org.springframework.stereotype.Service;

@Service
public class MathUtil {

    public int add(int a,int b){
        return a+b;
    }

    public int sub(int a,int b){
        return a-b;
    }

    public int multi(int a,int b){
        return a*b;
    }

    // for testing exception
    public int divide(int a,int b){
        return a/b;
    }

    public double areaOfCircle(double radius) {
        return Math.PI*radius*radius;
    }
}
