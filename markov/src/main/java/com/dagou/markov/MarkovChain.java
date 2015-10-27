package com.dagou.markov;

import Jama.Matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * Created by zhuzhengwei on 15-10-27.
 */
public class MarkovChain {
    private Matrix transitionMatrix;

    public MarkovChain(String input) throws IOException, InvalidMarkovChainException, NegativeMatrixElementException, MatrixNotSquareException {
        this.read(input);
        this.validate();
    }

    private void read(String input) throws IOException {
        StringReader sr = new StringReader(input);
        BufferedReader br = new BufferedReader(sr);
        this.transitionMatrix = Matrix.read(br);
    }

    /**
     * Validate the template by following these three rules:
     * - The matrix must be square
     * - Elements of the matrix must be positive
     * - The sum of each line must be equal to 1
     * @throws InvalidMarkovChainException
     * @throws NegativeMatrixElementException
     * @throws MatrixNotSquareException
     */
    private void validate() throws InvalidMarkovChainException, NegativeMatrixElementException, MatrixNotSquareException {

        if (transitionMatrix.getRowDimension() != transitionMatrix.getColumnDimension()) {
            throw new MatrixNotSquareException();
        }

        for (int i = 0; i < this.transitionMatrix.getRowDimension(); i++) {

            double lineSum = 0;
            for (int j = 0; j < this.transitionMatrix.getColumnDimension(); j++) {

                double element = this.transitionMatrix.get(i, j);

                if (element < 0) {
                    throw new NegativeMatrixElementException();
                }

                lineSum += element;
            }

            if (lineSum > 1) {
                throw new InvalidMarkovChainException();
            }
        }
    }

    public void print(PrintWriter pr) {
        this.transitionMatrix.print(pr, 3, 1);
    }

    public Matrix getTransitionMatrix() {
        return this.transitionMatrix;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < this.transitionMatrix.getRowDimension(); i++) {
            for (int j = 0; j < this.transitionMatrix.getColumnDimension(); j++) {
                result += " " + this.transitionMatrix.get(i, j);
            }
            result += "\n";
        }

        return result;
    }

}


