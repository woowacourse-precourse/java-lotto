package lotto;

enum ErrorMessage {
	
	ERROR(""),
	NON_NUMERIC("숫자만 입력해주세요.");
	
	String value;
	
	ErrorMessage(String value) {
		this.value = "[ERROR] " + value;
	}
}
