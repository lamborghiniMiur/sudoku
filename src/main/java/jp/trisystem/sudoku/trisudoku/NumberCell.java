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
    
    /** セルの状態. */
    private CellCondition condition;
    
    /** 読み取り専用族生. */
    private Boolean readonly;
    
    private String cellborderType;

    
    /**
     * コンストラクタ.
     */
    public NumberCell() {
        this.number = 0;
        this.hide = false;
        this.readonly = true;
        this.condition = CellCondition.INITIAL;
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
            
            switch(condition) {
                case INITIAL:
                    return String.valueOf(number);
                default:
                    return dispNumber;
            }
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
     * 固定数字かどうかを返す.
     * 
     * @return 
     */
    public String getFixed() {
        String fixed = "";
        if (!hide) {
            fixed = "fixed";
            
            switch (condition) {
                case MUCH:
                    fixed = "much";
                    break;
                case UNMUCH:
                    fixed = "error";
                    
                    break;
                default:
                    break;
            }
        }
        return fixed;
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
    

    /**
     * 入力された数値と元の数値の一致チェック.
     */
    public void muchNumber() {
        if (dispNumber.equals(String.valueOf(number))) {
            this.condition = CellCondition.MUCH;
        } else {
            this.condition = CellCondition.UNMUCH;
        }
    }

    /**
     * @param readonly the readonly to set
     */
    public void setReadonly(Boolean readonly) {
        this.readonly = readonly;
    }

    /**
     * 読み取り専用属性.
     * 
     * @return 
     */
    public Boolean isReadonly() {
        return this.readonly;
    }

    /**
     * @return the cellborderType
     */
    public String getCellborderType() {
        return cellborderType;
    }

    /**
     * @param cellborderType the cellborderType to set
     */
    public void setCellborderType(String cellborderType) {
        this.cellborderType = cellborderType;
    }
    
    
    
}
