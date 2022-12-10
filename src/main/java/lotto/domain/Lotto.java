package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개 숫자만 입력해주세요.");
        }

        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복 숫자를 제거해주세요.");
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public int findMatchNumber(WinningNumber winningNumber) {
        return (int) winningNumber.getWinningNumberList().stream()
                .filter(wn -> getNumbers().contains(wn))
                .count();
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return this.getNumbers().contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
