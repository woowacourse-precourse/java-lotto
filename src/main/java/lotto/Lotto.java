package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private static final int BEGIN_RANGE = 1;
    private static final int END_RANGE = 45;
    private static final int LOTTO_COUNT = 6;
    private static final String SIZE_EXCEPTION_MESSAGE = "로또 번호는 중복없는 6개의 값이어야 합니다.";
    private static final String NUMBER_FORM_EXCEPTION_MESSAGE = "로또 번호는 1 ~ 45 사이 숫자여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateDuplicateAndSize(numbers);
        validateRange(numbers);
    }

    private void validateDuplicateAndSize(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(SIZE_EXCEPTION_MESSAGE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < BEGIN_RANGE || number > END_RANGE) {
                throw new IllegalArgumentException(NUMBER_FORM_EXCEPTION_MESSAGE);
            }
        }
    }

    public static Lotto createLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(BEGIN_RANGE, END_RANGE, LOTTO_COUNT));
        return new Lotto(numbers);
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        int index;
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (Integer number : numbers) {
            sb.append(number).append(", ");
        }

        index = sb.lastIndexOf(",");
        sb.delete(index, sb.length());
        sb.append("]");
        sb.append("\n");

        return sb.toString();
    }
}
