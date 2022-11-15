package lotto.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;


public class Lotto {
    private final List<Integer> numbers;
    static final int SMALLEST_LOTTO_NUMBER = 1;
    static final int BIGGEST_LOTTO_NUMBER = 45;
    static final int LOTTO_NUMBER_COUNT = 6;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        countValidate(numbers);
        duplicateValidate(numbers);
        duplicateValidate(numbers);
        inRangeValidate(numbers);
        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    public Lotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(SMALLEST_LOTTO_NUMBER, BIGGEST_LOTTO_NUMBER,
                LOTTO_NUMBER_COUNT);
        countValidate(numbers);
        duplicateValidate(numbers);
        duplicateValidate(numbers);
        inRangeValidate(numbers);
        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    private void countValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 당첨 번호는 6개가 입력되어야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void duplicateValidate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            System.out.println("[ERROR] 당첨 번호는 중복될 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }

    private void inRangeValidate(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < SMALLEST_LOTTO_NUMBER || number > BIGGEST_LOTTO_NUMBER) {
                System.out.println("[ERROR] 당첨 번호는 1~45의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }
}
