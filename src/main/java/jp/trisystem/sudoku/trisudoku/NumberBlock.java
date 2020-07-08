/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.trisystem.sudoku.trisudoku;

/**
 *
 * @author miura
 */
public enum NumberBlock {
    /** 上部(1-3列目). */
    TOP(0, 1, 2),
    /** 上部(4-6列目). */
    MIDDLE(3, 4, 5),
    /** 上部(7-9列目). */
    BOTTOM(6, 7, 8);

    /** 最初の行. */
    private final int rownum;
    /** 2番目の行. */
    private final int rownum2;
    /** 3番目の行. */
    private final int rownum3;
    
    /**
     * コンストラクタ.
     * 
     * @param row 最初の行
     * @param row2 2番目の行
     * @param row3 3番目の行
     */
    NumberBlock(int row, int row2, int row3) {
        this.rownum = row;
        this.rownum2 = row2;
        this.rownum3 = row3;
    }

    /**
     * @return the rownum
     */
    public int getRownum() {
        return rownum;
    }

    /**
     * @return the rownum2
     */
    public int getRownum2() {
        return rownum2;
    }

    /**
     * @return the rownum3
     */
    public int getRownum3() {
        return rownum3;
    }
}
