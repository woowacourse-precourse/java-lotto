package lotto.domain;

import static lotto.domain.Rank.checkRank;

import java.util.List;

public class Customer {

    private List<Lotto> lottos;

    private int[] winnings = new int[6];

    private int money = 0;

    public void buyLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> showLottos() {
        return lottos;
    }

    public void checkJackpot(List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            int count = lotto.checkRank(winningNumbers, bonusNumber);
            Rank rank = checkRank(count);
            money += rank.getMoney();
            winnings[rank.getRank() - 1]++;
        }
    }

    public double calculateRate(int amount) {
        return ((double) (money * 100)) / (double) amount;
    }

    public int[] getWinningList() {
        return winnings;
    }
}
