package lotto;

public enum ConsoleTextVariable {
    INPUT_MONEY_TEXT("구입금액을 입력해 주세요."),
    MONEY_COUNT_TEXT("개를 구매했습니다."),
    INPUT_WINNING_NUMBER_TEXT("당첨 번호를 입력해 주세요."),
    INPUT_BOUNUS_NUMBER_TEXT("보너스 번호를 입력해 주세요."),
    WINNING_STATUS_INTRO_TEXT("당첨 통계\n---\n"),
    HIT_THREE_TEXT("3개 일치 (5,000원) - "),
    HIT_FOUR_TEXT("개\n4개 일치 (50,000원) - "),
    HIT_FIVE_TEXT("개\n5개 일치 (1,500,000원) - "),
    HIT_FIVE_BONUS_TEXT("개\n5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    HIT_SIX__TEXT("개\n6개 일치 (2,000,000,000원) -"),
    WINNING_STATUS_END_TEXT("개\n");
    
    private final String text;

    ConsoleTextVariable(String text) {
        this.text = text;
    }
}
