/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.trisystem.sudoku.trisudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 順不同リスト作成クラス.
 *
 * @author miura
 */
public class GenRandomNumberList {
    
    /**
     * 順不同の1～9の整数が含まれたリストを返す.
     * 
     * @return 順不同リスト
     */
    public List<Integer> getList() {

        // 1～9の整数をリストにセット
        List<Integer> randomNumberList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            randomNumberList.add(i);
        }
        
        // リストをシャッフル
        Collections.shuffle(randomNumberList);
        return randomNumberList;
        
    }
    
}
