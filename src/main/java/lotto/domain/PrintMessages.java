package lotto.domain;

public enum PrintMessages {
    INPUT_MONEY("구입금액을 입력해 주세요"),
    INPUT_NUMBER("\n당첨 번호를 입력해 주세요"),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요"),
    LOTTO_COUNT("개를 구매했습니다."),
    LOTTO_RESULT("\n당첨 통계\n" + "---\n"),
    LOTTO_PERCENT_FRONT("총 수익률은 "),
    LOTTO_PERCENT_END("%입니다."),
    ERROR_DUPLICATE("[ERROR] 당첨번호는 중복되면 안됩니다."),
    ERROR_NUMBER("[ERROR] 입력형식은 숫자만 가능합니다"),
    ERROR_NUMBER_RANGE("[ERROR] 번호는 1 ~ 45까지만 입력 가능합니다."),
    ERROR_SIZE("[ERROR] 숫자는 6개를 입력해야합니다."),
    ERROR_MONEY_RANGE("금액은 1000 단위로 입력 가능합니다"),
    ERROR_MONEY_MIN("최소금액은 1000원입니다.");

    private String message;

    PrintMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void printMessage() {
        System.out.println(this.message);
    }
}