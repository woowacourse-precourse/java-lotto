package lotto.standard;

import java.util.ArrayList;
import java.util.List;

public class Bug {
    public static final String ERROR = "[ERROR]";

    public static final String AMOUNT_DIVIDED_NO_REMAINING = " 금액은 1000원으로 나누어 떨어지는 금액이여야 합니다.";
    public static final String AMOUNT_MORE_THAN_THOuSAND = "금액은 1000원보다 큰 금액이어야 합니다.";
    public static final String AMOUNT_MUST_NUMBER = " 금액은 숫자여야 합니다.";

    public static final String LOTTO_MUST_RANGE_SIX = " 로또 번호는 6개의 숫자여야 합니다.";
    public static final String LOTTO_MUST_BETWEEN_ONE_AND_FORTY_FIVE = " 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String LOTTO_MUST_EACH_UNIQUE = " 로또 번호는 모두 다른 숫자여야 합니다.";
    public static final String LOTTO_NO_OTHER_INPUT = " 로또 번호는 ','로 구분한 숫자여야 합니다.";

    public static final String BONUS_MUST_BETWEEN_ONE_AND_FORTY_FIVE = " 보너스 번호는 1부터 45사이의 숫자여야 합니다.";
    public static final String BONUS_NO_CONTAIN_NUMBERS = " 보너스 번호는 로또 번호에 포함되지 않는 숫자여야 합니다.";
    public static final String BONUS_NO_OTHER_INPUT = " 보너스 번호는 1개의 숫자여야 합니다.";

    public static final int RANGE = 6;
    public static final int START_RANGE = 1;
    public static final int END_RANGE = 45;

    private static List<Integer> rangeOfNumber = new ArrayList<>();

    public static List<Integer> getRangeOfNumber() {
        setRangeOfNumber();
        return rangeOfNumber;
    }

    private static void setRangeOfNumber() {
        for (int count = START_RANGE; count <= END_RANGE; count++) {
            rangeOfNumber.add(count);
        }
    }
}