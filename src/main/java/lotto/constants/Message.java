package lotto.constants;

public class Message {

	private Message() {}

	public static final String ERROR_PREFIX = "[ERROR] ";

	public static final String ERROR_HAS_DUPLICATED_LOTTO_NUMBER = ERROR_PREFIX + "중복된 로또 번호 입니다.";
	public static final String ERROR_INVALID_LOTTO_LENGTH = ERROR_PREFIX + "유효하지 않는 로또번호 개수 입니다.";
	public static final String ERROR_HAS_INVALID_LOTTO_NUMBER_VALUE = ERROR_PREFIX + "로또 번호는 1~45 사이어야 합니다.";
	public static final String ERROR_EXISTED_LOTTO_BONUS_NUMBER = ERROR_PREFIX + "이미 당첨로또 번호인 숫자는 보너스 숫자가 될 수 없습니다.";

	public static final String ERROR_EMPTY_INPUT = ERROR_PREFIX + "빈 문자열을 입력하면 안됩니다.";
	public static final String ERROR_IS_NOT_NUMERIC_VALUE = ERROR_PREFIX + "숫자만 입력해야 합니다.";
	public static final String ERROR_FIRST_CHAR_IS_ZERO = ERROR_PREFIX + "맨 첫 숫자는 0이면 안됩니다.";

	public static final String ERROR_NOT_ENOUGH_PURCHASE_AMOUNT_INPUT =
			ERROR_PREFIX + "적어도 1개의 로또는 살 수 있는 금액이어야 합니다.";
	public static final String ERROR_DONT_DIVIDED_BY_LOTTO_PRICE =
			ERROR_PREFIX + "1000원 단위로 나누어 떨어지는 숫자를 입력하셔야 합니다.";


	public static final String ASK_ENTER_THE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
	public static final String ASK_ENTER_THE_WINNING_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
	public static final String ASK_ENTER_THE_WINNING_LOTTO_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
	public static final String SHOW_USER_PURCHASED_LOTTO_COUNT = "%d개를 구매했습니다.\n";

}
