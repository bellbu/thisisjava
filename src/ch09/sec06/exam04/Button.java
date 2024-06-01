package ch09.sec06.exam04;

public class Button {

	private ClickListener clickListener;
	
	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}
	
	public void click() {
		clickListener.onclick();
	}
	
	public static interface ClickListener {
		public void onclick();
	}
	
}
