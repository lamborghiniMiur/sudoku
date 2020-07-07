/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.trisystem.sudoku.trisudoku;

/**
 * セルの数値.
 *
 * @author miura
 */
public class NumberCell {
    
    /** 数値. */
    private int number;
    
    /** 隠すかどうか. */
    private Boolean hide;
    
    /**
     * コンストラクタ.
     */
    public NumberCell() {
        this.number = 0;
        this.hide = false;
    }
    
    /**
     * 一致チェック
     * 
     * @param num
     * @return 
     */
    public Boolean isMuch(int num) {
        return this.getNumber() == num;
    }
    
    /**
     * 数値がふくまれているか.
     * 
     * @return 含まれている
     */
    public Boolean isContains() {
        return this.getNumber() > 0;
    }

    /**
     * @return the hide
     */
    public Boolean isHide() {
        return hide;
    }

    /**
     * @param hide the hide to set
     */
    public void setHide(Boolean hide) {
        this.hide = hide;
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    
}
