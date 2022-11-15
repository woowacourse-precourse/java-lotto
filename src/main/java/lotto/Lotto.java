package lotto;

import java.util.List;
import lotto.Exception.ErrorType;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(ErrorType.NOT_SIX_NUMBERS.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public int compareLotto(List<Integer> numbersOfWinner, int bonusNumber) {
        int generalCount = 0;
        int bonusCount = 0;

        for (int number : this.numbers) {
            if (numbersOfWinner.contains(number)) {
                generalCount++;
            }
        }

        if (generalCount >= 5) {
            if (numbersOfWinner.contains(bonusNumber)) {
                bonusCount++;
            }
        }

        return calculateRank(generalCount, bonusCount);
    }

    public static int calculateRank(int generalCount, int bonusCount) {
        if (generalCount == 3) {
            return 5;
        } else if (generalCount == 4) {
            return 4;
        } else if (generalCount == 5 && bonusCount == 0) {
            return 3;
        } else if (generalCount == 5 && bonusCount == 1) {
            return 2;
        } else if (generalCount == 6) {
            return 1;
        }
        return 0;
    }
}
