package lotto;

public enum Error {
    AUTO_LOTTO_NUM_DUPLICATED_ERROR("[ERROR] 자동 로또 발행 시 번호가 중복되면 안됩니다."),
    AUTO_LOTTO_NUM_LENGTH_ERROR("[ERROR] 자동 로또 발행 시 번호 갯수는 6개여야 합니다."),
    AUTO_LOTTO_NUM_RANGE_ERROR("[ERROR] 자동 로또 발행 시 번호 범위는 1부터 45까지여야 합니다."),

    PURCHASE_THOUSAND_ERROR("[ERROR] 구입 금액이 천원 단위여야 합니다."),
    PURCHASE_ZERO_ERROR("[ERROR] 구입 금액이 0원이면 안됩니다."),

    LOTTO_INPUT_FORMAT_ERROR("[ERROR] 로또 당첨 번호 입력 형식은 ','로 구분된 6개의 1부터 45까지의 숫자여야 합니다."),
    LOTTO_INPUT_BONUS_ERROR("[ERROR] 로또 당첨 번호 보너스 번호는 1개의 1부터 45까지의 숫자여야 합니다."),
    LOTTO_INPUT_DUPLICATED_ERROR("[ERROR] 로또 당첨 번호가 중복되면 안됩니다.")
    ;

    final private String message;

    Error(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
