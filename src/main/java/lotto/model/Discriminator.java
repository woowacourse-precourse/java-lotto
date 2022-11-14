package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Discriminator {
    private static final List<List<Integer>> MATCHES = new ArrayList<>();
    private static final int LEAST_MATCH_COUNT = 3;
    private static final int ZERO = 0;
    private static final int COUNT = 1;
    private static final int SECOND_RANK_CONDITION = 5;
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
    public boolean canSecondRank(int raffleNumberMatches) {
        return raffleNumberMatches == SECOND_RANK_CONDITION;
    }
    public int guessBonusNumber(Lotto lotto, int raffleNumberMatches) {
        int numberOfBonusNumberMatches = ZERO;
        if (canSecondRank(raffleNumberMatches)&&lotto.has(bonusNumber)) {
            numberOfBonusNumberMatches += COUNT;
        }
        return numberOfBonusNumberMatches;
    }

    public void addMatchOverThree(int raffleNumberMatches, int bonusNumberMatches) {
        if (raffleNumberMatches > LEAST_MATCH_COUNT) {
            MATCHES.add(List.of(raffleNumberMatches, bonusNumberMatches));
        }
    }
}
