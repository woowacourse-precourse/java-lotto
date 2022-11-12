package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int BEGIN_RANGE = 1;
    private static final int END_RANGE = 45;
    private static final int LOTTO_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static Lotto createLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(BEGIN_RANGE, END_RANGE, LOTTO_COUNT);
        Collections.sort(numbers);
        return new Lotto(numbers);
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

        return sb.toString();
    }
}
