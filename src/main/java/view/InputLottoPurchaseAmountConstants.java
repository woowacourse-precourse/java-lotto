package view;

public class InputLottoPurchaseAmountConstants {

	public static final String INPUT_TEXT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

	public static final String ERROR_PURCHASE_AMOUNT_NON_NUMERIC = "[ERROR] 로또 구입금액은 숫자만 입력해야 합니다.";
	public static final String ERROR_PURCHASE_AMOUNT_LESS_THAN_MINIMUM = "[ERROR] 로또 최소 구입금액은 1,000원 입니다.";
	public static final String ERROR_PURCHASE_AMOUNT_MORE_THAN_MAXIMUM = "[ERROR] 로또 최대 구입금액은 8,145,060,000원 입니다.";
	public static final String ERROR_PURCHASE_AMOUNT_INVALID_UNIT = "[ERROR] 로또 구입금액은 1000원 단위여야 합니다.";

	public static final String ALL_CHARACTERS_EXCEPT_NUMBERS = "[+-]?\\d*(\\.\\d+)?";

	public static final long PURCHASE_AMOUNT_MINIMUM = 1000L;
	public static final long PURCHASE_AMOUNT_MAXIMUM = 8145060000L;
	public static final long PURCHASE_AMOUNT_UNIT = 1000L;

	private InputLottoPurchaseAmountConstants() {

	}
}