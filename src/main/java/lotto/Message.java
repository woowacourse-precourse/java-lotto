package lotto;

public enum Message {
	BEFORE_BYE("구입금액을 입력해 주세요."),
	AFTER_BYE("개를 구매했습니다.");

	private String value;

	private Message(String value){
		this.value = value;
	}
}
