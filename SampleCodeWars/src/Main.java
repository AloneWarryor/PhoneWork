

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinhc
 */
public class Main {
    int [][] matrix;

    public Main(int[][] matrix) {
        this.matrix = matrix;
    }
    
    int [] getRow (int number) {
        if (number < 4) {
            return new int [] {matrix[0][number], matrix[1][number], matrix[2][number] ,matrix[3][number]};
        } else if (number < 8) {
            number = number - 4;
            return new int [] {matrix[number][3], matrix[number][2], matrix[number][1], matrix[number][0]};
        } else if (number < 12) {
            number = number - 8;
            return new int [] {matrix[3][number], matrix[2][number], matrix[1][number] ,matrix[0][number]};
        } else {
            number = number - 12;
            return matrix[number];
        }
    }
    void setRow (int number, int [] row) {
        if (number < 4) {
            matrix[0][number] = row[0];
            matrix[1][number] = row[1];
            matrix[2][number] = row[2];
            matrix[3][number] = row[3];
        } else if (number < 8) {
            number = number - 4;
            matrix[number][3] = row[0];
            matrix[number][2] = row[1];
            matrix[number][1] = row[2];
            matrix[number][0] = row[3];
        } else if (number < 12) {
            number = number - 8;
            matrix[3][number] = row[0];
            matrix[2][number] = row[1];
            matrix[1][number] = row[2];
            matrix[0][number] = row[3];
        } else {
            number = number - 12;
            matrix[number] = row;
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    //Static function
    static boolean check(int number, int [] row) {
        int i = 0;
        int tmp = 0;
        for (int j : row) {
            if (j > tmp) {
                tmp = j;
                i++;
            }
        }
        if (i != number) {
            return false;
        }
        return true;
    }
    static int[][] solvePuzzle (int[] clues) {
        Main matrix = new Main(new int[4][4]);            
        for (int i = 0; i < clues.length; i++) {
            if (clues[i] == 1) {
                int [] tmp = matrix.getRow(i);
                tmp[0] = 1;
                matrix.setRow(i, tmp);
            }
            if (clues[i] == 4) {
                matrix.setRow(i, new int[]{1,2,3,4});
            }
        }
        return matrix.getMatrix();
    }
    public static void main(String[] args) {
       
    }
    
}