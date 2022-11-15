package lotto.io;

import lotto.domain.Lotto;

public final class Message {

    public static final String LF = System.lineSeparator();

    // USER MESSAGE
    public static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해주세요.";
    public static final String BOUGHT_N = "개를 구매했습니다.";
    public static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String WINNING_STATISTICS = "당첨통계\n---";
    public static final String RESULT = "총 수익률은 %.1f%%입니다.";

    // ERROR MESSAGE
    public static final String ERROR = "[ERROR] ";
    public static final String INPUT_UNIT = Lotto.PRICE + "원 단위로 입력해주세요.";
    public static final String ONLY_NUMBER = "숫자만 입력해주세요.";
    public static final String INPUT_6_NUMBERS_WITH_COMMA = "6개의 숫자를 쉼표로 구분하여 입력해주세요.";
    public static final String WITHOUT_OVERLAP = "중복되지 않는 6개의 수를 입력해주세요,";
    public static final String INPUT_FROM_1_TO_45 = "1 이상 45 이하의 숫자만 입력해주세요.";

    private Message() {

    }

}
