/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.trisystem.sudoku.trisudoku;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 難易度.
 *
 * @author miura
 */
public enum Difficulty {
    
    /** 初級. */
    EASY("初級", 38),

    /** 中級. */
    NORMAL("中級", 50),

    /** 上級. */
    HARD("上級", 64);

    /** タイトル. */
    private final String title;
    
    /** 隠すセルの数. */
    private final int hideCell;
    
    /**
     * コンストラクタ.
     * 
     * @param title タイトル
     * @param hideCell 隠すセルの数
     */
    Difficulty(String title, int hideCell) {
        this.title = title;
        this.hideCell = hideCell;
    }

    /**
     * @return the hideCell
     */
    public int getHideCell() {
        return hideCell;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * 難易度のラジオボタン用.
     * 
     * @return ラジオボタン用
     */
    public static Map<String, Object> getDifficultyValues() {
        Map<String, Object> difficultyValues = new LinkedHashMap<>();
        for (Difficulty value : Difficulty.values()) {
            difficultyValues.put(value.getTitle(), value.getHideCell());
        }
        return difficultyValues;
    }
    
}
