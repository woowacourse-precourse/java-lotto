package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }
    public List<Integer> getNumbers(){
        return numbers;
    }

    // TODO: 추가 기능 구현
}
