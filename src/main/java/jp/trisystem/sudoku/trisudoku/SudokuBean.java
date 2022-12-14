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
    
    /** 難易度. */
    private String level;
    
    /** 隠すセルの数. */
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
        this.hideCell = Level.BEGINNER.getHideCell();
    
        reset();
    }
    
    
    

    
    /**
     * グリッド(9x9)の作成.
     * 
     */
    private void buildGridNumber() {
        
        // 9x9のグリッドに数値が埋めれるまで繰り返す。
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
     * 9x9の数値が正しく配置されたことの判定.
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
//0～2,3～5,6～8マス毎に分けて判定
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
        }
 }

    /**
     * グリッドのチェック.
     * 
     * @return 全グリッドをチェックした結果を返す
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
     * リセットボタンを押した時.
     */
    public void reset() {
        
        // 9x9の配列作成
        buildGridNumber();
        
        // 隠すセルの番号を取得
        List<Integer> hideSeqNoList = GenRandomNumberList.getHideSeqNo(hideCell);

        // 生成済数値リストから、セルオブジェクトの配列へ設定
        int seq = 0;
        for (int i = 0; i < NINE; i++) {
            GeneratedNumber genNumber = generatedNumberFactoryByColumn(i);
            List<Integer> list = genNumber.getGeneratedNumberList();
            for (int j = 0; j < NINE; j++) {
                // セルオブジェクトの生成
                NumberCell numberCell = new NumberCell();
                numberCell.setNumber(list.get(j));
                
                if (hideSeqNoList.contains(seq)) {
                    numberCell.setReadonly(Boolean.FALSE);
                    numberCell.setHide(Boolean.TRUE);
                }
                
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
     * 全セルのリスト(9*9)を返す.
     *
     * @return 全セルのリスト(9*9)
     */
    public List<NumberCell> getNumberCellRow() {
        List<NumberCell> numberCellList = new ArrayList<>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                //ブロックの枠線の種類を取得
                String cellBorderType = getCellBorderType(row, col);
                this.numberCellArray[row][col].setCellborderType(cellBorderType);
                //リストに格納
                numberCellList.add(this.numberCellArray[row][col]);
            }
        }

        return numberCellList;

    }
    
        /**
         * 枠線の種類(太さ)を返す.
         * 
         * 枠線の種類の定義名称を返す.
         * 
         * @param row 行
         * @param col 列
         * @return 枠線の定義名称
         */
        public String getCellBorderType(int row, int col) {
        CellBorderType cbt = CellBorderType.childCube1;
        // 行の判定
        switch (row) { 
            case 2:
            case 5:
            case 8:
                cbt = CellBorderType.childCube4;
                break;
            default:
                break;
        }
        
        // 列の判定
        switch (col) {
            case 2:
            case 5:
            case 8:
                if (cbt.equals(CellBorderType.childCube1)) {
                    cbt = CellBorderType.childCube3;
                } else {
                    cbt = CellBorderType.childCube2;
                }
                break;
            default:
                break;
        }
        return cbt.name();
    }
    
    


    /**
     * 難易度の種類を返す.
     * 
     * @return 難易度の種類
     */
    public Map<String, Object> getLevelValues() {
        return Level.getLevelValues();
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
