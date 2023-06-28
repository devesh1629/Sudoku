package com.devesh.sudoku.utils;

public class SudokuValidator {
    public boolean isValidMove(int row, int col, int value, int[][] sudoku) {
        // Check if the value is already present in the row
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == value) {
                return false;
            }
        }

        // Check if the value is already present in the column
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == value) {
                return false;
            }
        }

        // Check if the value is already present in the 3x3 box
        int boxStartRow = row - row % 3;
        int boxStartCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudoku[boxStartRow + i][boxStartCol + j] == value) {
                    return false;
                }
            }
        }

        // If the value is not already present in the row, column, or 3x3 box, it is a valid move
        return true;
    }
}

