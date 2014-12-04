import java.util.ArrayList;


public abstract class Lokum extends LogicField{

	private String lokumColor;
	private ArrayList<Combo> combosThisLokumIn;

	/**
	 * Whenever a lokum is instantiated, the location in BoardLogic corresponding to Lokum's location is set to this instance.
	 * @param lokumColor
	 * @param logicFieldXPosition
	 * @param logicFieldYPosition
	 */
	public Lokum(int rowIndex, int columnIndex, String lokumColor){
		super(rowIndex, columnIndex);
		this.lokumColor = lokumColor;
		this.combosThisLokumIn = new ArrayList<Combo>();
	}

	public String getLokumColor() {
		return lokumColor;
	}

	public void setLokumColor(String lokumColor) {
		this.lokumColor = lokumColor;
	}
	
	public void firstFindCombos(){
		/*
		 * First, the method checks if this Lokum is an instance of BombLokum. If so, it returns immediately from the method. If not, it keeps on finding the combos which
		 * this Lokum participates in.
		 */
		if(this instanceof BombLokum)
			return;
		/*
		 * If here, then "this" is not an instance of BombLokum. So get the Lokums that are adjacent to it.
		 */
		Lokum aboveLokum = (Lokum) getAboveLogicField();
		Lokum belowLokum = (Lokum) getBelowLogicField();
		Lokum leftLokum = (Lokum) getLeftLogicField();
		Lokum rightLokum = (Lokum) getRightLogicField();
		
		/*
		 * THIS IS EASIER TO IMPLEMENT BUT THIS IS A LESS EFFICIENT METHOD OF CHECKING. SO CONSIDER THIS LATER. 
		 * 
		 * Check ( (leftLokum != null) || (leftLokum != null) ). If this is false, then only remaining possible combos are only one of the basic vertical combos. So if
		 * this fails, go there. Else, for now, all 
		 */
		
		/*
		 * Check leftLokum != null. If this is false, then left lokum is null. Then:
		 * 
		 *		True Branch (leftLokum != null):
		 *		Possibilities:
		 *		-For now, everything keeps on remaining.
		 *		
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 		False Branch (leftLokum == null):
		 * 		Possibilities:
		 * 		-3H1
		 * 		-Basic verticals.
		 * 		-T1
		 * 		-L1
		 * 		-L4
		 * 		Check rightLokum != null. If this is false, then right lokum is null. Then:
		 * 
		 * 			True Branch (rightLokum != null):
		 * 			Possibilities:
		 * 			-3H1
		 * 			-Basic verticals.
		 * 			-T1
		 * 			-L1
		 * 			-L4
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 			False Branch (rightLokum == null):
		 * 			Possibilities:
		 * 			-Just Basic verticals.
		 * 			Check aboveLokum != null. If this is false, then above lokum is null. Then:
		 * 
		 * 				True Branch (aboveLokum != null):
		 * 				Possibilities:
		 * 				-Just basic verticals.
		 * 
		 * 
		 * 
		 * 				False Branch (aboveLokum == null):
		 * 				Possibilities:
		 * 				-3V1.
		 * 				
		 * 				
		 * 				
		 * 				
		 */
	}
	
	public void secondFindCombos(){
		/*
		 * First, the method checks if this Lokum is an instance of BombLokum. If so, it returns immediately from the method. If not, it keeps on finding the combos which
		 * this Lokum participates in.
		 */
		if(this instanceof BombLokum)
			return;
		/*
		 * If here, then "this" is not an instance of BombLokum. So get the Lokums that are adjacent to it.
		 */
		Lokum aboveLokum = (Lokum) getAboveLogicField();
		Lokum belowLokum = (Lokum) getBelowLogicField();
		Lokum leftLokum = (Lokum) getLeftLogicField();
		Lokum rightLokum = (Lokum) getRightLogicField();
		
		if(leftLokum != null){
			/*
			 * If here, then;
			 * 1) leftLokum != null.
			 * 2) rightLokum == ?.
			 * 3) aboveLokum == ?.
			 * 4) belowLokum == ?.
			 * Remaining Possibilities:
			 * -Horizontals except 3H1.
			 * -No verticals.
			 * -T2
			 * -T3
			 * -L2
			 * -L3
			 */
			if(rightLokum != null){
				/*
				 * If here, then;
				 * 1) leftLokum != null.
				 * 2) rightLokum != null.
				 * 3) aboveLokum == ?.
				 * 4) belowLokum == ?.
				 * Remaining Possibilities:
				 * -3H2
				 * -4H1
				 * -4H2
				 * -5H1
				 * -No verticals.
				 * -T2
				 */
				if(aboveLokum != null){
					/*
					 * If here, then;
					 * 1) leftLokum != null.
					 * 2) rightLokum != null.
					 * 3) aboveLokum != null.
					 * 4) belowLokum == ?.
					 * Remaining Possibilities:
					 * -Only T2.
					 */
					if(belowLokum != null){
						/*
						 * If here, then;
						 * 1) leftLokum != null.
						 * 2) rightLokum != null.
						 * 3) aboveLokum != null.
						 * 4) belowLokum != null.
						 * Remaining Possibilities:
						 * -Only T2.
						 */
					}
					else{
						/*
						 * If here, then;
						 * 1) leftLokum != null.
						 * 2) rightLokum != null.
						 * 3) aboveLokum != null.
						 * 4) belowLokum == null.
						 * Remaining Possibilities:
						 * -Such a combination is not possible. So simply return if here. 
						 */
						return;
					}
				}
				else{
					/*
					 * If here, then;
					 * 1) leftLokum != null.
					 * 2) rightLokum != null.
					 * 3) aboveLokum == null.
					 * Remaining Possibilities:
					 * -3H2
					 * -4H1
					 * -4H2
					 * -5H1
					 */
					if(belowLokum != null){
						
					}
					else{
						/*
						 * If here, then;
						 * 1) leftLokum != null.
						 * 2) rightLokum != null.
						 * 3) aboveLokum == null.
						 * 4) belowLokum == null.
						 * Remaining Possibilities:
						 * -3H2
						 * -4H1
						 * -4H2
						 * -5H1
						 */
					}
				}
			}
			else{
				/*
				 * If here, then;
				 * 1) leftLokum != null.
				 * 2) rightLokum == null.
				 * Remaining Possibilities:
				 * -3H3
				 * -T3
				 * -L2
				 * -L3
				 */
			}
		}
		else{
			/*
			 * If here, then;
			 * 1) leftLokum == null.
			 * 2) rightLokum == ?.
			 * 3) aboveLokum == ?.
			 * 4) belowLokum == ?.
			 * Remaining Possibilities:
			 * -3H1
			 * -Basic verticals.
			 * -T1
			 * -L1
			 * -L4
			 */
			if(rightLokum != null){
				
			}
			else{
				/*
				 * If here, then;
				 * 1) leftLokum == null.
				 * 2) rightLokum == null.
				 * Remaining Possibilities:
				 * -Basic verticals.
				 */
				if(aboveLokum != null){
					if(belowLokum != null){
						
					}
					else{
						/*
						 * If here, then;
						 * 1) leftLokum == null.
						 * 2) rightLokum == null.
						 * 3) aboveLokum != null.
						 * 4) belowLokum == null.
						 * Remaining Possibilities:
						 * -3V3.
						 */
						Lokum aboveAboveLokum = (Lokum) aboveLokum.getAboveLogicField();
						if(aboveAboveLokum != null){
							// generate a new vertical 3 combo and return.
							return;
						}
						else{
							/*
							 * If here, then aboveAboveLokum is not a compatible lokum with this combo. So
							 * return, since there are no other options.
							 */
							return;
						}
					}
				}
				else{
					/*
					 * If here, then;
					 * 1) leftLokum == null.
					 * 2) rightLokum == null.
					 * 3) abovelokum == null.
					 * Remaining Possibilities:
					 * -3V1
					 */
					if(belowLokum != null){
						/*
						 * Check if there is a compatible lokum below the belowLokum. If so, we have the
						 * 3V1 as the combo. 
						 */
						Lokum belowBelowLokum = (Lokum) belowLokum.getBelowLogicField();
						if(belowBelowLokum != null){
							// generate a new vertical 3 combo and return.
							return;
						}
						else{
							/*
							 * If here, then belowBelowLokum is not a compatible lokum with this combo. So
							 * return, since there are no other options.
							 */
							return;
						}
					}
					else{
						/*
						 * If here, then;
						 * 1) leftLokum == null.
						 * 2) rightLokum == null.
						 * 3) abovelokum == null.
						 * 4) belowlokum == null.
						 * Remaining Possibilities:
						 * -There aren't any remaining possibilities. So simply return from the method.
						 */
						return;
					}
				}
			}
		}
	}
	
	public void thirdFindCombos(){
		/*
		 * First, the method checks if this Lokum is an instance of BombLokum. If so, it returns immediately from the method. If not, it keeps on finding the combos which
		 * this Lokum participates in.
		 */
		if(this instanceof BombLokum)
			return;
		/*
		 * If here, then "this" is not an instance of BombLokum. So get the Lokums that are adjacent to it.
		 */
		Lokum aboveLokum = (Lokum) getAboveLogicField();
		Lokum belowLokum = (Lokum) getBelowLogicField();
		Lokum leftLokum = (Lokum) getLeftLogicField();
		Lokum rightLokum = (Lokum) getRightLogicField();
		
		if(leftLokum != null){
			/*
			 * 1) leftLokum != null.
			 * 2) rightLokum == ?.
			 * 3) aboveLokum == ?.
			 * 4) belowLokum == ?.
			 */
			if(rightLokum != null){
				/*
				 * 1) leftLokum != null.
				 * 2) rightLokum != null.
				 * 3) aboveLokum == ?.
				 * 4) belowLokum == ?.
				 */
				if(aboveLokum != null){
					/*
					 * 1) leftLokum != null.
					 * 2) rightLokum != null.
					 * 3) aboveLokum != null.
					 * 4) belowLokum == ?.
					 */
					if(belowLokum != null){
						/*
						 * 1) leftLokum != null.
						 * 2) rightLokum != null.
						 * 3) aboveLokum != null.
						 * 4) belowLokum != null.
						 */
					}
					else{
						/*
						 * 1) leftLokum != null.
						 * 2) rightLokum != null.
						 * 3) aboveLokum != null.
						 * 4) belowLokum == null.
						 */
					}
				}
				else{
					/*
					 * 1) leftLokum != null.
					 * 2) rightLokum != null.
					 * 3) aboveLokum == null.
					 * 4) belowLokum == ?.
					 */
					if(belowLokum != null){
						/*
						 * 1) leftLokum != null.
						 * 2) rightLokum != null.
						 * 3) aboveLokum == null.
						 * 4) belowLokum != null.
						 */
					}
					else{
						/*
						 * 1) leftLokum != null.
						 * 2) rightLokum != null.
						 * 3) aboveLokum == null.
						 * 4) belowLokum == null.
						 */
					}
				}
			}
			else{
				/*
				 * 1) leftLokum != null.
				 * 2) rightLokum == null.
				 * 3) aboveLokum == ?.
				 * 4) belowLokum == ?.
				 */
				if(aboveLokum != null){
					/*
					 * 1) leftLokum != null.
					 * 2) rightLokum == null.
					 * 3) aboveLokum != null.
					 * 4) belowLokum == ?.
					 */
					if(belowLokum != null){
						/*
						 * 1) leftLokum != null.
						 * 2) rightLokum == null.
						 * 3) aboveLokum != null.
						 * 4) belowLokum != null.
						 */
					}
					else{
						/*
						 * 1) leftLokum != null.
						 * 2) rightLokum == null.
						 * 3) aboveLokum != null.
						 * 4) belowLokum == null.
						 */
					}
				}
				else{
					/*
					 * 1) leftLokum != null.
					 * 2) rightLokum == null.
					 * 3) aboveLokum == null.
					 * 4) belowLokum == ?.
					 */
					if(belowLokum != null){
						/*
						 * 1) leftLokum != null.
						 * 2) rightLokum == null.
						 * 3) aboveLokum == null.
						 * 4) belowLokum != null.
						 */
					}
					else{
						/*
						 * 1) leftLokum != null.
						 * 2) rightLokum == null.
						 * 3) aboveLokum == null.
						 * 4) belowLokum == null.
						 */
					}
				}
			}
		}
		else{
			/*
			 * 1) leftLokum == null.
			 * 2) rightLokum == ?.
			 * 3) aboveLokum == ?.
			 * 4) belowLokum == ?.
			 */
			if(rightLokum != null){
				/*
				 * 1) leftLokum == null.
				 * 2) rightLokum != null.
				 * 3) aboveLokum == ?.
				 * 4) belowLokum == ?.
				 */
				if(aboveLokum != null){
					/*
					 * 1) leftLokum == null.
					 * 2) rightLokum != null.
					 * 3) aboveLokum != null.
					 * 4) belowLokum == ?.
					 */
					if(belowLokum != null){
						/*
						 * 1) leftLokum == null.
						 * 2) rightLokum != null.
						 * 3) aboveLokum != null.
						 * 4) belowLokum != null.
						 */
					}
					else{
						/*
						 * 1) leftLokum == null.
						 * 2) rightLokum != null.
						 * 3) aboveLokum != null.
						 * 4) belowLokum == null.
						 */
					}
				}
				else{
					/*
					 * 1) leftLokum == null.
					 * 2) rightLokum != null.
					 * 3) aboveLokum == null.
					 * 4) belowLokum == ?.
					 */
					if(belowLokum != null){
						/*
						 * 1) leftLokum == null.
						 * 2) rightLokum != null.
						 * 3) aboveLokum == null.
						 * 4) belowLokum != null.
						 */
					}
					else{
						/*
						 * 1) leftLokum == null.
						 * 2) rightLokum != null.
						 * 3) aboveLokum == null.
						 * 4) belowLokum == null.
						 */
					}
				}
			}
			else{
				/*
				 * 1) leftLokum == null.
				 * 2) rightLokum == null.
				 * 3) aboveLokum == ?.
				 * 4) belowLokum == ?.
				 */
				if(aboveLokum != null){
					/*
					 * 1) leftLokum == null.
					 * 2) rightLokum == null.
					 * 3) aboveLokum != null.
					 * 4) belowLokum == ?.
					 */
					if(belowLokum != null){
						/*
						 * 1) leftLokum == null.
						 * 2) rightLokum == null.
						 * 3) aboveLokum != null.
						 * 4) belowLokum != null.
						 */
					}
					else{
						/*
						 * 1) leftLokum == null.
						 * 2) rightLokum == null.
						 * 3) aboveLokum != null.
						 * 4) belowLokum == null.
						 */
					}
				}
				else{
					/*
					 * 1) leftLokum == null.
					 * 2) rightLokum == null.
					 * 3) aboveLokum == null.
					 * 4) belowLokum == ?.
					 */
					if(belowLokum != null){
						/*
						 * 1) leftLokum == null.
						 * 2) rightLokum == null.
						 * 3) aboveLokum == null.
						 * 4) belowLokum != null.
						 */
					}
					else{
						/*
						 * 1) leftLokum == null.
						 * 2) rightLokum == null.
						 * 3) aboveLokum == null.
						 * 4) belowLokum == null.
						 */
					}
				}
			}
		}
	}
	
	public void fourthFindCombos(){
		/*
		 * First, the method checks if this Lokum is an instance of BombLokum. If so, it returns immediately from the method. If not, it keeps on finding the combos which
		 * this Lokum participates in.
		 */
		if(this instanceof BombLokum)
			return;
		/*
		 * If here, then "this" is not an instance of BombLokum. So get the Lokums that are adjacent to it.
		 */
		Lokum aboveLokum = (Lokum) getAboveLogicField();
		Lokum belowLokum = (Lokum) getBelowLogicField();
		Lokum leftLokum = (Lokum) getLeftLogicField();
		Lokum rightLokum = (Lokum) getRightLogicField();
		
		if(leftLokum != null){
			/*
			 * 1) leftLokum != null.
			 * 2) rightLokum == ?.
			 * 3) aboveLokum == ?.
			 * 4) belowLokum == ?.
			 */
			if(rightLokum != null){
				/*
				 * 1) leftLokum != null.
				 * 2) rightLokum != null.
				 * 3) aboveLokum == ?.
				 * 4) belowLokum == ?.
				 */
				if(aboveLokum != null){
					/*
					 * 1) leftLokum != null.
					 * 2) rightLokum != null.
					 * 3) aboveLokum != null.
					 * 4) belowLokum == ?.
					 */
					if(belowLokum != null){
						/*
						 * 1) leftLokum != null.
						 * 2) rightLokum != null.
						 * 3) aboveLokum != null.
						 * 4) belowLokum != null.
						 * Possibilities:
						 * -T2
						 */
					}
					else{
						/*
						 * 1) leftLokum != null.
						 * 2) rightLokum != null.
						 * 3) aboveLokum != null.
						 * 4) belowLokum == null.
						 * Possibilities:
						 * -A weird 3 combo?
						 */
					}
				}
				else{
					/*
					 * 1) leftLokum != null.
					 * 2) rightLokum != null.
					 * 3) aboveLokum == null.
					 * 4) belowLokum == ?.
					 */
					if(belowLokum != null){
						/*
						 * 1) leftLokum != null.
						 * 2) rightLokum != null.
						 * 3) aboveLokum == null.
						 * 4) belowLokum != null.
						 * Possibilities:
						 * -A weird 3 combo?
						 */
					}
					else{
						/*
						 * 1) leftLokum != null.
						 * 2) rightLokum != null.
						 * 3) aboveLokum == null.
						 * 4) belowLokum == null.
						 * Possibilities:
						 * -3H2
						 * -4H1
						 * -4H2
						 * -5H1
						 */
					}
				}
			}
			else{
				/*
				 * 1) leftLokum != null.
				 * 2) rightLokum == null.
				 * 3) aboveLokum == ?.
				 * 4) belowLokum == ?.
				 */
				if(aboveLokum != null){
					/*
					 * 1) leftLokum != null.
					 * 2) rightLokum == null.
					 * 3) aboveLokum != null.
					 * 4) belowLokum == ?.
					 */
					if(belowLokum != null){
						/*
						 * 1) leftLokum != null.
						 * 2) rightLokum == null.
						 * 3) aboveLokum != null.
						 * 4) belowLokum != null.
						 * Possibilities:
						 * -T3
						 */
					}
					else{
						/*
						 * 1) leftLokum != null.
						 * 2) rightLokum == null.
						 * 3) aboveLokum != null.
						 * 4) belowLokum == null.
						 * Possibilities:
						 * -L3
						 */
					}
				}
				else{
					/*
					 * 1) leftLokum != null.
					 * 2) rightLokum == null.
					 * 3) aboveLokum == null.
					 * 4) belowLokum == ?.
					 */
					if(belowLokum != null){
						/*
						 * 1) leftLokum != null.
						 * 2) rightLokum == null.
						 * 3) aboveLokum == null.
						 * 4) belowLokum != null.
						 * Possibilities:
						 * -L2
						 */
					}
					else{
						/*
						 * 1) leftLokum != null.
						 * 2) rightLokum == null.
						 * 3) aboveLokum == null.
						 * 4) belowLokum == null.
						 * Possibilities:
						 * -
						 */
					}
				}
			}
		}
		else{
			/*
			 * 1) leftLokum == null.
			 * 2) rightLokum == ?.
			 * 3) aboveLokum == ?.
			 * 4) belowLokum == ?.
			 */
			if(rightLokum != null){
				/*
				 * 1) leftLokum == null.
				 * 2) rightLokum != null.
				 * 3) aboveLokum == ?.
				 * 4) belowLokum == ?.
				 */
				if(aboveLokum != null){
					/*
					 * 1) leftLokum == null.
					 * 2) rightLokum != null.
					 * 3) aboveLokum != null.
					 * 4) belowLokum == ?.
					 */
					if(belowLokum != null){
						/*
						 * 1) leftLokum == null.
						 * 2) rightLokum != null.
						 * 3) aboveLokum != null.
						 * 4) belowLokum != null.
						 */
					}
					else{
						/*
						 * 1) leftLokum == null.
						 * 2) rightLokum != null.
						 * 3) aboveLokum != null.
						 * 4) belowLokum == null.
						 */
					}
				}
				else{
					/*
					 * 1) leftLokum == null.
					 * 2) rightLokum != null.
					 * 3) aboveLokum == null.
					 * 4) belowLokum == ?.
					 */
					if(belowLokum != null){
						/*
						 * 1) leftLokum == null.
						 * 2) rightLokum != null.
						 * 3) aboveLokum == null.
						 * 4) belowLokum != null.
						 */
					}
					else{
						/*
						 * 1) leftLokum == null.
						 * 2) rightLokum != null.
						 * 3) aboveLokum == null.
						 * 4) belowLokum == null.
						 */
					}
				}
			}
			else{
				/*
				 * 1) leftLokum == null.
				 * 2) rightLokum == null.
				 * 3) aboveLokum == ?.
				 * 4) belowLokum == ?.
				 */
				if(aboveLokum != null){
					/*
					 * 1) leftLokum == null.
					 * 2) rightLokum == null.
					 * 3) aboveLokum != null.
					 * 4) belowLokum == ?.
					 */
					if(belowLokum != null){
						/*
						 * 1) leftLokum == null.
						 * 2) rightLokum == null.
						 * 3) aboveLokum != null.
						 * 4) belowLokum != null.
						 */
					}
					else{
						/*
						 * 1) leftLokum == null.
						 * 2) rightLokum == null.
						 * 3) aboveLokum != null.
						 * 4) belowLokum == null.
						 */
					}
				}
				else{
					/*
					 * 1) leftLokum == null.
					 * 2) rightLokum == null.
					 * 3) aboveLokum == null.
					 * 4) belowLokum == ?.
					 */
					if(belowLokum != null){
						/*
						 * 1) leftLokum == null.
						 * 2) rightLokum == null.
						 * 3) aboveLokum == null.
						 * 4) belowLokum != null.
						 */
					}
					else{
						/*
						 * 1) leftLokum == null.
						 * 2) rightLokum == null.
						 * 3) aboveLokum == null.
						 * 4) belowLokum == null.
						 */
					}
				}
			}
		}
	}
	
	/**
	 * Remaining possible combo scenario:
	 * 3H1)
	 * 		T-L-L
	 * 3H2)
	 * 		L-T-L
	 * 3H3)
	 * 		L-L-T
	 * 
	 * @requires:
	 * R.1) 3H2
	 * 4H1)
	 * 		L-T-L-L
	 * 
	 * @requires:
	 * R.1) 3H2
	 * 4H2)
	 * 		L-L-T-L
	 * 
	 * @requires:
	 * R.1) 3H2
	 * R.2) 4H1
	 * R.3) 4H2
	 * 5H1)
	 * 		L-L-T-L-L
	 * 
	 * 3V1)  T
	 * 		 |
	 * 		 L
	 * 		 |
	 * 		 L
	 * 
	 * 3V2)  L
	 * 		 |
	 * 		 T
	 * 		 |
	 * 		 L
	 * 
	 * 3V3)  L
	 * 		 |
	 * 		 L
	 * 		 |
	 * 		 T
	 * 
	 * @requires:
	 * R.1) 3V2
	 * 4V1)  L
	 * 		 |
	 * 		 T
	 * 		 |
	 * 		 L
	 * 		 |
	 * 		 L
	 * 
	 * @requires:
	 * R.1) 3V2
	 * 4V2)  L
	 * 		 |
	 * 		 L
	 * 		 |
	 * 		 T
	 * 		 |
	 * 		 L
	 * 
	 * @requires:
	 * R.1) 3V2
	 * R.2) 4V1
	 * R.3) 4V2
	 * 5V1)  L
	 * 		 |
	 * 		 L
	 * 		 |
	 * 		 T
	 * 		 |
	 * 		 L
	 * 		 |
	 * 		 L
	 * 
	 * 
	 * @requires:
	 * R.1) 3H1
	 * R.2) 3V2
	 * T1)
	 * 		L
	 * 		|
	 * 		T--L--L
	 * 		|
	 * 		L
	 * 
	 * @requires:
	 * R.1) 3H2
	 * R.2) 3V2
	 * T2)
	 * 		   L
	 * 		   |
	 * 		L--T--L
	 * 		   |
	 * 		   L
	 * 
	 * @requires:
	 * R.1) 3H3
	 * R.2) 3V2
	 * T3)
	 * 		      L
	 * 		      |
	 * 		L--L--T
	 * 		      |
	 * 		      L
	 * 
	 * @requires:
	 * R.1) 3H1
	 * R.2) 3V1
	 * L1)  T--L--L
	 * 		|
	 * 		L
	 * 		|
	 * 		L
	 * 
	 * @requires:
	 * R.1) 3H3
	 * R.2) 3V1
	 * L2)   L--L--T
	 * 			   |
	 * 			   L
	 * 			   |
	 * 			   L
	 * 
	 * @requires:
	 * R.1) 3H3
	 * R.2) 3V3
	 * L3)			L
	 * 				|
	 * 				L
	 * 				|
	 * 		  L--L--T
	 * 
	 * @requires:
	 * R.1) 3H1
	 * R.2) 3V3
	 * L4)   L
	 * 		 |
	 * 		 L
	 * 		 |
	 * 		 T--L--L
	 */

	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * All possible combo scenarios:
	 * H.1)
	 * 		T-L-L
	 * H.2)
	 * 		L-T-L
	 * H.3)
	 * 		L-L-T
	 * H.4)
	 * 		NOT POSSIBLE! T-L-L-L
	 * H.5)
	 * 		L-T-L-L
	 * H.6)
	 * 		L-L-T-L
	 * H.7)
	 * 		NOT POSSIBLE! L-L-L-T
	 * H.8)
	 * 		NOT POSSIBLE! T-L-L-L-L
	 * H.9)
	 * 		NOT POSSIBLE! L-T-L-L-L
	 * H.10)
	 * 		L-L-T-L-L
	 * H.11)
	 * 		NOT POSSIBLE! L-L-L-T-L
	 * H.12)
	 * 		NOT POSSIBLE! L-L-L-L-T
	 * 
	 * --------------------------------------------------------------------------------------------------------------
	 * Wrapped forming lokums:
	 * T-Shapes:
	 * S.1)
	 * 		L
	 * 		|
	 * 		T--L--L
	 * 		|
	 * 		L
	 * S.2)
	 * 		   L
	 * 		   |
	 * 		L--T--L
	 * 		   |
	 * 		   L
	 * S.3)
	 * 		      L
	 * 		      |
	 * 		L--L--T
	 * 		      |
	 * 		      L
	 * L-Shapes:
	 * --------------------------------------------------------
	 * S.4) T--L--L
	 * 		|
	 * 		L
	 * 		|
	 * 		L
	 * 
	 * NOT POSSIBLE! 
	 * S.5) L--T--L
	 * 		|
	 * 		L
	 * 		|
	 * 		L
	 * 
	 * NOT POSSIBLE! 
	 * S.6) L--L--T
	 * 		|
	 * 		L
	 * 		|
	 * 		L
	 * 
	 * NOT POSSIBLE! 
	 * S.7) L--L--L
	 * 		|
	 * 		T
	 * 		|
	 * 		L
	 * 
	 * NOT POSSIBLE! 
	 * S.8) L--L--L
	 * 		|
	 * 		L
	 * 		|
	 * 		T
	 * --------------------------------------------------------
	 * S.9) T--L--L
	 * 			  |
	 * 			  L
	 * 			  |
	 * 			  L
	 * 
	 * S.10) L--T--L
	 * 			   |
	 * 			   L
	 * 			   |
	 * 			   L
	 * 
	 * S.11) L--L--T
	 * 			   |
	 * 			   L
	 * 			   |
	 * 			   L
	 * 
	 * S.12) L--L--L
	 * 			   |
	 * 			   T
	 * 			   |
	 * 			   L
	 * 
	 * S.13) L--L--L
	 * 			   |
	 * 			   L
	 * 			   |
	 * 			   T
	 * --------------------------------------------------------
	 * 
	 * S.14)		T
	 * 				|
	 * 				L
	 * 				|
	 * 		  L--L--L
	 * 
	 * S.15)		L
	 * 				|
	 * 				T
	 * 				|
	 * 		  L--L--L
	 * 
	 * S.16)		L
	 * 				|
	 * 				L
	 * 				|
	 * 		  L--L--T
	 * 
	 * S.17)		L
	 * 				|
	 * 				L
	 * 				|
	 * 		  L--T--L
	 * 
	 * S.18)		L
	 * 				|
	 * 				L
	 * 				|
	 * 		  T--L--L
	 * --------------------------------------------------------
	 * S.19) T
	 * 		 |
	 * 		 L
	 * 		 |
	 * 		 L--L--L
	 * 
	 * S.20) L
	 * 		 |
	 * 		 T
	 * 		 |
	 * 		 L--L--L
	 * 
	 * S.21) L
	 * 		 |
	 * 		 L
	 * 		 |
	 * 		 T--L--L
	 * 
	 * S.22) L
	 * 		 |
	 * 		 L
	 * 		 |
	 * 		 L--T--L
	 * 
	 * S.23) L
	 * 		 |
	 * 		 L
	 * 		 |
	 * 		 L--L--T
	 */
	
	
	
	
	
	/**
	 * @requires:
	 * R.1) "this" is NOT an instance of BombLokum.
	 * 
	 * This method finds the ThreeCombos "this" lokum in and saves them into the combosThisLokumIn field of this lokum. A lokum may be part of a ThreeCombo in one of the
	 * following scenarios:
	 * S.1)
	 * 		L-T-L
	 * S.2)
	 * 		L-L-T
	 * S.3)
	 * 		T-L-L
	 * S.4)
	 * 		L
	 * 		|
	 * 		T
	 * 		|
	 * 		L
	 * S.5)
	 * 		L
	 * 		|
	 * 		L
	 * 		|
	 * 		T
	 * S.6)
	 * 		T
	 * 		|
	 * 		L
	 * 		|
	 * 		L
	 */
	public void isInThreeCombo(){
		/*
		 * INCOMPLETE!!! ABANDONED TO TRY TO WRITE A MORE GENERIC COMBO FINDING METHOD: findCombos().
		 */
		String comboColor = getLokumColor();
		/*
		 * First, check if the lokum left to this lokum can participate in the combo. If so, S.1 and S.2 may be possible.
		 */
		if(isLeftLogicFieldInCombo(comboColor)){
			/*
			 * If here, then left LogicField is in combo. So first, create a reference to it.
			 */
			Lokum leftLokum = (Lokum)getLeftLogicField();
			
			if(isRightLogicFieldInCombo(comboColor)){
				/*
				 * If here, then S.1 is realized. So create an ArrayList<Lokum> and populate it with correct Lokums to use it as the argument of the ThreeCombo constructor. 
				 */
				ArrayList<Lokum> s1ComboLokums = new ArrayList<Lokum>();
				s1ComboLokums.add((Lokum)getLeftLogicField());
				s1ComboLokums.add(this);
				s1ComboLokums.add((Lokum)getRightLogicField());
				combosThisLokumIn.add(new ThreeCombo(s1ComboLokums));
			}
			if(isRightLogicFieldInCombo(comboColor)){
				/*
				 * If here, then S.1 is realized. So create an ArrayList<Lokum> and populate it with correct Lokums to use it as the argument of the ThreeCombo constructor. 
				 */
			}
		}
	}

	/**
	 * @requires:
	 * R.1) "this" is NOT an instance of BombLokum.
	 * 
	 * This method finds the FourCombos "this" lokum in and saves them into the combosThisLokumIn field of this lokum.
	 */
	public void isInFourCombo(){
		
	}

	/**
	 * @requires:
	 * R.1) "this" is NOT an instance of BombLokum.
	 * 
	 * This method finds the FiveCombos "this" lokum in and saves them into the combosThisLokumIn field of this lokum.
	 */
	public void isInFiveCombo(){
		
	}

	/**
	 * @requires:
	 * R.1) "this" is NOT an instance of BombLokum.
	 * 
	 * This method finds the TCombos "this" lokum in and saves them into the combosThisLokumIn field of this lokum.
	 */
	public void isInTCombo(){
		
	}

	/**
	 * @requires:
	 * R.1) "this" is NOT an instance of BombLokum.
	 * 
	 * This method finds the LCombos "this" lokum in and saves them into the combosThisLokumIn field of this lokum.
	 */
	public void isInLCombo(){
		
	}
	
	/**
	 * @requires:
	 * R.1) "this" is an instance of Lokum.
	 * R.2) "this" is NOT an instance of BombLokum.
	 * 
	 * For a given lokum, this method checks the LogicField above this lokum. Then for current lokum,
	 * two options are possible:
	 * 
	 * O.1) There does not exists any lokum above the current lokum. In this case, method immediately
	 * returns false.
	 * O.2) If #1 is not the case, then above field exists. Then it may not be a lokum. If that is the
	 * case, false is returned.
	 * O.3) If #2 is not the case, then above field is a lokum. If the above field is a lokum, then it
	 * must not be an instance of the BombLokum. If that is not the case, false is returned.
	 * O.4) If #3 is not the case, then, the above field is a lokum and is not a BombLokum, then it's
	 * color must be the same with the color of the current lokum. If that's not the case, false is
	 * returned.
	 * 
	 * Otherwise, true is returned.
	 * 
	 * @return
	 */
	public boolean isAboveLogicFieldInCombo(String colorOfTheCombo){
		int thisLokumsRowIndex = getRowIndex();
		int aboveLokumsRowIndex = thisLokumsRowIndex + 1;
		int columnIndex = getColumnIndex();
		LogicField[][] logicFields = BoardLogic.getInstance().getLogicFields();
		/*
		 * Checks O.1. If true, returns false. 
		 */
		if(aboveLokumsRowIndex >= BoardLogic.getInstance().getRowSize())
			return false;
		/*
		 * If here, then O.1 is not the case. So check O.2.
		 */
		if(!(logicFields[aboveLokumsRowIndex][columnIndex] instanceof Lokum))
			return false;
		/*
		 * If here, then O.2 is not the case. So check O.3.
		 */
		if(logicFields[aboveLokumsRowIndex][columnIndex] instanceof BombLokum)
			return false;
		/*
		 * If here, then O.3 is not the case. So check O.4.
		 */
		if(
				!((Lokum)logicFields[aboveLokumsRowIndex][columnIndex]).getLokumColor().equals(colorOfTheCombo)) 
			return false;
		/*
		 * Else, return true.
		 */
		return true;
	}
	
	public boolean isBelowLogicFieldInCombo(String colorOfTheCombo){
		int thisLokumsRowIndex = getRowIndex();
		int belowLokumsRowIndex = thisLokumsRowIndex - 1;
		int columnIndex = getColumnIndex();
		LogicField[][] logicFields = BoardLogic.getInstance().getLogicFields();
		/*
		 * Checks O.1. If true, returns false. 
		 */
		if(belowLokumsRowIndex < 0)
			return false;
		/*
		 * If here, then O.1 is not the case. So check O.2.
		 */
		if(!(logicFields[belowLokumsRowIndex][columnIndex] instanceof Lokum))
			return false;
		/*
		 * If here, then O.2 is not the case. So check O.3.
		 */
		if(logicFields[belowLokumsRowIndex][columnIndex] instanceof BombLokum)
			return false;
		/*
		 * If here, then O.3 is not the case. So check O.4.
		 */
		if(
				!((Lokum)logicFields[belowLokumsRowIndex][columnIndex]).getLokumColor().equals(colorOfTheCombo)) 
			return false;
		/*
		 * Else, return true.
		 */
		return true;
	}
	
	public boolean isLeftLogicFieldInCombo(String colorOfTheCombo){
		int thisLokumsColumnIndex = getColumnIndex();
		int leftLokumsColumnIndex = thisLokumsColumnIndex - 1;
		int rowIndex = getRowIndex();
		LogicField[][] logicFields = BoardLogic.getInstance().getLogicFields();
		/*
		 * Checks O.1. If true, returns false. 
		 */
		if(leftLokumsColumnIndex < 0)
			return false;
		/*
		 * If here, then O.1 is not the case. So check O.2.
		 */
		if(!(logicFields[rowIndex][leftLokumsColumnIndex] instanceof Lokum))
			return false;
		/*
		 * If here, then O.2 is not the case. So check O.3.
		 */
		if(logicFields[rowIndex][leftLokumsColumnIndex] instanceof BombLokum)
			return false;
		/*
		 * If here, then O.3 is not the case. So check O.4.
		 */
		if(
				!((Lokum)logicFields[rowIndex][leftLokumsColumnIndex]).getLokumColor().equals(colorOfTheCombo)) 
			return false;
		/*
		 * Else, return true.
		 */
		return true;
	}
	
	public boolean isRightLogicFieldInCombo(String colorOfTheCombo){
		int thisLokumsColumnIndex = getColumnIndex();
		int rightLokumsColumnIndex = thisLokumsColumnIndex + 1;
		int rowIndex = getRowIndex();
		LogicField[][] logicFields = BoardLogic.getInstance().getLogicFields();
		/*
		 * Checks O.1. If true, returns false. 
		 */
		if(rightLokumsColumnIndex >= BoardLogic.getInstance().getColumnSize())
			return false;
		/*
		 * If here, then O.1 is not the case. So check O.2.
		 */
		if(!(logicFields[rowIndex][rightLokumsColumnIndex] instanceof Lokum))
			return false;
		/*
		 * If here, then O.2 is not the case. So check O.3.
		 */
		if(logicFields[rowIndex][rightLokumsColumnIndex] instanceof BombLokum)
			return false;
		/*
		 * If here, then O.3 is not the case. So check O.4.
		 */
		if(
				!((Lokum)logicFields[rowIndex][rightLokumsColumnIndex]).getLokumColor().equals(colorOfTheCombo)) 
			return false;
		/*
		 * Else, return true.
		 */
		return true;
	}
	
	/**
	 * @requires:
	 * R.1) "this" is not an instance of BombLokum.
	 * 
	 * This method checks the logic field above and returns that if that logic field is in the combo. If not, it returns null.
	 * @return
	 */
	public LogicField getAboveLogicField(){
		if(isAboveLogicFieldInCombo(getLokumColor()))
			return BoardLogic.getInstance().getLogicFieldAt(getRowIndex()+1, getColumnIndex());
		return null;
	}
	public LogicField getBelowLogicField(){
		if(isBelowLogicFieldInCombo(getLokumColor()))
			return BoardLogic.getInstance().getLogicFieldAt(getRowIndex()-1, getColumnIndex());
		return null;
	}
	public LogicField getLeftLogicField(){
		if(isLeftLogicFieldInCombo(getLokumColor()))
			return BoardLogic.getInstance().getLogicFieldAt(getRowIndex(), getColumnIndex()-1);
		return null;
	}
	public LogicField getRightLogicField(){
		if(isRightLogicFieldInCombo(getLokumColor()))
			return BoardLogic.getInstance().getLogicFieldAt(getRowIndex(), getColumnIndex()+1);
		return null;
	}
	
//	/**
//	 * @requires
//	 * 
//	 * <nothing>
//	 * 
//	 * @ensures
//	 * 
//	 * E.1) (implicit? because we actually need to call repOK() of this field.) color != null.
//	 * E.2) (implicit? because we actually need to call repOK() of this field.) location != null.
//	 * E.3) color.repOK() == true.
//	 * E.4) location.repOK() == true.
//	 * E.5) color's value is indeed a valid color.
//	 * 
//	 * @modifies
//	 * 
//	 * <nothing>
//	 */	
//	public boolean repOK(){
//		/*
//		 * To Do:
//		 * -Check privacy scope.
//		 * -Check return type.
//		 * -Change type of lokumColor to enum. (or do a similar solution, but you got the idea.)
//		 */
//		if(lokumColor == null)
//			return false;
//		if(!lokumColor.repOK())
//			return false;
//		if(location == null)
//			return false;
//		if(!location.repOK())
//			return false;
//		/*
//		 * Following if statement may be changed if we change the way the lokumColor of a Lokum is represented.
//		 */
//		if(!islokumColorValid(lokumColor))
//			return false;
//		return true;
//	}
//	
//	/**
//	 * @requires
//	 * 
//	 * <nothing>
//	 * 
//	 * @ensures
//	 * 
//	 * E.1) An accurate string representation of this instance of Lokum is returned.
//	 * 
//	 * @modifies
//	 * 
//	 * <nothing>
//	 */
//	public String toString(){
//		/*
//		 * To Do:
//		 * -Check privacy scope.
//		 * -Check return type.
//		 * -Check @requires, @ensures and @modifies.
//		 */
//		return lokumColor.toString() + " at " + getRowIndex() + ", " + getColumnIndex() + ".";
//	}
		
}
