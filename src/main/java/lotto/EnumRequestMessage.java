package lotto;

public enum EnumRequestMessage {

	BET("구입금액을 입력해 주세요."),
	WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
	BONUS_NUMBER("보너스 번호를 입력해 주세요.");

	private String value;

	EnumRequestMessage(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
