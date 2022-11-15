package lotto.validator;

public enum ErrorMessage {
	NOT_POSITIVE_NUMBER("[ERROR] 입력하는 숫자는 0보다 커야합니다."),
	NOT_NUMBER("[ERROR] 숫자만 입력해야 합니다."),
	NOT_DIVIDED("[ERROR] 구입금액은 1000원 단위여야 합니다."),
	NOT_DUPLICATED("[ERROR] 모든 당첨번호와 중복되면 안됩니다."),
	NOT_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
	COMMA_CLASSIFICATION("[ERROR] 로또 번호는 쉼표(,)로 구분된 6개의 번호를 입력해야 합니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getErrorMessage() {
		return message;
	}

}
