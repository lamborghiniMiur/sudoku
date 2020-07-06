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

    private final String TITLE;

    public SudokuBean() {
        this.TITLE = "数独パズル";
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return TITLE;
    }
   

    
}
