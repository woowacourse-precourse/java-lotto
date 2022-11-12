package lotto.domain;

public enum Error {
	SIZE("로또 번호는 %d개만 가능합니다."),
	DUPLICATE("로또 번호들은 중복될 수 없습니다."),
	UNIT("%d 단위 숫자만 입력해주세요."),
	ZERO("최소 %d원부터 구매 가능합니다."),
	NUMBER("%d ~ %d 사이의 자연수만 입력해주세요."),
	BONUS("보너스 번호는 당첨 번호와 중복될 수 없습니다.")
	;

	private static final String error = "[ERROR] ";

	private final String message;

	Error(String message) {
		this.message = message;
	}

	public String getMessage() {
		return error + message;
	}
}
