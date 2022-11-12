package lotto;

public enum Message {
	BEFORE_BUY("구입금액을 입력해 주세요."),
	AFTER_BUY("개를 구매했습니다.");

	private String message;

	Message(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}
