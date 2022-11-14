package lotto;

public enum ErrorMessage {
	TYPE_ERROR("[ERROR] 숫자만 입력 가능합니다."),
	RANGE_ERROR("[ERROR] 1 ~ 45 사이의 숫자만 입력 가능합니다."),
	REMAINDER_ERROR("[ERROR] 1000 단위 입력만 가능합니다."),
	NUMBERS_ERROR("[ERROR] 6개의 번호를 입력해 주세요."),
	DUPLICATE_ERROR("[ERROR] 번호가 중복되지 않도록 입력해 주세요.");
	
	private final String ERROR_MESSAGE;
	
	private ErrorMessage(String errorMessage) {
		ERROR_MESSAGE = errorMessage;
	}
	
	public void printErrorMessage() {
		System.out.println(ERROR_MESSAGE);
	}
}
