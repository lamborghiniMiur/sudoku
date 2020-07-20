/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.trisystem.sudoku.trisudoku;

import java.util.Map;
import java.util.LinkedHashMap;

/**
 * 難易度.
 *
 * @author トライ十郎
 */
public enum Level {
    /**
     * 初級.
     */
    BEGINNER("初級", 38),

    /**
     * 中級.
     */
    INTERMEDIATE("中級", 50),

    /**
     * 上級.
     */
    ADVANCED("上級", 70);
   
    /**
     * 難易度の名前.
     */
    private final String level;
    
    /**
     * 隠すセルの数.
     */
    private final int hideCell;
    
    /**
     * コンストラクタ.
     * 
     * @param level
     * @param hideCell 
     */
    Level(String level, int hideCell){
        this.level = level;
        this.hideCell = hideCell;
    }

    /**
     * @return the level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @return the hideCell
     */
    public int getHideCell() {
        return hideCell;
    }
    
    /**
     * 難易度のラジオボタンを押した時の処理.
     * 
     * @return 難易度と隠すセルの数を返す.
     */
    public static Map<String, Object> getLevelValues() {
        Map<String, Object> levelValues = new LinkedHashMap<>();
        for (Level value : Level.values()) {
            levelValues.put(value.getLevel(), value.getHideCell());
             }
        return levelValues;
        
        }
    }
    
    
    

