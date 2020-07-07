/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.trisystem.sudoku.trisudoku;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成済数値リスト.
 *
 * @author miura
 */
public class GeneratedNumber {

    /** 生成済数値リスト. */
    private List<Integer> generatedNumberList;

    /**
     * コンストラクタ.
     */
    public GeneratedNumber() {
        this.generatedNumberList = new ArrayList<>();
    }
    
    /**
     * リストへの数値の追加.
     * 
     * @param num 追加する数値
     */
    public void addNumber(int num) {
        generatedNumberList.add(num);
    }
    
    /**
     * リストのサイズを返す.
     * 
     * @return リストのサイズ
     */
    public int getListSize() {
        return generatedNumberList.size();
    }
    
    /**
     * リストに数値が存在しているかどうかを返す.
     * 
     * @param num チェックする数値
     * @return 存在の可否
     */
    public Boolean isExists(int num) {
        return generatedNumberList.contains(num);
    }
    
    /**
     * 初期化.
     * 
     */
    public void initialize() {
        this.generatedNumberList = new ArrayList<>();
    }
    
}
