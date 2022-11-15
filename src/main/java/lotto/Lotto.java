package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6자리 숫자를 입력해 주세요");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public Set<Integer> getSetOfLottoNumbers(){
        return new HashSet<>(numbers);
    }
}
