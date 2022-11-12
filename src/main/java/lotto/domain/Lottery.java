package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Lottery {
    public static final int LOTTO_PRICE = 1_000;
    private final List<Lotto> tickets;

    private Lottery(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public static Lottery buy(int purchaseAmount) {
        return new Lottery(generateLottery(purchaseAmount));
    }

    private static List<Lotto> generateLottery(int purchaseAmount) {
        List<Lotto> tickets = new ArrayList<>();
        int lotteryCount = purchaseAmount / LOTTO_PRICE;
        while (tickets.size() < lotteryCount) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    Lotto.MIN_LOTTO_NUMBER, Lotto.MAX_LOTTO_NUMBER, Lotto.LOTTO_SIZE);
            tickets.add(new Lotto(numbers));
        }
        return tickets;
    }

    public void calculateRankWithWinningNumbers(WinningNumbers winningNumbers) {
        for (Lotto lotto : tickets) {
            winningNumbers.checkLottoWinning(lotto);
        }
    }
}
