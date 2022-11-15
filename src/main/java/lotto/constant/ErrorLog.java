package lotto.constant;

public enum ErrorLog {
	PURCHASING_AMOUNT_ERROR("[ERROR] 구입 금액은 1000 단위의 정수여야 합니다. ex) 8000"),
	LOTTO_NUMBER_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
	WINNING_NUMBERS_ERROR("[ERROR] 당첨 번호는 공백 없이 쉼표로 구분된 6개의 서로 다른 숫자여야 합니다. ex) 1,2,3,4,5,6"),
	BONUS_NUMBER_ERROR("[ERROR] 보너스 번호는 당첨 번호에 없는 1부터 45 사이의 숫자여야 합니다."),
	ERROR("[ERROR] 올바른 입력이 아닙니다. 프로그램을 종료합니다.");

	private final String log;

	ErrorLog(String log) {
		this.log = log;
	}

	public String log() {
		return log;
	}
}
