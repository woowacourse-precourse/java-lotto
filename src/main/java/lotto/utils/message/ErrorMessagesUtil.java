package lotto.utils.message;

import static lotto.utils.message.NumberMessagesUtil.LOTTO_MAX;
import static lotto.utils.message.NumberMessagesUtil.LOTTO_MIN;
import static lotto.utils.message.NumberMessagesUtil.LOTTO_PRICE;

public enum ErrorMessagesUtil {
    PREFIX("[ERROR] "),
    ONLY_NUMBERS("숫자만 입력할 수 있습니다."),
    NOT_BLANK("공백은 입력할 수 없습니다."),
    NOT_DIVIDE(String.format("%,d원으로 나누어 떨어지지 않습니다", LOTTO_PRICE.getNumber())),
    DUPLICATE_NUMBER("숫자가 중복되었습니다."),
    LOWER_NUMBER(String.format("%d보다 낮은 수는 입력할 수 없습니다.", LOTTO_MIN.getNumber())),
    UPPER_NUMBER(String.format("%d보다 높은 수는 입력할 수 없습니다.", LOTTO_MAX.getNumber()));


    private final String message;

    ErrorMessagesUtil(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX.message + this.message;
    }

}
