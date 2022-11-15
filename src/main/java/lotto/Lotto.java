package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers){
        for (Integer number : numbers){
            if (number < 1 || number > 45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        int numsOfUniqueNumber = new HashSet<>(numbers).size();
        if (numbers.size() != numsOfUniqueNumber){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 중복되지 않는 숫자여야 합니다.");
        }
    }
}
