package lotto.error;

public enum ErrorMessage {

    // 지불 금액
    PAYMENT_AMOUNT_IS_ZERO("[ERROR] 지불 금액이 0원입니다."),
    PAYMENT_AMOUNT_UNIT_MISMATCH("[ERROR] 지불 금액이 1,000원 단위가 아닙니다."),

    // 로또
    LOTTO_NUMBER_OVERSIZE("[ERROR] 로또의 번호의 크기가 6이 아닙니다."),
    LOTTO_NUMBER_DUPLICATE("[ERROR] 로또 번호 중 중복된 숫자가 있습니다."),

    // 당첨번호 & 보너스 번호
    WINNING_NUMBER_OVERSIZE("[ERROR] 당첨번호는 6자리만 입력해야 합니다."),
    WINNING_NUMBER_OUT_OF_RANGE("[ERROR] 당첨 번호는 1부터 45까지의 숫자 중 선택해야 합니다."),
    BONUS_NUMBER_OVERSIZE("[ERROR] 보너스 번호는 하나의 숫자만 입력해야 합니다."),
    BONUS_NUMBER_OUF_OF_RANGE("[ERROR] 보너스 번호는 1부터 45까지의 숫자 중 선택해야 합니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    String getMessage() {
        return this.message;
    }

}
