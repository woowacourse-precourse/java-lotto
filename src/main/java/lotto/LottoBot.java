package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoBot {
    public static final int FIRST_PRICE = 2_000_000_000;
    public static final int SECOND_PRICE = 30_000_000;
    public static final int THIRD_PRICE = 1_500_000;
    public static final int FOURTH_PRICE = 50_000;
    public static final int FIFTH_PRICE = 5_000;
    public static final int RANK_SIZE = 5;
    private final int[] ranks = new int[RANK_SIZE];
    private final int[] prices = new int[]{FIRST_PRICE, SECOND_PRICE, THIRD_PRICE, FOURTH_PRICE, FIFTH_PRICE};
    private String[] winningNumbers;
    private String bonusNumber;

    private int initialMoney;

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

    public void saveInitialMoney(int money) {
        initialMoney = money;
    }

    public void saveWinningNumbers(String[] winningNumbers) {
        this.winningNumbers = winningNumbers;
    }


    public void saveBonusNumber(String bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public double calculateYield(int[] ranks) {
        int price = getPrice(ranks);
        return (double) price / initialMoney * 100;
    }

    private int getPrice(int[] ranks) {
        int price = 0;

        for (int rank = 0; rank < ranks.length; rank++) {
            int count = ranks[rank];
            price += count * prices[rank];
        }

        return price;
    }
}
