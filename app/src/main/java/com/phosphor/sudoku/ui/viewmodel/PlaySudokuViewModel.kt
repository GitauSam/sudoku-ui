package com.phosphor.sudoku.ui.viewmodel

import android.arch.lifecycle.ViewModel
import com.phosphor.sudoku.ui.game.SudokuGame

class PlaySudokuViewModel: ViewModel() {

    val sudokuGame = SudokuGame()
}