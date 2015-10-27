package com.dagou.markov;

/**
 * Created by zhuzhengwei on 15-10-27.
 */
public class MatrixNotSquareException extends Exception{
    public String getMessage(){
        return "The matrix must be square";
    }
}
