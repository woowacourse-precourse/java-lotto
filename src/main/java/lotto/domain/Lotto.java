package lotto.domain;

import static lotto.CustomException.throwException;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateNumbers(numbers);
        this.numbers = deDuplicationAndSort(numbers);
    }

    private void validateSize(List<Integer> numbers) throws IllegalArgumentException {
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

    private void validateNumbers(List<Integer> numbers) throws IllegalArgumentException {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throwException("[ERROR] 로또 번호는 1~45 사이의 숫자입니다.");
            }
        }
    }

    public List<Integer> get() {
        return numbers;
    }
}
