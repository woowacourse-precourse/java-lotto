package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

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
    }


    // TODO: 추가 기능 구현
    //로또 번호 가져오기
    public  List<Integer> getNumbers(){
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
