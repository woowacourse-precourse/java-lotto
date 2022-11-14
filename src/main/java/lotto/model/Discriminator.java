package lotto.model;

import java.util.List;

public class Discriminator {
    private final List<Integer> raffleNumbers;
    private final int bonusNumber;

    public Discriminator(RaffleNumber raffleNumber){
        this.raffleNumbers=raffleNumber.getRaffleNumbers();
        this.bonusNumber=raffleNumber.getBonusNumber();
    }
}
