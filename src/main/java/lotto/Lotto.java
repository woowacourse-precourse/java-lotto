package lotto;

import java.util.Collections;
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

    public void printNumbers() {
        System.out.println(numbers);
    }

    public int compareWithWinningNumber(List<Integer> winningNumber) {
        this.numbers.sort(Comparator.naturalOrder());
        winningNumber.sort(Comparator.naturalOrder());
        int sameNumberCount = 0;

        for (int i=0; i<6; i++) {
            if (numbers.get(i) == winningNumber.get(i)) {
                sameNumberCount++;
            }
        }
        return sameNumberCount;
    }

    public boolean checkBonusNumber(int bonusNumber) {
        boolean containBonusNumber = false;
        if (numbers.contains(bonusNumber) == true) {
            containBonusNumber = true;
        }
        return containBonusNumber;
    }

    public int calculateRank(List<Integer> winningNumber, int bonusNumber) {
        int sameNumberCount = compareWithWinningNumber(winningNumber);
        boolean hasBonusNumber = checkBonusNumber(bonusNumber);

        if (sameNumberCount==6) {
            return 1;
        } else if (sameNumberCount==5 && hasBonusNumber==true) {
            return 2;
        } else if (sameNumberCount==5 && hasBonusNumber==false) {
            return 3;
        } else if (sameNumberCount==4) {
            return 4;
        } else if (sameNumberCount==3) {
            return 5;
        }
        return 6;
    }
}
