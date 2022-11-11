package lotto.util;

public enum SystemMessage {
    MONEY_INPUT("구입금액을 입력해 주세요."),
    PURCHASES_RESULT("개를 구매했습니다."),
    WIN_NUMBER_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요"),
    WIN_STATS("당첨 통계"),
    FIRST_PRIZE("6개 일치 (2,000,000,000원) - "),
    SECOND_PRIZE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD_PRIZE("5개 일치 (1,500,000원) - "),
    FOURTH_PRIZE("4개 일치 (50,000원) - "),
    FIFTH_PRIZE("3개 일치 (5,000원) - "),
    _BLANK("");

    private String content;

    SystemMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
