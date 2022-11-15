package lotto.model;

import lotto.constant.LottoInfo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateAmount(numbers);
        validateOverlap(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // test: test/java/lotto/LottoTest/createLottoByOverSize()
    private void validateAmount(List<Integer> numbers) {
        if (numbers.size() != LottoInfo.TOTAL_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개이어야 합니다.");
        }
    }

    // test: test/java/lotto/LottoTest/createLottoByDuplicatedNumber()
    private void validateOverlap(List<Integer> numbers) {
        Set<Integer> test = new HashSet<>(numbers);
        if(numbers.size() != test.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야 합니다.");
        }
    }
}
