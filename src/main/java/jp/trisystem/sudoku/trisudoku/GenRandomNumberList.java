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
public final class GenRandomNumberList {
    
    /**
     * コンストラクタ.
     */
    private GenRandomNumberList() {
        
    }

    
    /**
     * 順不同の1～9の整数が含まれたリストを返す.
     * 
     * @return 順不同リスト
     */
    public static List<Integer> getList() {

        // 1～9の整数をリストにセット
        List<Integer> randomNumberList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            randomNumberList.add(i);
        }
        
        // リストをシャッフル
        Collections.shuffle(randomNumberList);
        return randomNumberList;
        
    }
    
    /**
     * 隠すセルの番号リストを返す.
     * 
     * @return 隠すセルの番号リスト
     */
    public static List<Integer> getHideSeqNo(int hideCell) {
        List<Integer> hideSeqNo = new ArrayList<>();
        
        List<Integer> intList = new ArrayList<>();
        //81は数独のブロックの数
        for (int i = 0; i < 81; i++) {
            intList.add(i);
        }
        
        // リストをシャッフル
        Collections.shuffle(intList);

        // シャッフルしたリストから最初の所定の件数のみ取得して返す。
        for (int i = 0; i < hideCell; i++) {
            hideSeqNo.add(intList.get(i));
        }
        
        Collections.sort(hideSeqNo);

        return hideSeqNo;
    }
    
}
