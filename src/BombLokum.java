import java.util.ArrayList;


public class BombLokum extends Lokum implements ComboDestroyable,
		MergeDestroyable {

	public BombLokum(int rowIndex, int columnIndex, String lokumColor) {
		super(rowIndex, columnIndex, lokumColor);
		// TODO Auto-generated constructor stub
		BoardLogic.getInstance().introduceLogicField(this);
	}

	@Override
	public void comboDestroy(ArrayList<ComboDestroyable> comboDestroyedFields) {
		// TODO Auto-generated method stub
		BoardLogic.getInstance().introduceLogicField(new EmptyLogicField(getRowIndex(), getColumnIndex()));
		comboDestroyedFields.add(this);
	}

	@Override
	public LogicField copyLogicField() {
		// TODO Auto-generated method stub
		return new BombLokum(getRowIndex(), getColumnIndex(), getLokumColor());
	}
	
//	@Override
//	public void comboDestroy() {
//		// TODO Auto-generated method stub
//		BoardLogic.getInstance().introduceLogicField(new EmptyLogicField(getRowIndex(), getColumnIndex()));
//	}
}
