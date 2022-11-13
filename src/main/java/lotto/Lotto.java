package lotto;

import java.util.List;
import lotto.system.SystemValid;
import lotto.type.ErrorType;
import lotto.type.Rank;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        SystemValid.validateForSize(numbers, ErrorType.LOTTO);
        SystemValid.validateForBetween(numbers, ErrorType.LOTTO);
        SystemValid.validateForUnique(numbers, ErrorType.LOTTO);
    }

    public Rank getRank(List<Integer> winningNumbers, int bonusNumber) {
        int correctCount = getCorrectCount(winningNumbers);
        int correctBonusCount = getCorrectBonusCount(bonusNumber);
        return Rank.getRank(correctCount, correctBonusCount);
    }

    private int getCorrectCount(List<Integer> winningNumbers) {
        int count = 0;

        for (int winningNumber : winningNumbers) {
            if (numbers.contains(winningNumber)) {
                count++;
            }
        }

        return count;
    }

    private int getCorrectBonusCount(int bonusNumber) {
        int count = 0;
        if (numbers.contains(bonusNumber)) {
            count++;
        }
        return count;
    }

    public void printNumbers() {
        String print = "";

        for (int number : numbers) {
            print = print.concat(" " + number);
        }

        print = print.trim();
        print = print.replaceAll(" ", ", ");
        System.out.println("[" + print + "]");
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
