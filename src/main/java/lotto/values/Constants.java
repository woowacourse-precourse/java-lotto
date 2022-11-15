package lotto.values;

public class Constants {
    public static class Console {
        public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
        public static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
        public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
        public static final String OUTPUT_CNT_MESSAGE = "%d개를 구매했습니다.\n";
        public static final String STATISTICS_MESSAGE = "당첨 통계\n---";
        public static final String THREE_HIT_MESSAGE = "3개 일치 (5,000원) - %d개\n";
        public static final String FOUR_HIT_MESSAGE = "4개 일치 (50,000원) - %d개\n";
        public static final String FIVE_HIT_MESSAGE = "5개 일치 (1,500,000원) - %d개\n";
        public static final String FIVE_BONUS_HIT_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
        public static final String SIX_HIT_MESSAGE = "6개 일치 (2,000,000,000원) - %d개\n";
        public static final String TOTAL_PROFIT_PERCENT_MESSAGE = "총 수익률은 %s%%입니다.\n";
    }

    public static class Util {
        public static final String LOTTO_NUMBER_SEPARATOR = ",";
        public static final String MONEY_REGEX = "[0-9]+";
    }

    public static class Digit {
        public static final int LOTTO_NUMBER_COUNT = 6;
        public static final int MAX_LOTTO_NUMBER = 45;
        public static final int MIN_LOTTO_NUMBER = 1;

        public static final int FIRST_PLACE = 6;
        public static final int SECOND_PLACE = 5;
        public static final int THIRD_PLACE = 4;
        public static final int FOURTH_PLACE = 3;
        public static final int FIFTH_PLACE = 2;

        public static final int SIX_CORRECT = 6;
        public static final int FIVE_CORRECT = 5;
        public static final int FOUR_CORRECT = 4;
        public static final int THREE_CORRECT = 3;

        public static final int FIRST_PLACE_PRIZE = 2_000_000_000;
        public static final int SECOND_PLACE_PRIZE = 30_000_000;
        public static final int THIRD_PLACE_PRIZE = 1_500_000;
        public static final int FOURTH_PLACE_PRIZE = 50_000;
        public static final int FIFTH_PLACE_PRIZE = 5_000;
        public static final int LOTTO_PRICE = 1_000;
    }

    public static class Error {
        public static final String RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
        public static final String DUPLICATION_ERROR_MESSAGE = "[ERROR] 로또 번호에는 중복이 없어야 합니다.";
        public static final String SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
        public static final String MONEY_TYPE_ERROR_MESSAGE = "[ERROR] 입력받은 값이 정수 형태가 아닙니다.";
        public static final String MONEY_VALUE_ERROR_MESSAGE = "[ERROR] 돈은 1000으로 나누어 떨어지는 수만 입력이 가능합니다.";
        public static final String MONEY_VALUE_ZERO_ERROR_MESSAGE = "[ERROR] 0은 입력이 불가능합니다.";
    }
}


