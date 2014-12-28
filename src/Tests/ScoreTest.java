package Tests;

import java.util.ArrayList;

import org.junit.*;

import App.BoardLogic;
import App.EmptyLogicField;
import App.FiveCombo;
import App.FourCombo;
import App.HorizontalStripedLokum;
import App.LCombo;
import App.LogicField;
import App.Lokum;
import App.NormalLokum;
import App.Score;
import App.ThreeCombo;
import App.VerticalStripedLokum;
import static org.junit.Assert.*;

public class ScoreTest {
	
	private BoardLogic bl = App.BoardLogic.getInstance();
	
    @Before
    public void setUp() {
    	Score.resetInstance();
        for(int i = 0; i < bl.getColumnSize(); i++){
        	for(int j = 0; j < bl.getRowSize(); j++){
        		EmptyLogicField elf = new EmptyLogicField(i, j);
        		bl.introduceLogicField(elf);
        	}
        }
        
    }


    @After
    public void tearDown() {
      System.out.println("---------Test End--------");
    }
    
    @Test
    public void threeComboTest() {
        System.out.println("-------Three Combo Score Test------");
        NormalLokum n1 = new NormalLokum(0, 0, "red");
        NormalLokum n2 = new NormalLokum(0, 1, "red");
        NormalLokum n3 = new NormalLokum(0, 2, "red");
       
        ArrayList<Lokum> comboLokums = new ArrayList<Lokum>();
        comboLokums.add(n1);
        comboLokums.add(n2);
        comboLokums.add(n3);
        
        for(int i = 0; i < 3; i++){
        	bl.introduceLogicField(comboLokums.get(i));
        }
        
        System.out.println(BoardLogicTest.toString(bl));
        
        ThreeCombo testThree = new ThreeCombo(comboLokums);
        testThree.updateScore();
        
        assertEquals(60, Score.getInstance().getCurrentScore());
    }

    @Test
    public void LComboTest() {
    	System.out.println("-------L Combo Score Test------");
    	NormalLokum n1 = new NormalLokum(0, 0, "red");
        NormalLokum n2 = new NormalLokum(0, 1, "red");
        NormalLokum n3 = new NormalLokum(0, 2, "red");
        NormalLokum n4 = new NormalLokum(1, 2, "red");
        NormalLokum n5 = new NormalLokum(2, 2, "red");
        
        ArrayList<Lokum> comboLokums = new ArrayList<Lokum>();
        comboLokums.add(n1);
        comboLokums.add(n2);
        comboLokums.add(n3);
        comboLokums.add(n4);
        comboLokums.add(n5);
        
        for(int i = 0; i < 5; i++){
        	bl.introduceLogicField(comboLokums.get(i));
        }
        
        System.out.println(BoardLogicTest.toString(bl));
        
        LCombo testThree = new LCombo(comboLokums);
        testThree.updateScore();
        
        assertEquals(200, Score.getInstance().getCurrentScore());
    }
    
    @Test
    public void TComboTest() {
    	System.out.println("-------T Combo Score Test------");
    	NormalLokum n1 = new NormalLokum(1, 0, "red");
        NormalLokum n2 = new NormalLokum(1, 1, "red");
        NormalLokum n3 = new NormalLokum(1, 2, "red");
        NormalLokum n4 = new NormalLokum(0, 2, "red");
        NormalLokum n5 = new NormalLokum(2, 2, "red");
        
        ArrayList<Lokum> comboLokums = new ArrayList<Lokum>();
        comboLokums.add(n1);
        comboLokums.add(n2);
        comboLokums.add(n3);
        comboLokums.add(n4);
        comboLokums.add(n5);
        
        for(int i = 0; i < 5; i++){
        	bl.introduceLogicField(comboLokums.get(i));
        }
        
        System.out.println(BoardLogicTest.toString(bl));
        
        LCombo testThree = new LCombo(comboLokums);
        testThree.updateScore();
        
        assertEquals(200, Score.getInstance().getCurrentScore());
    }
    
    @Test
    public void fourComboTest() {
    	System.out.println("-------Four Combo Score Test------");
    
    	NormalLokum n1 = new NormalLokum(1, 0, "red");
        NormalLokum n2 = new NormalLokum(1, 1, "red");
        NormalLokum n3 = new NormalLokum(1, 2, "red");
        NormalLokum n4 = new NormalLokum(1, 3, "red");
        
        ArrayList<Lokum> comboLokums = new ArrayList<Lokum>();
        comboLokums.add(n1);
        comboLokums.add(n2);
        comboLokums.add(n3);
        comboLokums.add(n4);
        
        for(int i = 0; i < 4; i++){
        	bl.introduceLogicField(comboLokums.get(i));
        }
        
        System.out.println(BoardLogicTest.toString(bl));
        
        FourCombo testThree = new FourCombo(comboLokums);
        testThree.updateScore();
        
        assertEquals(120, Score.getInstance().getCurrentScore());
    }
    
    @Test
    public void fiveComboTest() {
    	System.out.println("-------Five Combo Score Test------");
    
    	NormalLokum n1 = new NormalLokum(1, 0, "red");
        NormalLokum n2 = new NormalLokum(1, 1, "red");
        NormalLokum n3 = new NormalLokum(1, 2, "red");
        NormalLokum n4 = new NormalLokum(1, 3, "red");
        NormalLokum n5 = new NormalLokum(1, 4, "red");
        
        ArrayList<Lokum> comboLokums = new ArrayList<Lokum>();
        comboLokums.add(n1);
        comboLokums.add(n2);
        comboLokums.add(n3);
        comboLokums.add(n4);
        comboLokums.add(n5);
        
        for(int i = 0; i < 5; i++){
        	bl.introduceLogicField(comboLokums.get(i));
        }
        
        System.out.println(BoardLogicTest.toString(bl));
        
        FiveCombo testThree = new FiveCombo(comboLokums);
        testThree.updateScore();
        
        assertEquals(200, Score.getInstance().getCurrentScore());
    }
    
    @Test
    
    public void verticalStripedUseTest(){
    	System.out.println("-----Vertical Striped Use Score Test-----");
    	VerticalStripedLokum vsl = new VerticalStripedLokum(0, 0, "red");
  
    	bl.introduceLogicField(vsl);
    	
    	System.out.println(BoardLogicTest.toString(bl));
    	
    	vsl.comboDestroy();
    	
    	assertEquals(bl.getRowSize() * 60, Score.getInstance().getCurrentScore());
    	
    }
    
    @Test
    
    public void horizontalStripedUseTest(){
    	System.out.println("-----Horizontal Striped Use Score Test-----");
    	HorizontalStripedLokum vsl = new HorizontalStripedLokum(0, 0, "red");
  
    	bl.introduceLogicField(vsl);
    	
    	System.out.println(BoardLogicTest.toString(bl));
    	
    	vsl.comboDestroy();
    	
    	assertEquals(bl.getColumnSize() * 60, Score.getInstance().getCurrentScore());
    }
    
    @Test
    public void bombMergeTest() {
    	System.out.println("-------Bomb Merge Score Test------");
    }
    
    @Test
    public void stripedStripedMergeTest() {
    	System.out.println("-------Striped Striped Score Test------");
    }
    
    @Test
    public void stripedWrappedMergeTest() {
    	System.out.println("-------Striped Wrapped Score Test------");
    }
}