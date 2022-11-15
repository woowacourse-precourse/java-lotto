package lotto.domain;

import java.util.HashSet;

public class LuckyNumber {

    HashSet<Integer> winningNumbers = new HashSet<>();

    int bonusNumber;

    public LuckyNumber(HashSet<Integer> winnerNumbers, int bonusNumber) {
        this.winningNumbers = winnerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public HashSet<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
