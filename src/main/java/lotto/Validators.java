package lotto;

import java.util.regex.Pattern;

public class Validators {
    private final static int LOTTERY_LENGTH = 6;
    private final static int RANGE_MIN = 1;
    private final static int RANGE_MAX = 45;

    private final static int PRICE_PER_LOTTERY = 1000;

    private final static Pattern REG_EXP = Pattern.compile("\\D+");
    private final static String DELIMITER = ",";

    private enum Exceptions {
        ONE("로또 번호는 1부터 45사이의 숫자여야 합니다."),
        TWO("구입금액은 1000으로 나누어 떨어지는 숫자여야 합니다."),
        THREE("당첨 번호는 쉼표로 구분된 6개의 숫자들이여야 합니다."),
        FOUR("보너스 번호는 당첨 번호에 없는 숫자여야 합니다.");

        private final String message;

        Exceptions(String message) {
            this.message = message;
        }

        public String getMessages() {
            return message;
        }
    }
}
