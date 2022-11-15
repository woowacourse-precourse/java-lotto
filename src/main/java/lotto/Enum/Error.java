package lotto.Enum;

public enum Error {
    LOTTO_NUM_DUPLICATED_ERROR("[ERROR] 로또 발행 시 번호가 중복되면 안됩니다."),
    LOTTO_NUM_LENGTH_ERROR("[ERROR] 로또 발행 시 번호 갯수는 6개여야 합니다."),
    LOTTO_NUM_RANGE_ERROR("[ERROR] 로또 발행 시 번호 범위는 1부터 45까지여야 합니다."),

    PURCHASE_ONLY_NUMBER_ERROR("[ERROR] 구입 금액은 숫자로만 입력해야합니다."),
    PURCHASE_THOUSAND_MODULAR_ERROR("[ERROR] 구입 금액이 천원 단위여야 합니다."),
    PURCHASE_RANGE_ERROR("[ERROR] 구입 금액이 0원이거나 10만원을 초과하면 안됩니다."),

    DRAW_LOTTO_FORMAT_ERROR("[ERROR] 로또 당첨 번호 입력 형식은 ','로 구분된 6개의 숫자여야 합니다."),
    DRAW_LOTTO_BONUS_ERROR("[ERROR] 로또 당첨 번호 보너스 번호는 1개의 숫자여야 합니다."),
    DRAW_LOTTO_RANGE_ERROR("[ERROR] 로또 당첨 번호는 1부터 45까지의 고유한 숫자여야 합니다."),
    ;

    final private String message;

    Error(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
