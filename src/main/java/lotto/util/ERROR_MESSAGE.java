package lotto.util;

public enum ERROR_MESSAGE {
    NUMBER_RANGE_EXCEPTION("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NUMBER_SIZE_EXCEPTION("당첨 번호는 6자리 숫자여야 합니다."),
    NUMBER_DUPLICATED("당첨 숫자들은 중복되지 않아야 합니다."),
    BONUS_NUMBER_DUPLICATED("보너스 숫자는 당첨 숫자와 달라야 합니다."),
    NUMBER_TYPE_EXCEPTION("숫자는 , 로 구분되어야 합니다."),
    PURCHASE_UNIT_ERROR("구입금액은 1000원 단위여야 합니다."),
    ;

    private String message;

    ERROR_MESSAGE(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
