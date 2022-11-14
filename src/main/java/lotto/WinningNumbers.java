package lotto;

import java.util.List;

public class WinningNumbers {
    // 멤버변수로 보너스번호도 갖게 한다면?
    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
