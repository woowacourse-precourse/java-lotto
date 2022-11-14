package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoLength(numbers);
        validateDuplicateLotto(numbers);
        validateLottoRange(numbers);
        this.numbers = numbers;
    }

    private void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자는 6개를 입력하셔야 합니다.");
        }
    }

    private void validateDuplicateLotto(List<Integer> numbers){
        Set<Integer> copyNumbers = new HashSet<>(numbers);
        if(copyNumbers.size()!=numbers.size()){
            throw new IllegalArgumentException("[ERROR] 숫자는 중복되지 않아야 합니다.");
        }
    }

    private void validateLottoRange(List<Integer> numbers){
        if(Collections.max(numbers)>45 || Collections.min(numbers)<1)
            throw new IllegalArgumentException("[ERROR] 숫자는 1부터 45 중에서 입력하셔야 합니다.");

    }
    public List<Integer> getLotto(){
        return numbers;
    }
}
