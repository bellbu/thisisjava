package ch09.sec06.exam03;

public class ButtonExample {

	public static void main(String[] args) {
		//버튼 객체 생성
		Button btnOk = new Button();
		Button btnCancel = new Button();
		
		//구현 클래스: 버튼 클릭 이벤트 처리 클래스 정의
		class OkListener implements Button.ClickListener{
			@Override
			public void onclick() {
				System.out.println("Ok 버튼을 클릭하였습니다.");
			}
		}
		class CancelListener implements Button.ClickListener{
			@Override
			public void onclick() {
				System.out.println("Cancel 버튼을 클릭하였습니다.");
			}
		}
		//구현 객체 설정: 클릭 이벤트 처리 할 버튼 객체 설정
		btnOk.setClickListener(new OkListener());
		btnCancel.setClickListener(new CancelListener());
		
		btnOk.click();
		btnCancel.click();

	}

}
