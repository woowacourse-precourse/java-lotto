package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for(int i=0; i<6; i++){
            if(numbers.get(i) < 1 || numbers.get(i) > 45){
                throw new IllegalArgumentException();
            }
        }
        if(numbers.stream().distinct().count() != numbers.size()){
            throw new IllegalArgumentException();
        }

    }

    // TODO: 추가 기능 구현
}
