package lotto;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || isDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicate(List<Integer> numbers){
        for (int i = 0; i < numbers.size(); i++){
            if (haveNumberInRange(numbers, numbers.get(i), i + 1, numbers.size())){
                return true;
            }
        }
        return false;
    }

    private boolean haveNumberInRange(List<Integer> numbers, int number, int start, int end){
        for (int i = start; i < end; i++){
            if (numbers.get(i) == number){
                return true;
            }
        }
        return false;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
    // TODO: 추가 기능 구현
}
