package lotto.util;

public final class Constants {
	private Constants() {
	}
	public static final int LOTTO_NUMBER_SIZE = 6;
	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 45;
	public static final int ZERO = 0;
	public static final int LOTTO_PRICE = 1000;
	public static final String DELIMITER = ",";
	public static final String ONLY_INTEGER_SERIES = "^[0-9]*$";

	public static final String ERROR = "[ERROR] ";
	public static final String ERROR_LOTTO_NUMBER_SIZE = ERROR + "로또 번호의 개수가 6개가 아닙니다.";
	public static final String ERROR_NUMERIC = ERROR + "숫자만 입력 가능합니다.";
	public static final String ERROR_ZERO = ERROR + "0은 입력할 수 없습니다.";
	public static final String ERROR_MAX_NUMBER = ERROR + "45보다 큰 숫자는 입력할 수 없습니다.";
	public static final String ERROR_DUPLICATE = ERROR + "중복된 숫자가 있습니다.";
	public static final String ERROR_DUPLICATE_WITH_WINNINGNUM = ERROR + "당첨번호와 중복되는 숫자입니다.";
	public static final String ERROR_UNIT_OF_THOUSAND = ERROR + "1000원 단위로 입력해주세요.";
	public static final String ERROR_NOT_COMMA = ERROR + "구분자가 쉼표가 아닙니다.";
}
