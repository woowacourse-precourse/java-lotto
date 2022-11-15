package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Discriminator {

    private static final int LEAST_MATCH_COUNT = 2;
    private static final int ZERO_MATCH = 0;
    private static final int COUNT_ONE = 1;
    private static final int SECOND_RANK_CONDITION = 5;
    private List<Integer> raffleNumbers;
    private List<List<Integer>> MATCHES;
    private int bonusNumber;

    public void initialize(RaffleNumber raffleNumber) {
        this.raffleNumbers = raffleNumber.getRaffleNumbers();
        this.bonusNumber = raffleNumber.getBonusNumber();
        this.MATCHES = new ArrayList<>();
    }

    public int guessLottoNumber(Lotto lotto) {
        int numberOfMatches = ZERO_MATCH;
        for (int raffleNumber : raffleNumbers) {
            if (lotto.has(raffleNumber)) {
                numberOfMatches += COUNT_ONE;
            }
        }
        return numberOfMatches;
    }

    public boolean canSecondRank(int raffleNumberMatches) {
        return raffleNumberMatches==SECOND_RANK_CONDITION;
    }

    public int guessBonusNumber(Lotto lotto, int raffleNumberMatches) {
        int numberOfBonusNumberMatches = ZERO_MATCH;
        if (canSecondRank(raffleNumberMatches) && lotto.has(bonusNumber)) {
            numberOfBonusNumberMatches = COUNT_ONE;
        }
        return numberOfBonusNumberMatches;
    }

    public void addMatchOverThree(int raffleNumberMatches, int bonusNumberMatches) {
        if (raffleNumberMatches > LEAST_MATCH_COUNT) {
            MATCHES.add(List.of(raffleNumberMatches, bonusNumberMatches));
        }
    }

    public List<List<Integer>> getMatches() {
        return Collections.unmodifiableList(MATCHES);
    }

    public void discriminate(List<Lotto> lotteries) {
        int raffleNumberMatches;
        int bonusNumberMatches;

        for (Lotto lotto : lotteries) {

            raffleNumberMatches = guessLottoNumber(lotto);
            bonusNumberMatches = guessBonusNumber(lotto, raffleNumberMatches);

            addMatchOverThree(raffleNumberMatches, bonusNumberMatches);
        }
    }
}
