package lotto.domain;

public enum ErrorMessage {
	ERROR_WRONG_PRICE("[ERROR] 가격을 잘못 입력했습니다."),
	ERROR_WRONG_SIZE("[ERROR] 6개의 숫자를 입력해주세요."),
	ERROR_WRONG_RANGE("[ERROR] 범위를 벗어난 수를 입력했습니다."),
	ERROR_OVERLAP("[ERROR] 중복된 값을 입력했습니다."),
	ERROR_WRONG_INPUT("[ERROR] 제대로된 값을 입력하세요."),
	ERROR_NOT_INTEGER("[ERROR] 숫자를 입력하세요.");

	private final String error_message;

	ErrorMessage(String error_message){
		this.error_message = error_message;
	}

	public String getError_message() {
		return error_message;
	}
}
