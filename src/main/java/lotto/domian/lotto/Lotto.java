package lotto.domian.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        numbers = sortNumbers(numbers);
        this.numbers = numbers;
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> tempNumbers = new ArrayList<>(numbers);
        Collections.sort(tempNumbers);
        return tempNumbers;
    }

    private void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 생성된 번호가 6개가 아닙니다.");
        }

        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 생성된 번호들 사이에 중복이 존재합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
