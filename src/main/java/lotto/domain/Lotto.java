package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.view.Input;

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
    public static List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        String inputNumbers = Input.input();
        String[] lucky = inputNumbers.split(",");
        for (String s : lucky) {
            winningNumbers.add(Integer.parseInt(s));
        }
        new Lotto(winningNumbers);
        return winningNumbers;
    }
}
