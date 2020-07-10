/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.trisystem.sudoku.trisudoku;

import java.util.List;

/**
 *
 * @author miura
 */
public class GenRandomNumberTest {
    
    public GenRandomNumberTest() {
    }

    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }
    
    /**
     * Test of getList method, of class GenRandomNumberList.
     */
    @org.junit.Test
    public void testGenRandomNumberList() {
        System.out.println("genRandomNumberList");
        List<Integer> expResult = null;
        List<Integer> result = GenRandomNumberList.getList();
        
        for (Integer rndNumber : result) {
            System.out.println(rndNumber);
        }
    }
    
    /**
     * 
     */
    @org.junit.Test
    public void testGetHideSeqNo() {
        System.out.println("getHideSeqNo");
        List<Integer> expResult = null;
        List<Integer> result = GenRandomNumberList.getHideSeqNo(Difficulty.EASY.getHideCell());

        for (Integer seqNo : result) {
            System.out.println("[" + seqNo + "]");
        }

    }
    
}
