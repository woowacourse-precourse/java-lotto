package lotto.config;

public final class Constants {

    private Constants() {
    }

    public static class LottoNumber {
        public static final int LOTTO_SIZE = 6;
        public static final int LOTTO_NUMBER_START_INCLUSIVE = 1;
        public static final int LOTTO_NUMBER_END_INCLUSIVE = 45;
    }

    public static class LottoPrice {
        public static final int LOTTO_PRICE = 1_000;
    }

    public static class LottoInput {
        public static final String ASK_HOW_MUCH_WILL_YOU_BUY = "구입금액을 입력해 주세요.";
        public static final String ASK_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
        public static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    }

    public static class LottoOutput {
        public static final String TELL_PURCHASED_LOTTO_COUNT = "개를 구매했습니다.";
        public static final String STATISTICS_TITLE = "당첨 통계" + System.lineSeparator() + "---";
    }
}
