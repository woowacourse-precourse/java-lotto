package lotto;

public enum EnumResult {

	COMPARE_RESULT_TITLE("\n당첨 통계\n---\n"),
	COMPARE_RESULT_FIFTH("3개 일치 (5,000원) - "),
	COMPARE_RESULT_FOURTH("4개 일치 (50,000원) - "),
	COMPARE_RESULT_THIRD("5개 일치 (1,500,000원) - "),
	COMPARE_RESULT_SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
	COMPARE_RESULT_FIRST("6개 일치 (2,000,000,000원) - "),
	COMPARE_RESULT_TERMINATION("개\n"),
	YIELD_RESULT_IS("총 수익률은 "),
	TERMINATION("입니다."),
	BET_RESULT("개를 구매했습니다.");

	private String value;

	EnumResult(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static String makeFifth(int count) {
		return COMPARE_RESULT_FIFTH.getValue() + count + COMPARE_RESULT_TERMINATION.getValue();
	}

	public static String makeFourth(int count) {
		return COMPARE_RESULT_FOURTH.getValue() + count + COMPARE_RESULT_TERMINATION.getValue();
	}

	public static String makeThird(int count) {
		return COMPARE_RESULT_THIRD.getValue() + count + COMPARE_RESULT_TERMINATION.getValue();
	}

	public static String makeSecond(int count) {
		return COMPARE_RESULT_SECOND.getValue() + count + COMPARE_RESULT_TERMINATION.getValue();
	}

	public static String makeFirst(int count) {
		return COMPARE_RESULT_FIRST.getValue() + count + COMPARE_RESULT_TERMINATION.getValue();
	}
}
