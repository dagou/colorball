package com.dagou.markov;

/**
 * Created by zhuzhengwei on 15-10-27.
 */
public class InvalidMarkovChainException extends Exception  {
    public String getMessage(){
        return "Chain de Markov invalide";
    }
}
