package Tests;

import App.Lokum;

public class LokumTest {
	
	
	
	public static String toString(Lokum lok){
		/*
		 * To Do:
		 * -Check privacy scope.
		 * -Check return type.
		 * -Check @requires, @ensures and @modifies.
		 */
		int x = lok.getRowIndex();
		int y = lok.getColumnIndex();
		String color = lok.getLokumColor();
		String type = lok.getType();
		return type + " at (" + x + ", " + y + ")" + " with color: " + color;
	}

}
