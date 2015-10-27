package com.dagou.markov;

/**
 * Created by zhuzhengwei on 15-10-27.
 */
public class NegativeMatrixElementException extends Exception {
    public String getMessage(){
        return "Elements of the matrix must be positive";
    }
}
