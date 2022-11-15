package lotto.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

public class Lotto {
    public static final int lottoMinNumber = 1;
    public static final int lottoMaxNumber = 45;
    public static final int lottoLength = 6;
    public static final int lottoPrice = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sortList = new ArrayList<>(numbers);
        Collections.sort(sortList);
        this.numbers = sortList;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != lottoLength) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리 숫자입니다.");
        }
        if (dupCheck(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복 된 숫자가 있습니다.");
        }
        if (rangeCheck(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 1이상 45이하여야 입니다.");
        }
    }

    private boolean dupCheck(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);

        return numbers.size() != numSet.size();
    }

    private boolean rangeCheck(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < lottoMinNumber || number > lottoMaxNumber)
                return true;
        }
        return false;
    }
}
