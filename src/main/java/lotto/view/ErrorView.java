package lotto.view;

public class ErrorView {

	private static final String ERROR = "[ERROR] ";
	private static final String IS_NOT_LOTTO = "로또 번호는 1부터 45사이의 숫자여야 합니다.";
	private static final String IS_EXIST_REST = "로또 구매 후 돈이 남습니다.";
	private static final String IS_NOT_NUMBER = "입력된 값이 숫자가 아닙니다.";
	private static final String IS_NOT_LOTTO_NUMBER = "중복된 값이 있거나, 입력된 로또 번호가 올바르지 않습니다.";

	public static String isNotLotto() {
		System.out.println(ERROR + IS_NOT_LOTTO);
		return ERROR + IS_NOT_LOTTO;
	}

	public static String isNotNumber() {
		System.out.println(ERROR + IS_NOT_NUMBER);
		return ERROR + IS_NOT_NUMBER;
	}

	public static String isExistRest() {
		System.out.println(ERROR + IS_EXIST_REST);
		return ERROR + IS_EXIST_REST;
	}

	public static String isNotLottoNumberList() {
		System.out.println(ERROR + IS_NOT_LOTTO_NUMBER);
		return ERROR + IS_NOT_LOTTO_NUMBER;
	}

}
