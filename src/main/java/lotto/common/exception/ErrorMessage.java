package lotto.common.exception;

public class ErrorMessage {
	public static final String NOT_VALID_INPUT_NULL = "[ERROR] 입력값이 NULL이 될 수 없습니다.";
	public static final String NOT_VALID_INPUT_NOT_NUMERIC = "[ERROR] 정수를 입력해주세요.";
	public static final String NOT_VALID_MONEY_RANGE = "[ERROR] 1000원 이상의 금액을 입력해주세요.";
	public static final String NOT_VALID_UNIT_OF_MONEY = "[ERROR] 1000원 단위로 입력해주세요.";
	public static final String NOT_VALID_NUMBER = "[ERROR] 1~45 범위의 숫자가 아닙니다.";
	public static final String NOT_VALID_SIZE = "[ERROR] 유효하지 않은 크기입니다.";
	public static final String NOT_VALID_LOTTO_DUPLICATE = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";
	public static final String NOT_VALID_WINNING_LOTTO_NULL = "[ERROR] 당첨 번호가 NULL이 될 수 없습니다.";
	public static final String NOT_VALID_WINNING_LOTTO_SIZE = "[ERROR] 당첨 번호는 6개의 숫자여야 합니다.";
	public static final String NOT_VALID_WINNING_LOTTO_NUMBER = "[ERROR] 당첨 번호는 1~45 범위의 숫자여야 합니다.";
	public static final String CONFLICT_BONUS_NUMBER_WITH_WINNING_NUMBER = "[ERROR] 당첨 번호와 중복되지 않는 보너스 번호를 입력해주세요.";
	public static final String NOT_VALID_BONUS_NUMBER_NULL = "[ERROR] 보너스 번호가 NULL이 될 수 없습니다.";

}
