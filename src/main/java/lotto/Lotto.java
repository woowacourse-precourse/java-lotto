package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateMaxSize(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateMaxSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또는 6자리 숫자여야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers){
        Set<Integer> duplicateComparison = new HashSet<>(numbers);

        if (duplicateComparison.size() < numbers.size()){
            throw new IllegalArgumentException("[ERROR] 중복 입력은 불가능합니다.");
        }
    }

    private void validateRange(List<Integer> numbers){
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) < 1 || numbers.get(i) > 45){
                throw new IllegalArgumentException("[ERROR] 로또는 1부터 45 사이 숫자만 입력 가능합니다.");
            }
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

}
