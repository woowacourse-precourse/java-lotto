package lotto.util;

public final class Constants {
	private Constants() {
	}
	public static final int LOTTO_NUMBER_SIZE = 6;
	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 45;
	public static final int ZERO = 0;
	public static final int LOTTO_PRICE = 1000;
	public static final int HUNDRED = 100;
	public static final String PERCENTAGE_FORMAT = "%.1f";
	public static final String DELIMITER = ",";
	public static final String MONEY_FORMAT = "###,###";
	public static final String ONLY_INTEGER_SERIES = "^[0-9]*$";

	public static final String ERROR = "[ERROR] ";
	public static final String ERROR_LOTTO_NUMBER_SIZE = ERROR + "로또 번호의 개수가 6개가 아닙니다.";
	public static final String ERROR_NUMERIC = ERROR + "숫자만 입력 가능합니다.";
	public static final String ERROR_ZERO = ERROR + "0은 입력할 수 없습니다.";
	public static final String ERROR_MAX_NUMBER = ERROR + "45보다 큰 숫자는 입력할 수 없습니다.";
	public static final String ERROR_DUPLICATE = ERROR + "중복된 숫자가 있습니다.";
	public static final String ERROR_DUPLICATE_WITH_WINNINGNUM = ERROR + "당첨번호와 중복되는 숫자입니다.";
	public static final String ERROR_UNIT_OF_THOUSAND = ERROR + "1000원 단위로 입력해주세요.";
	public static final String ERROR_NOT_COMMA = ERROR + "숫자 6개를 \",\" 로 구분하여 입력해주세요.";

	public static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
	public static final String OUTPUT_LOTTO_AMOUNT = "개를 구매했습니다.";
	public static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
	public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

	public static final String STATISTICS = "당첨 통계";
	public static final String STATISTICS_WINNING = "---";
	public static final String STATISTICS_WINNING_COUNT = "개 일치";
	public static final String STATISTICS_WINNING_COUNT_WITH_BRACKET = "개 일치 (";
	public static final String STATISTICS_WINNING_BONUS = ", 보너스 볼 일치 (";
	public static final String STATISTICS_WINNING_MONEY = "원) - ";
	public static final String STATISTICS_WINNING_COUNT_MONEY = "개";
	public static final String STATISTICS_PROFIT = "총 수익률은 ";
	public static final String STATISTICS_PROFIT_PERCENT = "%입니다.";
}
