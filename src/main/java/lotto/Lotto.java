package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private int lotto_cnt;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    public void lotto_publish(String money){
        this.lotto_cnt = (Integer.parseInt(money))/1000;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
