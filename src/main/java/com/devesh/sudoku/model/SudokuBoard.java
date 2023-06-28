package com.devesh.sudoku.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SudokuBoard {

    Cell board[][] = new Cell[9][9];

    public void setBoardWithValues(int mat[][]) {
        for(int i=0;i<9;i++) {
            for(int j=0; j<9; j++) {
                board[i][j] = new Cell();
                board[i][j].setRow(i);
                board[i][j].setCol(j);
                board[i][j].setVal(mat[i][j]);
            }
        }
    }

    public void addValue(Cell newCell) {
        board[newCell.getRow()][newCell.getCol()] = newCell;
    }

    public int[][] getMatrix() {
        int mat[][]=new int[9][9];
        for(int i=0;i<9;i++) {
            for(int j=0; j<9; j++) {
                mat[i][j] = board[i][j].getVal();
            }
        }
        return mat;
    }
}
