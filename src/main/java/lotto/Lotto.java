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

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumberExist(List<Integer> numbers){
        Set<Integer> afterRemoveDuplicateNumbers = new HashSet<>(numbers);

        boolean isDuplicateNumberExist = (numbers.size() != afterRemoveDuplicateNumbers.size());

        if(isDuplicateNumberExist){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 중복되어서는 안됩니다.\n");
        }
    }

    // TODO: 추가 기능 구현
}
