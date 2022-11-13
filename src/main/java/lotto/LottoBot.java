package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoBot {
    private final int[] ranks = new int[Lotto.LOTTO_NUMBER_SIZE];
    private String[] winningNumbers;
    private String bonusNumber;

    public Lotto createLotto() {
        return new Lotto(createRandomNumbers());
    }

    private List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(Lotto.MIN_LOTTO_NUMBER, Lotto.MAX_LOTTO_NUMBER, Lotto.LOTTO_NUMBER_SIZE);
    }

    public int[] calculateRanks(ArrayList<Lotto> purchasedLotto) {
        for (Lotto lotto : purchasedLotto) {
            int rank = lotto.getRank(winningNumbers, bonusNumber);

            if (isInRank(rank)) {
                ranks[rank]++;
            }
        }
        
        return ranks;
    }

    private static boolean isInRank(int rank) {
        return rank >= 0;
    }


    public void saveWinningNumbers(String[] winningNumbers) {
        this.winningNumbers = winningNumbers;
    }


    public void saveBonusNumber(String bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
