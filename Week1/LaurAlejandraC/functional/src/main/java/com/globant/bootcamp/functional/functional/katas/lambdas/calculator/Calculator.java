package com.globant.bootcamp.functional.functional.katas.lambdas.calculator;

import java.util.function.BinaryOperator;

public class Calculator {

    public static Integer execute(BinaryOperator<Integer> op,int a , int b){
        return op.apply(a,b);
    }

}
