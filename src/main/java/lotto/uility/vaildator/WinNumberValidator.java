package lotto.uility.vaildator;

import java.util.List;

public class WinNumberValidator {

    private static final String DUPLICATE_NUMBER_VALIDATION = "[ERROR] 중복된 숫자는 입력하실 수 없습니다.";
    private static final String NUMBER_RANGE_VALIDATION = "[ERROR] 숫자의 입력범위를 확인해 주세요";
    private static final String SIZE_VALIDATION = "[ERROR] 숫자는 6개를 입력해 주세요";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    public void validateNumbers(List<Integer> winNumbers) {
        if (duplicateNumber(winNumbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_VALIDATION);
        } else if (rangOutNumber(winNumbers)) {
            throw new IllegalArgumentException(NUMBER_RANGE_VALIDATION);
        } else if(sizeNumber(winNumbers)) {
            throw new IllegalArgumentException(SIZE_VALIDATION);
        }
    }

    private boolean sizeNumber(List<Integer> winNumbers) {
        if(winNumbers.size() != LOTTO_SIZE) return true;
        return false;
    }

    private boolean rangOutNumber(List<Integer> winNumbers) {
        for (int number : winNumbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                return true;
            }
        }
        return false;
    }

    private boolean duplicateNumber(List<Integer> winNumbers) {
        if (winNumbers.size() != winNumbers.stream().distinct().count()) {
            return true;
        }
        return false;
    }

}
