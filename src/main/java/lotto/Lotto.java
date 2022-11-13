package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkNumbersAreDifferent(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumbersAreDifferent(List<Integer> numbers) {
        int numbersCount = numbers.size();
        HashSet<Integer> tempNumbers = new HashSet<>(numbers);
        if (numbersCount != tempNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호로 중복된 숫자가 존재 합니다.");
        }
    }

    public List<Integer> countCoincidence(List<Integer> winningNumbers, int bonusNumber) {
        int countWin = 0;
        int countBonus = 0;

        HashSet<Integer> tempWinningNumbers = new HashSet<>(winningNumbers);
        for (int number : this.numbers) {
            if (tempWinningNumbers.contains(number)) {
                countWin++;
            }
            if (number == bonusNumber) {
                countBonus = 1;
            }

        }

        return new ArrayList<Integer>(List.of(countWin, countBonus));
    }

    // TODO: 추가 기능 구현
}
