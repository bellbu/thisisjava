package ch09.sec06.exam04;

public class ButtonExample {

	public static void main(String[] args) {
		//버튼 객체 생성
		Button btnOk = new Button();
		Button btnCancel = new Button();
		
		//구현 객체 설정: 클릭 이벤트 처리 할 버튼 객체 설정
		btnOk.setClickListener(new Button.ClickListener() {
			
			@Override
			public void onclick() {
				System.out.println("Ok 버튼을 클릭하였습니다.");
				
			}
		});
		btnCancel.setClickListener(new Button.ClickListener() {
			
			@Override
			public void onclick() {
				System.out.println("Cancel 버튼을 클릭하였습니다.");
				
			}
		});
		
		/* //구현 객체 설정 람다식으로 표현
		btnOk.setClickListener(() -> {
				System.out.println("Ok 버튼을 클릭하였습니다.");
				
		});
		btnCancel.setClickListener(() -> {
				System.out.println("Cancel 버튼을 클릭하였습니다.");
		});
	 	*/
		
		btnOk.click();
		btnCancel.click();

	}

}
