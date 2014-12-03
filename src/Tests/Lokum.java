
public class Lokum {
	
	
	/**
	 * 
	 * @requires
	 * 
	 * <nothing>
	 * 
	 * @ensures
	 * 
	 * E.1) (implicit? because we actually need to call repOK() of this field.) color != null.
	 * E.2) (implicit? because we actually need to call repOK() of this field.) location != null.
	 * E.3) color.repOK() == true.
	 * E.4) location.repOK() == true.
	 * E.5) color's value is indeed a valid color.
	 * 
	 * @modifies
	 * 
	 * <nothing>
	 * @return
	 */
	public boolean repOK(){
		/*
		 * To Do:
		 * -Check privacy scope.
		 * -Check return type.
		 * -Change type of color to enum. (or do a similar solution, but you got the idea.)
		 */
		
		if(color == null)
			return false;
		if(!color.repOK())
			return false;
		if(location == null)
			return false;
		if(!location.repOK())
			return false;
		/*
		 * Following if statement may be changed if we change the way the color of a Lokum is represented.
		 */
		if(!isColorValid(color))
			return false;
		return true;
	}
	
	 /**
 	 * @requires
 	 * 
	 * <nothing>
	 * 
	 * @ensures
	 * 
	 * E.1) An accurate string representation of this instance of Lokum is printed.
	 * 
	 * @modifies
	 * 
	 * <nothing>
	 */
	public String toString(){
		/*
		 * To Do:
		 * -Check privacy scope.
		 * -Check return type.
		 * -Check @requires, @ensures and @modifies.
		 */
		
		System.out.println(color.toString() + " at " + location.toString());
	}

}
