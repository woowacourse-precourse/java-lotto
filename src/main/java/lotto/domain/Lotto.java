package lotto.domain;

import static lotto.CustomException.*;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import lotto.CustomException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = deDuplicationAndSort(numbers);
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throwException("[ERROR] 로또 번호는 6개의 숫자만 허용됩니다.");
        }
    }

    private List<Integer> deDuplicationAndSort(List<Integer> numbers) throws IllegalArgumentException {
        List<Integer> list = new ArrayList<>(List.copyOf(new TreeSet<Integer>(numbers)));
        if (list.size() != 6) {
            throwException("[Error] 로또 번호는 중복이 허용되지 않습니다.");
        }
        return list;
    }

    public List<Integer> get() {
        return numbers;
    }
}
