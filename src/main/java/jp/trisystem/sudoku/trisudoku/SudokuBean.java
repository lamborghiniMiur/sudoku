/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.trisystem.sudoku.trisudoku;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    
    /** 縦、横のグリッド数. */
    private static final Integer NINE = 9;
    
    /** 隠すグリッド数. */
    private int hideCell;
    

    /** コンストラクタ. */
    public SudokuBean() {
        this.numberCellArray = new NumberCell[NINE][NINE];
    }
    
    /**
     * 初期処理.
     */
    @PostConstruct
    private void init() {
        
        // 9x9のセルのうち、隠すセルの数を取得
        this.hideCell = Difficulty.EASY.getHideCell();
        
        reset();
    }
    
    /**
     * グリッド(9x9)の作成.
     * 
     */
    private void buildGridNumber() {
        
        // 生成済数値リストにすべての数値(9x9)が埋めれるまで繰り返す。
        // （乱数の生成内容によっては、9x9が埋められない場合があるのので）
        do {
            // 初期化
            initializeGeneratedNumber();
            // 1行目から9行目に設定
            for (int x = 0; x < NINE; x++) {
                // 1～9の順不同リストの取得
                List<Integer> shuffleList = GenRandomNumberList.getList();
                // 1行分の作成
                makeRow(x, shuffleList);
            }
        } while (!check());

    }
    
    /**
     * 生成済数値リストすべてに9件の数値が配置されたことの判定.
     * 
     * @return 正しく配置されたことの可否
     */
    private Boolean check() {
        Boolean ret = false;
        if ((numberListC1.getListSize() == NINE)
                && (numberListC2.getListSize() == NINE)
                && (numberListC3.getListSize() == NINE)
                && (numberListC4.getListSize() == NINE)
                && (numberListC5.getListSize() == NINE)
                && (numberListC6.getListSize() == NINE)
                && (numberListC7.getListSize() == NINE)
                && (numberListC8.getListSize() == NINE)
                && (numberListC9.getListSize() == NINE)
                && (numberListBlockA.getListSize() == NINE)
                && (numberListBlockB.getListSize() == NINE)
                && (numberListBlockC.getListSize() == NINE)
                && (numberListBlockD.getListSize() == NINE)
                && (numberListBlockE.getListSize() == NINE)
                && (numberListBlockF.getListSize() == NINE)
                && (numberListBlockG.getListSize() == NINE)
                && (numberListBlockH.getListSize() == NINE)
                && (numberListBlockI.getListSize() == NINE)) {
            ret = true;
        }
        
        return ret;
    }
    

    /**
     * 生成済数値リストの初期化.
     */
    private void initializeGeneratedNumber() {
        
        // 縦用の初期化
        numberListC1 = new GeneratedNumber();
        numberListC2 = new GeneratedNumber();
        numberListC3 = new GeneratedNumber();
        numberListC4 = new GeneratedNumber();
        numberListC5 = new GeneratedNumber();
        numberListC6 = new GeneratedNumber();
        numberListC7 = new GeneratedNumber();
        numberListC8 = new GeneratedNumber();
        numberListC9 = new GeneratedNumber();
        
        // ブロック用の初期化
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
        for (int i = 0; i < NINE; i++) {

            // 数値を取り出す
            cellNo = shuffleList.get(i);

            // 1列ずつ左から重複しない列を探し、重複しない場合のみ、
            // 生成済数値リスト（縦）と、生成済数値リスト(ブロック）に設定する。
            for (int y = 0; y < NINE; y++) {

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

    /**
     * チェックボタンクリック時の処理.
     * 
     */
    public void execute() {
        
        // チェック
        if (checkAllGrid()) {
            message = "正解です！";
        } else {
            message = "不正解！";
        };
        
        
    }

    /**
     * グリッドのチェック.
     * 
     * @return true:正解、false:不正解(エラーあり)
     */
    private Boolean checkAllGrid() {
        Boolean checkAllGrid = Boolean.TRUE;
        for (int x = 0; x < NINE; x++) {
            for (int y = 0; y < NINE; y++) {
                if (!numberCellArray[x][y].isReadonly()) {
                    numberCellArray[x][y].muchNumber();
                    numberCellArray[x][y].setHide(Boolean.FALSE);
                    if (numberCellArray[x][y].getFixed().equals("error")) {
                        checkAllGrid = Boolean.FALSE;
                    }
                }
            }
        }
        return checkAllGrid;
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
     * リセットボタンを押した時の処理.
     * 
     */
    public void reset() {
        
        // 9x9の組み合わせ作成
        buildGridNumber();
        
        // 隠すセルの番号を取得
        List<Integer> hideSeqNoList = GenRandomNumberList.getHideSeqNo(hideCell);

        // 生成済数値リストから、セルオブジェクトの配列へ設定
        int seq = 0;
        
        // 列のループ
        for (int i = 0; i < NINE; i++) {
            
            // 該当の生成済数値リスト格納クラスをファクトリより取得
            GeneratedNumber genNumber = generatedNumberFactoryByColumn(i);
            List<Integer> list = genNumber.getGeneratedNumberList();

            // 行のループ
            for (int j = 0; j < NINE; j++) {
                // セルオブジェクトの生成
                NumberCell numberCell = new NumberCell();
                numberCell.setNumber(list.get(j));
                
                // 隠すセルの場合の設定
                if (hideSeqNoList.contains(seq)) {
                    numberCell.setReadonly(Boolean.FALSE);
                    numberCell.setHide(Boolean.TRUE);
                }
                
                // セルオブジェクトの配列へ設定
                setNumberCell(i, j, numberCell);
                seq++;
            }
        }

        message = null;
    }
    
    /**
     * セルオブジェクト配列への設定.
     * 
     * @param x 配列のインデックス
     * @param y 配列のインデックス
     * @param numberCell セル
     */
    private void setNumberCell(int x, int y, NumberCell numberCell) {
        this.numberCellArray[x][y] = numberCell;
    }
    
    /**
     * 横1列分のセルのリストを返す.
     * 
     * @param row 行
     * @return 横1列分のセルのリスト
     */
    public List<NumberCell> getNumberCellRow(int row) {
        List<NumberCell> numberCellList = new ArrayList<>();
        
        for (int i = 0; i < NINE; i++) {
            numberCellList.add(this.numberCellArray[row][i]);
        }
        return numberCellList;
        
    }
    
    
    /**
     * 難易度の種類を返す.
     *
     * @return 難易度の種類(f:selectItems用のオブジェクト)
     */
    public Map<String, Object> getDifficultyValues() {
        return Difficulty.getDifficultyValues();
    }

    /**
     * @return the hideCell
     */
    public int getHideCell() {
        return hideCell;
    }

    /**
     * @param hideCell the hideCell to set
     */
    public void setHideCell(int hideCell) {
        this.hideCell = hideCell;
    }

    
    
}
