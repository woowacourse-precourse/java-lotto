package lotto.constant;

public final class Constants {

    public static final class Lotto {
        public static final int SIZE = 6;
        public static final int RANGE_BEGIN = 1;
        public static final int RANGE_END = 45;
    }

    public static final class Money {
        public static final int MINIMUM_AMOUNT = 1000;
        public static final int MAXIMUM_AMOUNT = 100_000;
        public static final int UNIT_AMOUNT = 1000;
    }

    public static final class InputMessage {
        public static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
        public static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
        public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    }

    public static final class OutputMessage {
        public static final String WINNING_STATISTICS = "당첨 통계";
        public static final String DIVISION_LINE = "---";
        public static final String MATCH_NUMBERS = "%d개 일치";
        public static final String MATCH_BONUS_BALL = ", 보너스 볼 일치";
        public static final String TOTAL_YIELD = "총 수익률은 %s%%입니다.\n";
        public static final String PRIZE = " (%s원)";
        public static final String WON_LOTTOS_COUNT = " - %d개";
        public static final String LOTTO_QUANTITY = "%d개를 구매했습니다.\n";
    }

    private Constants() {
    }
}
