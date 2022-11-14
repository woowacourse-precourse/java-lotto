package lotto.validator;

public class ErrorConstants {
	public static final String ERROR = "[ERROR] ";

	public static final String ERROR_NOT_NUMBER = ERROR + "입력한 값이 숫자가 아닙니다.";
	public static final String ERROR_NOT_MULTIPLE_OF_THOUSAND = ERROR + "입력한 금액이 1,000원으로 나누어 떨어지지 않습니다.";
	public static final String ERROR_WINNING_NUMBERS_LENGTH = ERROR + "당첨 번호의 개수는 6개여야 합니다.";
	public static final String ERROR_OUT_OF_LOTTO_RANGE = ERROR + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
	public static final String ERROR_DUPLICATION_LOTTO_NUMBER = ERROR + "로또 번호는 중복되지 않는 수로 이루어져야 합니다.";
	public static final String ERROR_DUPLICATION_BONUS_NUMBER = ERROR + "보너스 번호는 당첨 번호와 중복되지 않는 수여야 합니다.";

	public static final String ERROR_WINNING_NUMBER_COUNT = "[ERROR] 당첨 번호와 일치하는 개수에 오류가 있습니다.";
}
