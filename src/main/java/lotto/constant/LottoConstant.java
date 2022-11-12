package lotto.constant;

import java.text.DecimalFormat;

public class LottoConstant {

    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int LOTTO_NUMBER_RANGE_MIN = 1;
    public static final int LOTTO_NUMBER_RANGE_MAX = 45;
    public static final int LOTTO_PRICE = 1000;

    public static class ExceptionMessage {

        private static final DecimalFormat formatter = new DecimalFormat("###,###");
        public static final String INVALID_INPUT_ONLY_NUMBER = "숫자만을 입력해야 합니다.";
        public static final String INVALID_INPUT_ONLY_NUMBER_COMMA = "숫자와 쉼표(,)만을 입력해야 합니다.";
        public static final String INVALID_LOTTO_NUMBER_COUNT = "로또 번호는 숫자 " + LOTTO_NUMBER_COUNT +"개이어야 합니다.";
        public static final String INVALID_LOTTO_NUMBER_RANGE = "로또 번호의 숫자 범위는 " +
                LOTTO_NUMBER_RANGE_MIN + "~" + LOTTO_NUMBER_RANGE_MAX + "까지여야 합니다.";
        public static final String INVALID_LOTTO_NUMBER_DUPLICATION = "로또 번호 각각은 서로 중복될 수 없습니다.";
        public static final String INVALID_BONUS_NUMBER_DUPLICATION = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";
        public static final String INVALID_PURCHASE_MONEY_MIN = "로또 최소 구입 금액은 " + formatter.format(LOTTO_PRICE) + "원입니다.";
        public static final String INVALID_PURCHASE_MONEY_UNIT = "로또 구입 금액은 " + formatter.format(LOTTO_PRICE) + "원 단위이어야 합니다.";
    }
}
