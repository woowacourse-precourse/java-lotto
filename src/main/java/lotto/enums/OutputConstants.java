package lotto.enums;

public enum OutputConstants {
    ERROR_MESSAGE("[ERROR] = "),
    INPUT_MONEY_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_MONEY_RESULT_MESSAGE("개를 구매했습니다."),
    INPUT_WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    STATISTICS_MESSAGE("당첨 통계\n---"),
    RANK_FIFTH_MESSAGE("3개 일치 (5,000원) - "),
    RANK_FOURTH_MESSAGE("4개 일치 (50,000원) - "),
    RANK_THIRD_MESSAGE("5개 일치 (1,500,000원) - "),
    RANK_SECOND_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    RANK_FIRST_MESSAGE("6개 일치 (2,000,000,000원) - "),
    STATISTICS_END_MESSAGE("개"),
    YIELD_START_MESSAGE("총 수익률은 "),
    YIELD_END_MESSAGE("%입니다."),
    DUMMY_MESSAGE("");


    private final String value;

    OutputConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
