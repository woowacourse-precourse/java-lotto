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
    }

    // TODO: 추가 기능 구현

    //입력한 숫자가 (1, 45) 인 수인지 검증 
    protected void isNumberInRange() {
        for (Integer numbers_ : this.numbers) {
            if (numbers_ > 45) {
                throw new IllegalArgumentException("[ERROR] input bigger than 45");
            }
            if (numbers_ < 1) {
                throw new IllegalArgumentException("[ERROR] input smaller than 1");
            }
        }
    }
    
}
