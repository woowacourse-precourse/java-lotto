package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateHaveLotto6Digits(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateHaveLotto6Digits(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> createLotto(List<Integer> numbers){
        numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        SortLottoNumbers(numbers);
        return numbers;
    }

    private void SortLottoNumbers(List<Integer> numbers){
        Collections.sort(numbers);
    }

}
