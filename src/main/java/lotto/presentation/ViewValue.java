package lotto.presentation;

public enum ViewValue {

    BUY_INFO_MESSAGE("구매금액을 입력해 주세요."),
    BUY_INFO_DONE("개를 구매했습니다."),
    INSERT_NUMBER_INFO("당첨 번호를 입력해 주세요."),
    INSERT_BONUS_INFO("보너스 번호를 입력해 주세요."),
    WINNING_INFO_MESSAGE("당첨 통계"),
    WINNING_FIFTH("3개 일치 (5,000원) - "),
    WINNING_FOURTH("4개 일치 (50,000원) - "),
    WINNING_THIRD("5개 일치 (1,500,000원) - "),
    WINNING_SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    WINNING_FIRST( "6개 일치 (2,000,000,000원) - "),
    WINNING_END("개"),
    MARGIN_INFO_HEAD("총 수익률은 "),
    MARGIN_INFO_END("%입니다.");

    private final String value;

    ViewValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
