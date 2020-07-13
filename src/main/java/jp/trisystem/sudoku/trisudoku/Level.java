/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.trisystem.sudoku.trisudoku;

import java.util.Map;
import java.util.LinkedHashMap;

/**
 *
 * @author トライ十郎
 */
public enum Level {
    BEGINNER("初級", 38),
    INTERMEDIATE("中級",50),
    ADVANCED("上級",70);
    
    private final String level;
    private final int hideCell;
    
    Level(String level,int hideCell){
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
    
    public static Map<String, Object> getLevelValues() {
        Map<String,Object> levelValues = new LinkedHashMap<>();
        for (Level value : Level.values()) {
            levelValues.put(value.getLevel(), value.getHideCell());
             }
        return levelValues;
        
        }
    }
    
    
    

