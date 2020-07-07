/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.trisystem.sudoku.trisudoku;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
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
    
    /** メッセージ. */
    private String message;
    
    /** セルオブジェクトの配列. */
    private final NumberCell[][] numberCellArray;
    
    /** 生成済数値リスト_縦1. */
    private GeneratedNumber numberListC1;
    
    /** 生成済数値リスト_縦2. */
    private GeneratedNumber numberListC2;
    
    /** 生成済数値リスト_縦3. */
    private GeneratedNumber numberListC3;
    
    /** 生成済数値リスト_縦4. */
    private GeneratedNumber numberListC4;
    
    /** 生成済数値リスト_縦5. */
    private GeneratedNumber numberListC5;
    
    /** 生成済数値リスト_縦6. */
    private GeneratedNumber numberListC6;
    
    /** 生成済数値リスト_縦7. */
    private GeneratedNumber numberListC7;
    
    /** 生成済数値リスト_縦8. */
    private GeneratedNumber numberListC8;
    
    /** 生成済数値リスト_縦9. */
    private GeneratedNumber numberListC9;
    
    /** 生成済数値リスト_ブロックA. */
    private GeneratedNumber numberListBlockA;
    
    /** 生成済数値リスト_ブロックB. */
    private GeneratedNumber numberListBlockB;
    
    /** 生成済数値リスト_ブロックC. */
    private GeneratedNumber numberListBlockC;
    
    /** 生成済数値リスト_ブロックD. */
    private GeneratedNumber numberListBlockD;
    
    /** 生成済数値リスト_ブロックE. */
    private GeneratedNumber numberListBlockE;
    
    /** 生成済数値リスト_ブロックF. */
    private GeneratedNumber numberListBlockF;
    
    /** 生成済数値リスト_ブロックG. */
    private GeneratedNumber numberListBlockG;
    
    /** 生成済数値リスト_ブロックH. */
    private GeneratedNumber numberListBlockH;
    
    /** 生成済数値リスト_ブロックI. */
    private GeneratedNumber numberListBlockI;
    
    

    /** コンストラクタ. */
    public SudokuBean() {
        this.numberCellArray = new NumberCell[9][9];
    }
    
    /**
     * 初期処理.
     */
    @PostConstruct
    private void init() {
        
    }
    
    /**
     * グリッド(9x9)の作成.
     * 
     */
    private void buildGridNumber() {
        
        do {
            // 初期化
            initializeGeneratedNumber();
            // 1行目から9行目に設定
            for (int x = 0; x < 9; x++) {
                // 1～9の順不同リストの取得
                List<Integer> shuffleList = GenRandomNumberList.getList();
                // 1行分の作成
                makeRow(x, shuffleList);
            }
        } while(!check());
        
        // セルオブジェクトへの設定
        

    }
    
    /**
     * 9x9の数値が正しく配置されたことの判定.
     * 
     * @return 
     */
    private Boolean check() {
        Boolean ret = false;
        if ((numberListC1.getListSize() == 9)
                && (numberListC2.getListSize() == 9)
                && (numberListC3.getListSize() == 9)
                && (numberListC4.getListSize() == 9)
                && (numberListC5.getListSize() == 9)
                && (numberListC6.getListSize() == 9)
                && (numberListC7.getListSize() == 9)
                && (numberListC8.getListSize() == 9)
                && (numberListC9.getListSize() == 9)
                && (numberListBlockA.getListSize() == 9)
                && (numberListBlockB.getListSize() == 9)
                && (numberListBlockC.getListSize() == 9)
                && (numberListBlockD.getListSize() == 9)
                && (numberListBlockE.getListSize() == 9)
                && (numberListBlockF.getListSize() == 9)
                && (numberListBlockG.getListSize() == 9)
                && (numberListBlockH.getListSize() == 9)
                && (numberListBlockI.getListSize() == 9)) {
            ret = true;
        }
        
        return ret;
    }
    

    /**
     * 生成済数値リストの初期化.
     */
    private void initializeGeneratedNumber() {
        numberListC1 = new GeneratedNumber();
        numberListC2 = new GeneratedNumber();
        numberListC3 = new GeneratedNumber();
        numberListC4 = new GeneratedNumber();
        numberListC5 = new GeneratedNumber();
        numberListC6 = new GeneratedNumber();
        numberListC7 = new GeneratedNumber();
        numberListC8 = new GeneratedNumber();
        numberListC9 = new GeneratedNumber();
        
        numberListBlockA = new GeneratedNumber();
        numberListBlockB = new GeneratedNumber();
        numberListBlockC = new GeneratedNumber();
        numberListBlockD = new GeneratedNumber();
        numberListBlockE = new GeneratedNumber();
        numberListBlockF = new GeneratedNumber();
        numberListBlockG = new GeneratedNumber();
        numberListBlockH = new GeneratedNumber();
        numberListBlockI = new GeneratedNumber();
    }
    
    /**
     * 数値の設定.
     * 
     * @param x 行
     * @param shuffleList 9件(1～9)の順不同整数リスト
     */
    private void makeRow(int x, List<Integer> shuffleList) {

        int cellNo;
        List<Integer> usedColumn = new ArrayList<>();
        for (int i = 0; i < 9; i++) {

            // 数値を取り出す
            cellNo = shuffleList.get(i);

            // 1列ずつ左から重複しない列を探し、重複しない場合のみ、
            // 生成済数値リスト（縦）と、生成済数値リスト(ブロック）に設定する。
            for (int y = 0; y < 9; y++) {

                if (!usedColumn.contains(y)) {
                    // 生成済数値リスト（ブロック）の取得
                    GeneratedNumber block = generatedNumberFactory(x, y);
                    if (!block.isExists(cellNo)) {
                        // 生成済数値リスト（縦）の取得
                        GeneratedNumber column = generatedNumberFactoryByColumn(y);
                        if (!column.isExists(cellNo)) {

                            // 生成済数値リストに存在しない場合のみ格納する。
                            block.addNumber(cellNo);
                            column.addNumber(cellNo);
                            
                            // 設定した列番号を保存
                            // 同じ列は対象外とするため。
                            usedColumn.add(y);
                            break;
                        }
                    }
                }
            }
        }

    }
   
    /**
     * ファクトリ.
     * 
     * 対象となる生成済数値リスト(ブロック)を返す.
     * 
     * @param x 行
     * @param y 列
     * @return 生成済数値リスト(ブロック)
     */
    private GeneratedNumber generatedNumberFactory(int x, int y) {

        if (x >= 0 && x < 3) {
            if (y >= 0 && y < 3) {
                return numberListBlockA;
            }
            if (y >= 3 && y < 6) {
                return numberListBlockB;
            }
            if (y >= 6 && y < 9) {
                return numberListBlockC;
            }
        }

        if (x >= 3 && x < 6) {
            if (y >= 0 && y < 3) {
                return numberListBlockD;
            }
            if (y >= 3 && y < 6) {
                return numberListBlockE;
            }
            if (y >= 6 && y < 9) {
                return numberListBlockF;
            }
        }

        if (y >= 0 && y < 3) {
            return numberListBlockG;
        }
        if (y >= 3 && y < 6) {
            return numberListBlockH;
        }
        return numberListBlockI;
    }
    
    /**
     * ファクトリ.
     * 
     * 対象となる生成済数値リスト(縦)を返す.
     * 
     * @param y 列
     * @return 生成済数値リスト(縦)
     */
    private GeneratedNumber generatedNumberFactoryByColumn(int y) {
        switch (y) {
            case 0:
                return numberListC1;
            case 1:
                return numberListC2;
            case 2:
                return numberListC3;
            case 3:
                return numberListC4;
            case 4:
                return numberListC5;
            case 5:
                return numberListC6;
            case 6:
                return numberListC7;
            case 7:
                return numberListC8;
            default:
                break;
        }
        return numberListC9;
        
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
        
        // 9x9の配列作成
        buildGridNumber();

        // 生成済数値リストから、セルオブジェクトの配列へ設定
        
        
        // 隠すセルの設定


        message = null;
    }
    
    /**
     * 
     * 
     * @param x
     * @param y
     * @return 
     */
    public String getCellNumber(int x, int y) {
        String cellNumber = "";
        NumberCell nc = numberCellArray[x][y];
        
        if (!nc.isHide()) {
            cellNumber = String.valueOf(nc.getNumber());
        }
        return cellNumber;
    }
    
    /**
     * 
     * @param x 配列のインデックス
     * @param y 配列のインデックス
     * @return the numberCellArray
     */
    private NumberCell getNumberCell(int x, int y) {
        return numberCellArray[x][y];
    }

    /**
     * 
     * @param x 配列のインデックス
     * @param y 配列のインデックス
     * @param numberCell セル
     */
    private void setNumberCell(int x, int y, NumberCell numberCell) {
        this.numberCellArray[x][y] = numberCell;
    }

}
