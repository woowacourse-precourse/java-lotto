package lotto.ui;

public enum Message {

    INPUT_PRICE("구입금액을 입력해 주세요."),
    INPUT_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    BUY_LOTTO("개를 구매했습니다."),
    LOTTO_NUMBER_DELIMITER(", "),
    LOTTO_NUMBER_START("["),
    LOTTO_NUMBER_END("]"),
    LOTTERY_RESULT_TITLE("당첨 통계"),
    LOTTERY_RESULT_SUBDIVISION("---"),
    LOTTERY_RESULT_FIFTH("3개 일치 (5,000원) - "),
    LOTTERY_RESULT_FOURTH("4개 일치 (50,000원) - "),
    LOTTERY_RESULT_THIRD("5개 일치 (1,500,000원) - "),
    LOTTERY_RESULT_SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    LOTTERY_RESULT_FIRST("6개 일치 (2,000,000,000원) - "),
    LOTTERY_RESULT_COUNT("개"),
    PROFIT_RATE_START("총 수익률은 "),
    PROFIT_RATE_END("%입니다."),
    NUMBER_EXCEPTION("[ERROR] 숫자로 된 입력이 아닙니다."),
    LOTTO_NUMBER_EXCEPTION("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    PRICE_EXCEPTION("[ERROR] 구입 금액은 1,000으로 나누어 떨어져야 합니다."),
    SPLIT_BY_COMMA_INPUT_SIZE_EXCEPTION("[ERROR] ',' 로 구분되는 6개의 문자열이어야 합니다."),
    NON_DUPLICATED_LOTTO_NUMBERS_EXCEPTION("[ERROR] 당첨 번호는 중복되지 않는 6개의 숫자여야 합니다.");

    private final String value;

    private Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
