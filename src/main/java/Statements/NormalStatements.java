package statements;

public enum NormalStatements {
    ASK_MONEY_TO_BUY_LOTTO("구입금액을 입력해 주세요."),
    LET_USER_KNOW_THE_NUMBER_OF_TICKETS("개를 구매했습니다."),
    ASK_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    SHOW_WINNING_RATE_FORM("당첨 통계"),
    SHOW_WINNING_RATE_FORM_LINE("---"),
    THREE_NUMBERS_MATCHED("3개 일치 (5,000원) - "),
    FOUR_NUMBERS_MATCHED("4개 일치 (50,000원) - "),
    FIVE_NUMBERS_MATCHED("5개 일치 (1,500,000원) - "),
    FIVE_NUMBERS_AND_BONUS_MATCHED("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_NUMBERS_MATCHED("6개 일치 (2,000,000,000원) - "),
    COUNTING_UNIT("개"),
    SHOW_WINNING_RATE1("총 수익률은 "),
    SHOW_WINNING_RATE2("%입니다.");


    private final String saying;

    NormalStatements(String saying){
        this.saying = saying;
    }

    public String done(){
        return saying;
    }




}
