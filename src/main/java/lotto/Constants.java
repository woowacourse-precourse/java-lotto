package lotto;

public class Constants {
	public static final String ERROR = "[ERROR] ";
	public static final String ERROR_NUMBER_PATTERN = ERROR + "숫자로만 입력되지 않았습니다.";
	public static final String ERROR_NUMBER_RANGE = ERROR + "입력은 0보다 커야합니다.";
	public static final String ERROR_NUMBER_PRICE = ERROR + "1,000 단위로만 입력할 수 있습니다.";
	public static final String ERROR_LOTTO_RANGE = ERROR + "로또 당첨번호는 1부터 45 사이의 숫자여야 합니다.";
	public static final String ERROR_BONUS_RANGE = ERROR + "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
	public static final String ERROR_RE_DUPLICATION_LOTTO = ERROR + "로또 값이 중복되지 않아야 합니다.";
	public static final String ERROR_LOTTO_BONUS_SAME = ERROR + "로또 당첨번호와 보너스 번호가 중복됩니다.";
	public static final String ERROR_LOTTO_ONLY_NUMBER = ERROR + "로또 당첨번호는 숫자만 가능합니다.";
	public static final String ERROR_BONUS_ONLY_NUMBER = ERROR + "보너스 번호는 숫자만 가능합니다.";

	public static final String PURCHASE_PRIZE_MESSAGE = "구입금액을 입력해 주세요.";
	public static final String COUNT_LOTTO_PRINT = "개를 구매했습니다.";
	public static final String INPUT_LOTTO_NUMBER_PRINT = "당첨 번호를 입력해 주세요.";
	public static final String INPUT_BONUS_NUMBER_PRINT = "보너스 번호를 입력해 주세요.";
	public static final String WINNING_STATISTICS = "당첨 통계";
	public static final String WINNING_STATISTICS_DIVISION = "---";
	public static final String TOTAL_PROFIT = "총 수익률은 ";
	public static final String END_MESSAGE = "%입니다.";
	public static final String WIN_TOTAL_MESSAGE = "%d개 일치 (%s원) - %d개\n";
	public static final String WIN_BONUS_TOTAL_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";

	public static final int DIVIDE = 1000;
	public static final int START_INCLUSIVE = 1;
	public static final int END_INCLUSIVE = 45;

}
