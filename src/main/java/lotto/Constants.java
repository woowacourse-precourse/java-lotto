package lotto;

public enum Constants {
    INPUT_COST("구입 금액을 입력해 주세요."),
    SHOW_COST_COUNT("개를 구매했습니다."),

    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요"),
    INPUT_BONUS_NUMBERS("보너스 번호를 입력해 주세요"),

    SHOW_WINNING("당첨 통계"),
    SHOW_WINNING_LINE("---"),
    SHOW_WINNING_FIFTH("3개 일치 (5,000원) - "),
    SHOW_WINNING_FOURTH("4개 일치 (50,000원) - "),
    SHOW_WINNING_THIRD("5개 일치 (1,500,000원) - "),
    SHOW_WINNING_SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SHOW_WINNING_FIRST("6개 일치 (2,000,000,000원) - "),
    SHOW_WINNING_UNIT("개"),

    SHOW_YIELD("총 수익률은 "),
    SHOW_YIELD_PERCENT("%입니다.");

    private final String value;

    private Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

