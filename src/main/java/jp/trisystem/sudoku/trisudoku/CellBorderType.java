/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.trisystem.sudoku.trisudoku;

/**
 *
 * @author トライ十郎
 */
/**
 *
 * 数独のブロックの枠線の種類.
 */
public enum CellBorderType {
    /**
     * 下1px,右1px.
     */
    childCube1,
    /**
     * 下2px,右2px.
     */
    childCube2,
    /**
     * 下1px,右2px.
     */
    childCube3,
    /**
     * 下2px,右1px.
     */
    childCube4;

}
