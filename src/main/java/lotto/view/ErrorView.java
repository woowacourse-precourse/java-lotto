package lotto.view;

public class ErrorView {

	private static final String ERROR = "[ERROR] ";
	private static final String IS_NOT_NUMBER = "로또 번호는 1부터 45사이의 숫자여야 합니다.";
	private static final String IS_EXIST_REST = "로또 구매 후 돈이 남습니다.";

	public static String isNotNumber() {
		return ERROR +IS_NOT_NUMBER;
	}

	public static String isRest() {
		return ERROR + IS_EXIST_REST;
	}
}
