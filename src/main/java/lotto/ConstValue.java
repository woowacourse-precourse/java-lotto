package lotto;

public class ConstValue {
    public class Numbers{
        public static final int MIN_LOTTO_NUM = 1;
        public static final int MAX_LOTTO_NUM = 45;

        public static final int LOTTO_LENGTH = 6;
        public static final int PRICE_PER_LOTTO = 1000;
    }

    public class ErrorMessages {
        public static final String INDIVISIBLE_BY1000_MESSAGE = "[ERROR] 1000단위의 숫자를 입력해주세요.";
        public static final String NOT_NUMBER_MESSAGE = "[ERROR] '숫자' 를 입력해주세요.";
        public static final String ILLEGAL_ARGUMENT_EXCEPTION_FOR_WINNING_NUMBER = "[ERROR] 쉼표로 구분되는 6자리의 정수(1~45 범위)를 입력해주세요";
        public static final String ILLEGAL_ARGUMENT_EXCEPTION_FOR_BONUS_NUMBER = "[ERROR] 1에서 45사이의 정수를 입력해주세요.";
        public static final String DUPLICATED_LOTTO_NUMBERS = "[ERROR] 로또번호가 중복됩니다.";
        public static final String BONUS_DUPLICATED_WITH_WINNING_NUMBER = "[ERROR] 보너스 번호와 당첨 번호는 중복되서는 안됩니다.";
    }
}


