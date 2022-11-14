package lotto;

import lotto.ui.Input;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        /* 입력시 확인했지만 한번 더 확인한다. */
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        validateRange(numbers);
        validateUnique(numbers);
        validateRange(numbers);
    }
    private void validateLength(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
        }
    }
    private void validateUnique(List<Integer> numbers){
        int numOfUniqueNumber = (int)numbers.stream()
                .distinct()
                .count();
        if(numOfUniqueNumber != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 다른 숫자여야 합니다.");
        }
    }
    private void validateRange(List<Integer> numbers){
        int numOfOutOfRangeNumber = (int) numbers.stream()
                .filter(n -> n>45 || n<1)
                .count();
        if(numOfOutOfRangeNumber > 0){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
