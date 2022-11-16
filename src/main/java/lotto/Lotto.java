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

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개만 가능합니다.");
        }
        Set<Integer> number = new HashSet<>(numbers);
        if (numbers.size() != number.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 값이 있습니다.");
        }
        for(int i : numbers){
            if(i < 1 || i > 45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    // TODO: 추가 기능 구현
}
