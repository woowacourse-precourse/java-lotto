package lotto;

import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // TODO: 추가 기능 구현
    public List<Integer> getWinningNumbers() {
        return numbers;
    }
}
