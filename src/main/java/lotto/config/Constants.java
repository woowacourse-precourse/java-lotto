package lotto.config;

import java.util.Arrays;
import java.util.List;

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
        public static final String ASK_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
        public static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    }

    public static class LottoOutput {
        public static final String TELL_PURCHASED_LOTTO = "개를 구매했습니다.";
        public static final String STATISTICS = "당첨 통계" + System.lineSeparator() + "---";
    }

    public static class LottoPrizeFilter {
        public static final List<String> NOT_ALLOWED_RECORD_PRIZE = List.of("LOST");
    }

}
