
public class EmptyLogicField extends LogicField {

	public EmptyLogicField(int rowIndex, int columnIndex) {
		super(rowIndex, columnIndex);
		// TODO Auto-generated constructor stub
		BoardLogic.getInstance().introduceLogicField(this);
	}

	@Override
	public LogicField copyLogicField() {
		// TODO Auto-generated method stub
		return new EmptyLogicField(getRowIndex(), getColumnIndex());
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}
}
