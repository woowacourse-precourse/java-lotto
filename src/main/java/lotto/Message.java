package lotto;

public enum Message {
    INPUT_PAYMENT("구매금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    OUTPUT_BUYING("개를 구매했습니다."),
    OUTPUT_STATISTICS("당첨 통계\n---"),

    THREE_CORRECT("3개 일치 (5,000원) - "),
    FOUR_CORRECT("4개 일치 (50,000원) - "),
    FIVE_CORRECT("5개 일치 (1,500,000원) - "),
    FIVE_BONUS_CORRECT("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_CORRECT("6개 일치 (2,000,000,000원) - "),

    EARNING_RATE("총 수익률은 "),

    ERROR_INCORRECT_PRICE("구입금액은 1,000원 단위로 입력되어야 합니다."),
    ERROR_INCORRECT_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_INCORRECT_QUANTITY("로또 번호는 6자리 숫자로 이루어져야 합니다."),
    ERROR_DUPLICATED("로또 번호는 중복되지 않는 숫자로 이루어져야 합니다."),

    ENDING("%입니다."),
    COUNT("개"),
    ERROR("[ERROR] ")
    ;

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String get(){
        return message;
    }
}
