package util;

import java.util.HashSet;
import java.util.List;

public class Validator {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final String NUMBER_LENGTH_ERROR = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String NUMBER_RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String NUMBER_DUPLICATE_ERROR = "[ERROR] 로또 번호는 서로 중복되지 않아야 합니다.";
    private static final String BONUS_DUPLICATE_ERROR = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";



    public void validateLength(List<Integer> numbers, int length) {
        if (numbers.size() != length) {
            throw new IllegalArgumentException(NUMBER_LENGTH_ERROR);
        }

    }

    public void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUM || number > MAX_NUM) {
                throw new IllegalArgumentException(NUMBER_RANGE_ERROR);
            }

        }
    }

    public void validateDuplicate(List<Integer> numbers) {
        if (ListToHash(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(NUMBER_DUPLICATE_ERROR);
        }
    }

    public void validateBonusNumber(List<Integer> numbers, String bonusNumber) {
        if (numbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(BONUS_DUPLICATE_ERROR);
        }
    }

    public HashSet<Integer> ListToHash(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>();
        for (int number : numbers) {
            set.add(number);
        }
        return set;
    }
}
