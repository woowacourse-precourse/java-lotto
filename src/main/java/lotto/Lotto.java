package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        DuplicatedNumber(numbers);
        checkOverRange(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void DuplicatedNumber(List<Integer> numbers){
        Set<Integer> checkNumbers = new HashSet<Integer>(numbers);
        if(checkNumbers.size() != numbers.size()) throw new IllegalArgumentException("[ERROR]");
    }

    private void checkOverRange(List<Integer> numbers){
        for(int i =0;i<6;i++){
            if(numbers.get(i) > 46 || numbers.get(i) < 1) throw new IllegalArgumentException("[ERROR]");
        }
    }

    public static List<Integer> compareWinningNumbers(){
        return numbers;
    }
    // TODO: 추가 기능 구현
}
