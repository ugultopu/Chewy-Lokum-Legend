public class NormalLokumTest{

	public static Board comboDestroyBoard;

	public void comboDestroyTest(){
		setUP();
		System.out.println(comboDestroyBoard.toString());
		comboLokum.comboDestroy();
//		Check if destroyed lokums are replaced with emptyLogicField
//		Check if the Board is changed
		System.out.println(comboDestroyBoard.toString());
		
	}
}

public class NormalLokum {

	public static Lokum comboLokum;
	
	
	public boolean repOK(){
		/*
		 * To Do:
		 * -Check privacy scope.
		 * -Check return type.
		 * -Check repOK()'s javadoc and implementation. 
		 *  
		 */
		return super.repOK();
	}
	
	/**
	 * This method is the destroy method for the NormalLokum. This method really just sets the
	 * location of this lokum to emptyLogicField in BoardLogic. (and maybe removes this NormalLokum
	 * instance)
	 * 
	 * @requires
	 * 
	 * <nothing>
	 * 
	 * @ensures
	 * 
	 * E.1) Location specified by location:Lokum will be set to an (the) 
	 * emptyLogicField at lokums:BoardLogic.
	 * 
	 * @modifies
	 * 
	 * M.1) lokums:BoardLogic.
	 * M.2) (optional?) this instance of NormalLokum is removed.
	 * 
	 * @return
	 */
	
	private void comboDestroy(){
		/*
		 * To Do:
		 * -Check privacy scope.
		 */
	}

}

