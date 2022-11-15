package lotto.model.lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_NUMBER_LENGTH = 6;
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        this.numbers = new ArrayList<>(numbers);
    }

    public Lotto(Lotto oth) {
        this.numbers = new ArrayList<>(oth.numbers);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        if(doesNotHaveRightLength(numbers)) {
            throw new IllegalArgumentException("로또 번호는 " + Lotto.LOTTO_NUMBER_LENGTH + "개여야 합니다.");
        }
        if(hasNumberOutOfRange(numbers)) {
            throw new IllegalArgumentException("로또 번호는 " + Lotto.MINIMUM_NUMBER + "부터 " + Lotto.MAXIMUM_NUMBER + " 사이의 숫자여야 합니다.");
        }
        if(haveDuplicate(numbers)) {
            throw new IllegalArgumentException("로또 번호가 중복되어서는 안 됩니다.");
        }
    }

    private boolean doesNotHaveRightLength(List<Integer> numbers) {
        return numbers.size() != Lotto.LOTTO_NUMBER_LENGTH;
    }

    private boolean isOutOfRange(int number) {
        return number < Lotto.MINIMUM_NUMBER || number > Lotto.MAXIMUM_NUMBER;
    }

    private boolean hasNumberOutOfRange(List<Integer> numbers) {
        for(int number : numbers) {
            if(isOutOfRange(number)) {
                return true;
            }
        }
        return false;
    }

    private boolean haveDuplicate(List<Integer> numbers) {
        Set<Integer> tmpSet = new HashSet<>();

        for (int number : numbers) {
            if (!tmpSet.add(number)) {
                return true;
            }
        }
        return false;
    }
}
