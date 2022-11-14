package lotto.domain;

import java.util.List;

import lotto.utils.Notice;

public class Lotto {
    private final int LOTTO_MIN = 1;
    private final int LOTTO_MAX = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6자리의 숫자를 입력해주세요.");
        }
        checkNumber(numbers);
        checkDuplication(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void checkDuplication(List<Integer> lotto) {
        if (isDuplicate(lotto)) {
            throw new IllegalArgumentException(Notice.ERROR.getNoticeMessage() + Notice.ERROR_DUPLICATION.getNoticeMessage());
        }
    }

    private boolean isDuplicate(List<Integer> lotto) {
        return lotto.size() != lotto.stream()
                .distinct()
                .count();
    }

    private void checkNumber(List<Integer> numbers) {
        for (Integer integer : numbers) {
            checkNumberRange(integer);
        }
    }

    public void checkNumberRange(int number) {
        if (number< LOTTO_MIN || number > LOTTO_MAX) {
            throw new IllegalArgumentException(Notice.ERROR.getNoticeMessage() + Notice.ERROR_RANGE);
        }
    }

}
