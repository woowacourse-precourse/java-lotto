package lotto.resources;

public enum Sentence {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    YOU_PURCHASED("\n%d개를 구매했습니다."),
    INPUT_ANSWER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS("보너스 번호를 입력해 주세요."),
    OUTPUT_RESULT_3("3개 일치 (5,000원) - %d개"),
    OUTPUT_RESULT_4("4개 일치 (50,000원) - %d개"),
    OUTPUT_RESULT_5("5개 일치 (1,500,000원) - %d개"),
    OUTPUT_RESULT_BONUS5("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    OUTPUT_RESULT_6("6개 일치 (2,000,000,000원) - %d개"),
    WIN_STATISTICS("당첨 통계\n---"),
    TOTAL_YIELD("총 수익률은 %s%%입니다."),

    WINNING_NOT_VALID("[ERROR] Winning number is not valid"),
    WINNING_TWO_COMMA("[ERROR] Duplicated comma input"),
    WINNING_DUPLICATED("[ERROR] Duplicated Answer input"),
    BONUS_NOT_NUMERIC("[ERROR] Bonus input is not numeric"),
    BONUS_OUT_OF_RANGE("[ERROR] Bonus input is out of range"),
    BONUS_IN_ANSWER("[ERROR] Bonus input is included in answer"),
    MONEY_NOT_NUMERIC("[ERROR] Input Money is not numeric"),
    MONEY_NOT_VALID("[ERROR] Input Money is not valid"),
    MONEY_NOT_DIVIDED("[ERROR] Input Money is not divided by 1000");

    private final String s;

    Sentence(String s) {
        this.s = s;
    }

    public String getValue() {
        return s;
    }
}
