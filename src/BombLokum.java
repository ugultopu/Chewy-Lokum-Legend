import java.util.ArrayList;


public class BombLokum extends Lokum implements ComboDestroyable,
		MergeDestroyable, Swapable {

	public BombLokum(int rowIndex, int columnIndex, String lokumColor) {
		/*
		 * Actually, BombLokum should not have a color. So just enter a dummy value as the color, since
		 * this field will not have any significance for the BombLokum.
		 */
		super(rowIndex, columnIndex, lokumColor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void comboDestroy(ArrayList<ComboDestroyable> comboDestroyedFields) {
		// TODO Auto-generated method stub
		EmptyLogicField destroyed = new EmptyLogicField(getRowIndex(), getColumnIndex());
		BoardLogic.getInstance().introduceLogicField(destroyed);
		
		EventDispatchQueue.getInstance().addEvent(new DestroyLokumEvent(destroyed.copyLogicField()));
		comboDestroyedFields.add(this);
	}

	@Override
	public LogicField copyLogicField() {
		// TODO Auto-generated method stub
		return new BombLokum(getRowIndex(), getColumnIndex(), getLokumColor());
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "BombLokum";
	}
	
//	@Override
//	public void comboDestroy() {
//		// TODO Auto-generated method stub
//		BoardLogic.getInstance().introduceLogicField(new EmptyLogicField(getRowIndex(), getColumnIndex()));
//	}
}
