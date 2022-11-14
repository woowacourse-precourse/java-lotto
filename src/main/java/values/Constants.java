package values;

public class Constants {
    public static class Console {
        public static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
        public static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
        public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
        public static final String OUTPUT_CNT = "개를 구매했습니다.";
        public static final String STATISTICS = "당첨 통계\n---";
        public static final String THREE_HIT = "3개 일치 (5,000원) - ";
        public static final String FOUR_HIT = "4개 일치 (50,000원) - ";
        public static final String FIVE_HIT = "5개 일치 (1,500,000원) - ";
        public static final String FIVE_BONUS_HIT = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
        public static final String SIX_HIT = "6개 일치 (2,000,000,000원) - ";
    }

    public static class Util {
        public static final String LOTTO_NUMBER_SEPARATOR = ",";
    }

    public static class Digit {
        public static final int LOTTO_PRICE = 1_000;
        public static final int LOTTO_NUMBER_COUNT = 6;

        public static final int FIRST_PLACE = 1;
        public static final int SECOND_PLACE = 2;
        public static final int THIRD_PLACE = 3;
        public static final int FOURTH_PLACE = 4;
        public static final int FIFTH_PLACE = 5;

        public static final int FIRST_PLACE_PRIZE = 2_000_000_000;
        public static final int SECOND_PLACE_PRIZE = 30_000_000;
        public static final int THIRD_PLACE_PRIZE = 1_500_000;
        public static final int FOURTH_PLACE_PRIZE = 50_000;
        public static final int FIFTH_PLACE_PRIZE = 5_000;
    }

    public static class Error {
        public static final String RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
        public static final String DUPLICATION_ERROR = "[ERROR] 로또 번호에는 중복이 없어야 합니다.";
        public static final String SIZE_ERROR = "[ERROR] 로또 번호는 6개여야 합니다.";
    }
}

