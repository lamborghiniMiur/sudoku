/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.trisystem.sudoku.trisudoku;

/**
 * セルの枠線の種類.
 *
 * @author miura
 */
public enum CellBorderType {
    /** 通常(下部1px,右1px). */
    childCube,

    /** 下部2px,右2px. */
    childCube2,

    /** 下部1px,右2px. */
    childCube3,

    /** 下部2px,右1px. */
    childCube4;
}
