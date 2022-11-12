package lotto.standard;

import java.util.ArrayList;
import java.util.List;

public enum Bug {
    ERROR("[ERROR]"),
    AMOUNT_DIVIDED_NO_REMAINING(" 금액은 1000원으로 나누어 떨어지는 수여야 합니다."),
    AMOUNT_MUST_NUMBER(" 금액은 숫자여야 합니다."),

    LOTTO_MUST_RANGE_SIX(" 로또 번호는 6개의 숫자여야 합니다."),
    LOTTO_MUST_BETWEEN_ONE_AND_FORTY_FIVE(" 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_MUST_EACH_UNIQUE(" 로또 번호는 모두 다른 숫자여야 합니다."),

    LOTTO_NO_OTHER_INPUT(" 로또 번호는 ','로 구분한 숫자여야 합니다."),

    NUMBER_MUST_RANGE_ONE(" 보너스 번호는 1개의 숫자여야 합니다."),
    BONUS_MUST_BETWEEN_ONE_AND_FORTY_FIVE(" 보너스 번호는 1부터 45사이의 숫자여야 합니다."),
    BONUS_NO_CONTAIN_NUMBERS(" 보너스 번호는 로또 번호에 포함되지 않는 숫자여야 합니다."),
    BONUS_NO_OTHER_INPUT(" 보너스 번호는 숫자여야 합니다.");


    private final String message;

    private final int START_RANGE = 1;
    private final int END_RANGE = 45;
    private List<Integer> rangeOfNumber = new ArrayList<>();

    private Bug(String message) {
        this.message = message;

    }


    public String getMessage() {
        return this.message;
    }


    public List<Integer> getRangeOfNumber() {
        setRangeOfNumber();
        return rangeOfNumber;
    }

    private void setRangeOfNumber() {
        for (int count = START_RANGE; count <= END_RANGE; count++) {
            rangeOfNumber.add(count);
        }
    }
}
