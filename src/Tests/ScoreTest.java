package Tests;

import org.junit.*;

import App.BoardLogic;
import App.EmptyLogicField;
import static org.junit.Assert.*;

public class ScoreTest {
	
	private BoardLogic bl = App.BoardLogic.getInstance();
	
    @Before
    public void setUp() {
        for(int i = 0; i < bl.getColumnSize(); i++){
        	for(int j = 0; j < bl.getRowSize(); j++){
        		EmptyLogicField elf = new EmptyLogicField(i, j);
        		bl.introduceLogicField(elf);
        	}
        }
        
    }


    @After
    public void tearDown() {
      
    }
    
    @Test
    public void threeComboTest() {
        
    }

    @Test
    public void LComboTest() {
        
    }
    
    @Test
    public void TComboTest() {
        
    }
    
    @Test
    public void fourComboTest() {
        
    }
    
    @Test
    public void bombMergeTest() {
        
    }
    
    @Test
    public void stripedStripedMergeTest() {
        
    }
    
    @Test
    public void stripedWrappedMergeTest() {
        
    }
}