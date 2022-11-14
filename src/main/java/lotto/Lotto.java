package lotto;

import java.util.Comparator;
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

    public int compareWithWinningNumber(List<Integer> winningNumber, int bonusNumber){
        this.numbers.sort(Comparator.naturalOrder());
        winningNumber.sort(Comparator.naturalOrder());
        int sameNumberCount = 0;

        for (int i=0; i<6; i++) {
            if (numbers.indexOf(i) == winningNumber.indexOf(i)) {
                sameNumberCount++;
            }
        }
        return sameNumberCount;
    }
}
