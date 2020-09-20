package com.phosphor.sudoku.ui.game

import android.arch.lifecycle.MutableLiveData
import phosphor.sudoku.lib.enums.Level
import phosphor.sudoku.lib.generator.Sudoku

class SudokuGame {

    var selectedCellLiveData = MutableLiveData<Pair<Int, Int>>()
    var cellsLiveData = MutableLiveData<List<Cell>>()

    private var selectedRow = -1
    private var selectedCol = -1

    private val board: Board

    private val grid: Array<IntArray> = Sudoku.Builder().setLevel(Level.SENIOR).build().grid

    init {
        val cells: MutableList<Cell> = mutableListOf()

        for (i in 0..8) {
            for (j in 0..8) {
                cells.add(Cell(i, j, grid[i][j]))
            }
        }

        board = Board(9, cells)

        selectedCellLiveData.postValue(Pair(selectedRow, selectedCol))
        cellsLiveData.postValue(board.cells)
    }

    fun handleInput(number: Int) {
        if (selectedRow == -1 || selectedCol == -1) return

        board.getCell(selectedRow, selectedCol).value = number
        cellsLiveData.postValue(board.cells)
    }

    fun updateSelectedCell(row: Int, col: Int) {
        selectedRow = row
        selectedCol = col
        selectedCellLiveData.postValue(Pair(row, col))
    }
}