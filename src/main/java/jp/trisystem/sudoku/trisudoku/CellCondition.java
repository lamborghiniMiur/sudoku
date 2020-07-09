/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.trisystem.sudoku.trisudoku;

/**
 * セルの状態.
 *
 * @author miura
 */
public enum CellCondition {
    /** 初期状態. */
    INITIAL,
    /** 一致. */
    MUCH,
    /** 不一致. */
    UNMUCH;
}
