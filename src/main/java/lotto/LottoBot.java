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
    private final List<Integer> ranks = new ArrayList<>(List.of(0, 0, 0, 0, 0));
    private final List<Integer> prices = new ArrayList<>(List.of(FIRST_PRICE, SECOND_PRICE, THIRD_PRICE, FOURTH_PRICE, FIFTH_PRICE));
    private List<String> winningNumbers = new ArrayList<>();
    private String bonusNumber;

    private int initialMoney;

    public Lotto createLotto() {
        return new Lotto(createRandomNumbers());
    }

    private List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(Lotto.MIN_LOTTO_NUMBER, Lotto.MAX_LOTTO_NUMBER, Lotto.LOTTO_NUMBER_SIZE);
    }

    public List<Integer> calculateRanks(List<Lotto> purchasedLotto) {
        for (Lotto lotto : purchasedLotto) {
            int rank = lotto.getRank(winningNumbers, bonusNumber);

            if (isInRank(rank)) {
                ranks.set(rank, ranks.get(rank) + 1);
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

    public void saveWinningNumbers(List<String> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }


    public void saveBonusNumber(String bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public double calculateYield(List<Integer> ranks) {
        int price = getPrice(ranks);
        return (double) price / initialMoney * 100;
    }

    private int getPrice(List<Integer> ranks) {
        int price = 0;

        for (int rank = 0; rank < ranks.size(); rank++) {
            int count = ranks.get(rank);
            price += count * prices.get(rank);
        }

        return price;
    }

    public boolean isValidBonusNumber(String bonusNumber) {
        return !winningNumbers.contains(bonusNumber);
    }
}
