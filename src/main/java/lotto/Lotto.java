package lotto;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicateNumberExist(numbers);
        validateNumbersInRange(numbers);
        this.numbers = numbers;
        numbers.sort(Comparator.naturalOrder());
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 갯수는 6개여야 합니다.\n");
        }
    }

    private void validateDuplicateNumberExist(List<Integer> numbers){
        Set<Integer> afterRemoveDuplicateNumbers = new HashSet<>(numbers);

        boolean isDuplicateNumberExist = (numbers.size() != afterRemoveDuplicateNumbers.size());

        if(isDuplicateNumberExist){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 중복되어서는 안됩니다.\n");
        }
    }

    private void validateNumbersInRange(List<Integer> numbers){
        for(int i = 0; i < 6; i++){
            int oneLottoNumber = numbers.get(i);
            if(!(1 <= oneLottoNumber && oneLottoNumber <= 45)){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 정수여야 합니다.\n");
            }
        }
    }

    // TODO: 추가 기능 구현
}
