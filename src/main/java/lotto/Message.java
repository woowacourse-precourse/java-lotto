package lotto;

public enum Message { // TODO :: 모든 상수를 다루는 방향으로 바꿀 예정
	BEFORE_BUY("구입금액을 입력해 주세요."),
	AFTER_BUY("개를 구매했습니다."),
	ANSWER_NUMS("당첨 번호를 입력해 주세요."),
	BONUS_NUMS("보너스 번호를 입력해 주세요.");

	private String message;

	Message(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}
