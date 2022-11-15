package lotto.domain;

import java.util.List;

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

    public int compareWinningNumberAndUserNumber(List<Integer> userNumbers) {
        int rank = 8;

        for(int i : userNumbers) {
            if(numbers.contains(i)) {
                rank--;
            }
        }
        return rank;
    }

    public int compareUserNumberAndBonusNumber(List<Integer> userNumbers, int bonusNumber) {
        int rank = 3;
        if(userNumbers.contains(bonusNumber)) {
            rank--;
        }
        return rank;
    }

}
