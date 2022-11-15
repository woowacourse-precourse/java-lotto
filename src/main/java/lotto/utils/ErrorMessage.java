package lotto.utils;

public enum ErrorMessage {
	INPUT_SIX_NUMBER("6개의 숫자를 입력해 주세요"),
	INPUT_NOT_DUPLICATED("중복되지 않은 6개의 숫자를 입력해 주세요."),
	INPUT_VALID_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
	INPUT_ONLY_NUMBER("숫자만 입력해 주세요."),
	INPUT_VALID_MONEY("올바른 금액을 입력해 주세요."),
	INPUT_VALID_UNIT("1000원 단위의 금액이어야 합니다.");
	private String ERROR = "[ERROR] ";
	private String message;

	ErrorMessage(String message) {
		this.message = ERROR + message;
	}

	public String getMessage() {
		return message;
	}
}
