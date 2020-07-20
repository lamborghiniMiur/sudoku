/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.trisystem.sudoku.trisudoku;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author miura
 */
public class SudokuBeanTest {
    
    public SudokuBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTitle method, of class SudokuBean.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        SudokuBean instance = new SudokuBean();
        String expResult = "数独パズル";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of reset method, of class SudokuBean.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        SudokuBean instance = new SudokuBean();
        instance.reset();
        
        for (int i = 0; i < 9; i++) {
            List<NumberCell> list =  instance.getNumberCellRow();
            for (NumberCell numberCell : list) {
                System.out.print("[" + numberCell.getNumber() + "]"); 
            }
            System.out.println("");
        }
        
        
    }


    
}
