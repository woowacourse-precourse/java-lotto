package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numbers){
        Set<Integer> copyNumbers = new HashSet<>(numbers);
        if(copyNumbers.size()!=numbers.size()){
            throw new IllegalArgumentException("[ERROR] 숫자는 중복되지 않아야합니다.");
        }
    }

    public List<Integer> getLotto(){
        return numbers;
    }
}
