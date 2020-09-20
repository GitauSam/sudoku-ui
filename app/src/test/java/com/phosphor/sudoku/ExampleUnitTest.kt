package com.phosphor.sudoku

import com.phosphor.sudoku.ui.game.Cell
import junit.framework.Assert.assertEquals
import org.junit.Test
import phosphor.sudoku.lib.enums.Level
import phosphor.sudoku.lib.generator.Sudoku

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 3)
    }

    @Test
    fun testSudokuLib() {
        val l: MutableList<Cell> = mutableListOf()
        val grid = Sudoku.Builder().setLevel(Level.SENIOR).build().grid
        for (i in 0..8) {
            for (j in 0..8) {
                l.add(Cell(i, j, grid[i][j]))
//                println("coord: [$i, $j] = value: ${l[l.size - 1]}")
//                println("coord: [$i, $j] = value: ${grid[i][j]}")
            }
        }
        println(l.size)
    }
}


