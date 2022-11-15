package lotto.domain.lotteryserver;

public class Messages {
	private static final String FIRST_ANNOUNCEMENT = "당첨통계\n---\n";
	private static final String NORMAL_WINNER = "개 일치 ";
	private static final String BONUS_WINNER = "개 일치, 보너스 볼 일치 ";
	private static final String LEFT_PAIR = "(";
	private static final String RIGHT_PAIR = "원) - ";
	private static final String NUMBER_UNIT = "개";
	private static final String TOTAL_INFO = "총 수익률은 ";
	private static final String PERCENT = "%입니다.";
	private static final String LOTTO_NUMBERS_ERROR = "[ERROR] 당첨번호가 올바르지 않습니다.";
	private static final String BONUS_NUMBER_ERROR = "[ERROR] 보너스 번호가 올바르지 않습니다.";

	public static String getFirstAnnouncement() {
		return FIRST_ANNOUNCEMENT;
	}

	public static String getNormalWinner() {
		return NORMAL_WINNER;
	}

	public static String getBonusWinner() {
		return BONUS_WINNER;
	}

	public static String getLeftPair() {
		return LEFT_PAIR;
	}

	public static String getRightPair() {
		return RIGHT_PAIR;
	}

	public static String getNumberUnit() {
		return NUMBER_UNIT;
	}

	public static String getTotalInfo() {
		return TOTAL_INFO;
	}

	public static String getPERCENT() {
		return PERCENT;
	}

	public static String getLottoNumbersError() {
		return LOTTO_NUMBERS_ERROR;
	}

	public static String getBonusNumberError() {
		return BONUS_NUMBER_ERROR;
	}
}
