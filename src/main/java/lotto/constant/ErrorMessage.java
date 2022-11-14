package lotto.constant;

import static lotto.constant.Rules.END_INCLUSIVE;
import static lotto.constant.Rules.LOTTO_PRICE;
import static lotto.constant.Rules.NUMBER_LENGTH;
import static lotto.constant.Rules.START_INCLUSIVE;

public class ErrorMessage {

    public static final String HEADER = "[ERROR] ";
    public static final String WRONG_LOTTO_NUMBER =
            "로또 번호는 " + START_INCLUSIVE + "부터 " + END_INCLUSIVE + "사이의 숫자여야 합니다.";
    public static final String NOT_DISTINCT = "서로 다른 당첨 번호는 서로 다른 수로 이루어져야합니다.";
    public static final String WRONG_LENGTH = "로또 번호는 " + NUMBER_LENGTH + "자리 숫자여야 합니다.";
    public static final String WRONG_MONEY = "구입 금액은 " + LOTTO_PRICE + "의 배수여야 합니다.";
}
