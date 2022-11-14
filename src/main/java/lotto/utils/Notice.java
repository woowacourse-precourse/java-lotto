package lotto.utils;

public enum Notice {
	ERROR("[ERROR] "),
	ERROR_DUPLICATION("중복된 숫자가 있습니다."),
	ERROR_RANGE("1 ~ 45 사이의 숫자만 입력해 주세요."),
	ERROR_DUPLICATION_BONUS("로또 번호와 다른 보너스 숫자를 입력해 주세요."),
	ERROR_MONEY("1000원 단위로 입력해 주세요."),
	ERROR_INPUT_NUMBER("숫자만 입력해 주세요."),
	START("구입금액을 입력해 주세요."),
	PURCHASE("개를 구매했습니다."),
	WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
	BONUS_NUMBER("보너스 번호를 입력해 주세요."),
	STATISTICS("당첨 통계\n---"),
	RATE_OF_RETURN("총 수익률은 "),
	RESULT_COUNT("개 일치"),
	RESULT_BONUS(", 보너스 볼 일치"),
	SPACE(" "),
	RESULT_PERCENT("%입니다."),
	RESULT_VALUE("개"),
	RESULT_WON("원) - "),
	PARENTHESIS("(");

	private final String noticeMessage;

	Notice(String noticeMessage) {
		this.noticeMessage = noticeMessage;
	}

	public String getNoticeMessage() {
		return noticeMessage;
	}
}
