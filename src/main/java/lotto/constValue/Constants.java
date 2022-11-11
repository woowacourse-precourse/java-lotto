package lotto.constValue;

public final class Constants {

    public class ExceptionMessage{
        public static final String MONEY_Input_Number_ERROR_MESSAGE = "[ERROR] 구입 금액은 숫자여야 합니다.";
        public static final String MONEY_Input_THOUSAND_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000원 단위이어야 합니다.";
        public static final String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] : 로또 번호의 범위를 벗어났습니다.";
        public static final String LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE = "[ERROR] : 로또 번호에 중복 숫자가 없어야 합니다.";
    }

    public class LottoInfo{
        public static final int MIN_RANGE=1;
        public static final int MAX_RANGE=45;
        public static final int COUNT_RANGE=6;

    }
}
