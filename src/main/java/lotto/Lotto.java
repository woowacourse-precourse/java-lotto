package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;

        for (int i = 0; i < 5; i++){
            for (int j = i + 1; j < 6; j++){
                if (Objects.equals(numbers.get(i), numbers.get(j))) throw new IllegalArgumentException();
            }
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public int getIthNumber(int i){
        return numbers.get(i);
    }

}
