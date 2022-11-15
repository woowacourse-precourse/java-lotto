package lotto.constant;

public enum ExceptionMessage {
    INVALID_PRICE_TYPE("[ERROR] 가격은 숫자의 형태로 주어져야 합니다."),
    INVALID_PRICE_RANGE("[ERROR] 가격은 양수여야 합니다."),
    INVALID_PRICE_VALUE(String.format("[ERROR] 가격은 %d의 배수여야 합니다.",
            Constant.UNIT_PRICE.getValue())),
    INVALID_LOTTO_TYPE(String.format("[ERROR] %d개의 숫자를 ,로 구분하여 입력해야 합니다.",
            Constant.LOTTO_LENGTH.getValue())),
    INVALID_LOTTO_RANGE(String.format("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.",
            Constant.LOTTO_MIN_VALUE.getValue(),
            Constant.LOTTO_MAX_VALUE.getValue())),
    INVALID_LOTTO_DUPLICATE("[ERROR] 로또 번호는 중복될 수 없습니다."),
    INVALID_LOTTO_LENGTH(String.format("[ERROR] 로또 번호는 %d개의 숫자여야 합니다.", Constant.LOTTO_LENGTH.getValue())),
    INVALID_BONUS_TYPE("[ERROR] 보너스 번호는 자연수여야 합니다."),
    INVALID_BONUS_RANGE(String.format("[ERROR] 보너스 번호는 %d부터 %d 사이의 숫자여야 합니다.",
            Constant.LOTTO_MIN_VALUE.getValue(),
            Constant.LOTTO_MAX_VALUE.getValue())),
    INVALID_BONUS_DUPLICATE("[ERROR] 보너스 번호는 로또 당첨 번호와 중복될 수 없습니다.");


    private final String message;

    private ExceptionMessage(String message) {
        this.message = message;
    }

    public String getString() {
        return message;
    }
}
