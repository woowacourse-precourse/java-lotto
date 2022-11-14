package lotto.io;

import lotto.domain.Lotto;

public final class Message {

    public static final String LF = System.lineSeparator();

    // USER MESSAGE
    public static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해주세요.";

    // ERROR MESSAGE
    public static final String ERROR = "[ERROR] ";
    public static final String INPUT_UNIT = Lotto.PRICE + "원 단위로 입력해주세요.";
    public static final String ONLY_NUMBER = "숫자만 입력해주세요.";

    private Message() {

    }

}
