package lotto;

public enum GuideMessage {
    INPUT_REQUEST_MESSAGE ("구입금액을 입력해 주세요."),
    WINNING_NUMBERS_REQUEST_MESSAGE ("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_REQUEST_MESSAGE ("\n보너스 번호를 입력해 주세요."),
    PURCHASE_LOTTO_TICKET_COUNT_MESSAGE ("\n%d개를 구매했습니다.\n"),
    WINNING_STATS_MESSAGE ("\n당첨 통계\n---"),
    FIFTH_WIN_MESSAGE("3개 일치 (5,000원) - %d개\n"),
    FOURTH_WIN_MESSAGE("4개 일치 (50,000원) - %d개\n"),
    THIRD_WIN_MESSAGE("5개 일치 (1,500,000원) - %d개\n"),
    SECOND_WIN_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    FIRST_WIN_MESSAGE("6개 일치 (2,000,000,000원) - %d개\n");

    private String guideMessage;

    GuideMessage(String guideMessage) {
        this.guideMessage = guideMessage;
    }

    public String getMessage() {
        return guideMessage;
    }
}
