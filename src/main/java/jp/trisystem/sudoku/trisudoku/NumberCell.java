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
    
    /** 連番. */
    private int seqNo;
    
    /** 数値. */
    private int number;
    
    /** 数値(文字). */
    private String dispNumber;
    
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
     * 表示する数字を返す.
     * 
     * @return 表示する数字
     */
    public String getDispNumber() {
        if (!this.hide) {
            return String.valueOf(number);
        }
        return "";
    }

    /**
     * 
     * @param dispNumber 
     */
    public void setDispNumber(String dispNumber) {
        this.dispNumber = dispNumber;
    }
    
    
    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * 読み取り専用属性.
     * 
     * @return 
     */
    public Boolean isReadonly() {
        return !hide;
    }

    /**
     * @return the seqNo
     */
    public int getSeqNo() {
        return seqNo;
    }

    /**
     * @param seqNo the seqNo to set
     */
    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }
    
}
