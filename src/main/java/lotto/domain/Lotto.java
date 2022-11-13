package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.Notice;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6자리의 숫자를 입력해주세요.");
        }
        checkDuplication(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void checkDuplication(List<Integer> lotto) {
        List<Integer> check = new ArrayList<>();

        check.add(lotto.get(0));
        for (int i = 0; i < lotto.size(); i++) {
            if (i != 0 && check.contains(lotto.get(i))) {
                throw new IllegalArgumentException(Notice.ERROR.getNoticeMessage() + " 중복된 숫자가 있습니다.");
            }
            if (i != 0)
                check.add(lotto.get(i));
        }
    }

}
