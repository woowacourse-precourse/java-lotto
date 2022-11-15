package lotto.ui;

public enum Display {
	INPUT_PURCHASE("구입금액을 입력해 주세요."),
	BUY_LOTTO("개를 구매했습니다."),
	INPUT_WINNING("당첨 번호를 입력해 주세요."),
	INPUT_BONUS("보너스 번호를 입력해 주세요."),
	SHOW_RESULT("당첨 통계");

	private final String display;

	Display(String display){
		this.display = display;
	}

	public String getDisplay() {
		return display;
	}
}
