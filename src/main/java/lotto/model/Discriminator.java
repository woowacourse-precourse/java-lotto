package lotto.model;

import java.util.List;

public class Discriminator {
    private static final int ZERO = 0;
    private static final int COUNT = 1;
    private final List<Integer> raffleNumbers;
    private final int bonusNumber;

    public Discriminator(RaffleNumber raffleNumber){
        this.raffleNumbers=raffleNumber.getRaffleNumbers();
        this.bonusNumber=raffleNumber.getBonusNumber();
    }

    public int guessLottoNumber(Lotto lotto) {
        int numberOfMatches = ZERO;
        for (int raffleNumber : raffleNumbers) {
            if (lotto.has(raffleNumber)) {
                numberOfMatches += COUNT;
            }
        }
        return numberOfMatches;
    }
}
