package lotto;

public enum Message {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    COUNT_LOTTO("개를 구매했습니다."),
    INPUT_LOTTO_NUMBER("당첨 번호를 입력해주세요"),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해주세요"),

    ERROR_MORE_SIX_LOTTO("[ERROR] 로또 번호의 개수는 6개가 넘으면 안됩니다."),
    ERROR_DUPLICATED_LOTTO("[ERROR] 로또 번호는 중복될 수 없습니다."),
    BETWEEN_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),

    INCORRECT_MONEY("[ERROR] 값을 잘못 입력하였습니다."),
    INCORRECT_MONEY_UNIT("[ERROR] 1000원 단위로 입력해야 합니다."),

    ERROR_USER_INPUT("[ERROR] 당첨번호는 쉼표를 기준으로 구분해야 합니다."),
    ERROR_INPUT_COUNT("[ERROR] 당첨번호는 6개를 입력해야 합니다."),

    ERROR_INVALID_NUMBER("[ERROR] 잘못된 숫자입니다."),

    STATISTICS("당첨통계\n---"),
    FIFTH("3개 일치 (5,000원) - "),
    FOURTH("4개 일치 (50,000원) - "),
    THIRD("5개 일치 (1,500,000원) - "),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST("6개 일치 (2,000,000,000원) - "),

    COUNT("개"),
    RATE("총 수익률은 "),
    STR("입니다.");

    private String str;

    Message(String str) {
        this.str = str;
    }

    public String getMessage() {
        return str;
    }
}
