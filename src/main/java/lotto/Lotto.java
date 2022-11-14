package lotto;

import java.util.List;

import static lotto.view.Input.input;

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

    public static int lottoNum(){
        int amount = input();
        if(amount % 1000 != 0){
            throw new IllegalArgumentException();
        }
        int num = amount / 1000;
        return num;
    }

    // TODO: 추가 기능 구현
}
