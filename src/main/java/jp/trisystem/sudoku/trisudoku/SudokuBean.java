/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.trisystem.sudoku.trisudoku;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * 数独パズル.
 *
 * @author miura
 */
@Named
@ViewScoped
public class SudokuBean implements Serializable {

    /** タイトル. */
    private static final String TITLE = "数独パズル";
    
    /**　メッセージ. */
    private String message;

    /** コンストラクタ. */
    public SudokuBean() {
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return TITLE;
    }
/** ボタンを押した時. */
    public void execute() {
        message = "正解";
    }

    /**
     * メッセージを返す.
     * 
     * @return メッセージ
     */
    public String getMessage() {
        return message;
    }

     /**   
     * リセットボタンを押した時.
     */
    public void reset() {
        message = null;
    }

}
