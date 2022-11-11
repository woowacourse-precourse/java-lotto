package lotto.domain;

import lotto.utils.ErrorMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;
    public static final int DIVISIBLE = 0;
    public static final int DEFAULT_COUNT = 0;

    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int money) {
        validate(money);
        int issuedCount = money / LOTTO_PRICE;
        for (int i = 0; i < issuedCount; i++) {
            lottos.add(Lotto.creatRandom());
        }
    }

    Lottos(Lotto... lottos) {
        for (Lotto lotto : lottos) {
            this.lottos.add(lotto);
        }
    }

    private void validate(int money) {
        if (isMoneyIndivisibleByPrice(money)) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_LEFT_OVER);
        }
    }

    private static boolean isMoneyIndivisibleByPrice(int money) {
        return money % LOTTO_PRICE != DIVISIBLE;
    }

    public int countTotal() {
        return lottos.size();
    }

    public double calculateProfit(Lotto winningLotto, int bonusNumber) {
        int winningAmount = getWinningAmount(winningLotto, bonusNumber);
        int money = getMoney();

        return (double) winningAmount / money;
    }

    public Map<WinningPrize, Integer> countWinningPrize(Lotto winningLotto, int bonusNumber) {
        HashMap<WinningPrize, Integer> winningPrizeCounts = getDefaultWinningPrizeCounts();
        for (Lotto lotto : lottos) {
            WinningPrize winningPrize = lotto.getWinningPrize(winningLotto, bonusNumber);
            Integer winningPrizeCount = winningPrizeCounts.getOrDefault(winningPrize, 0) + 1;
            winningPrizeCounts.put(winningPrize, winningPrizeCount);
        }
        return winningPrizeCounts;
    }

    private HashMap<WinningPrize, Integer> getDefaultWinningPrizeCounts() {
        HashMap<WinningPrize, Integer> winningPrizeCounts = new HashMap<>();
        for (WinningPrize winningPrize : WinningPrize.values()) {
            winningPrizeCounts.put(winningPrize, DEFAULT_COUNT);
        }
        return winningPrizeCounts;
    }

    private int getMoney() {
        return LOTTO_PRICE * lottos.size();
    }

    private int getWinningAmount(Lotto winningLotto, int bonusNumber) {
        int winningAmount = 0;
        for (Lotto lotto : lottos) {
            WinningPrize winningPrize = lotto.getWinningPrize(winningLotto, bonusNumber);
            winningAmount += winningPrize.getAmount();
        }
        return winningAmount;
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();

        for (Lotto lotto : lottos) {
            message.append(lotto).append("\n");
        }
        return message.toString();
    }
}
