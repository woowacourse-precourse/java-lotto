package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public int compare(List<Integer> basicLottoNumbers) {
        return (int) numbers.stream()
                .filter(basicLottoNumbers::contains)
                .count();
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    protected List<Integer> getNumbers(){
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> checkNumbers = new HashSet<>(numbers);
        if (checkNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않은 로또 번호 6개를 입력해 주시기 바랍니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
