package lotto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateUnique(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public List<Integer> getNumbers(){
        return numbers;
    }

    public void validateUnique(List<Integer> numbers){
        List<Integer> Unique = numbers.stream().distinct().collect(Collectors.toList());
        if(Unique.size()!=6)throw new IllegalArgumentException();
    }

    // TODO: 추가 기능 구현


}
