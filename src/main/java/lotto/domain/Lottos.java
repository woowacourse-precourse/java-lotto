package lotto.domain;

import lotto.utils.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;
    public static final int DIVISIBLE = 0;
    public static final int DEFAULT_COUNT = 0;
    public static final int PERCENTAGE_CONVERTER = 100;
    public static final int NO_AMOUNT = 0;
    public static final String NEW_LINE = "\n";
    public static final int ADD_COUNT = 1;

    private final List<Lotto> lottos = new ArrayList<>();

    private Lottos(int money) {
        validate(money);
        purchaseRandomLottos(money);
    }

    private void purchaseRandomLottos(int money) {
        int balance = money;
        while (balance >= LOTTO_PRICE) {
            lottos.add(Lotto.creatRandom());
            balance -= LOTTO_PRICE;
        }
    }

    public static Lottos purchaseFor(int money) {
        return new Lottos(money);
    }

    Lottos(Lotto... lottos) {
        Collections.addAll(this.lottos, lottos);
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

        return (double) winningAmount / money * PERCENTAGE_CONVERTER;
    }

    private int getWinningAmount(Lotto winningLotto, int bonusNumber) {
        int winningAmount = NO_AMOUNT;
        for (Lotto lotto : lottos) {
            Rank rank = lotto.getResult(winningLotto, bonusNumber);
            winningAmount += rank.getWinningMoney();
        }
        return winningAmount;
    }

    private int getMoney() {
        return LOTTO_PRICE * lottos.size();
    }

    public Map<Rank, Integer> getWinningCounts(Lotto winningLotto, int bonusNumber) {
        HashMap<Rank, Integer> winningCounts = getEmptyWinningCounts();
        for (Lotto lotto : lottos) {
            Rank rank = lotto.getResult(winningLotto, bonusNumber);
            Integer winningCount = winningCounts.getOrDefault(rank, DEFAULT_COUNT) + ADD_COUNT;
            winningCounts.put(rank, winningCount);
        }
        return winningCounts;
    }

    private HashMap<Rank, Integer> getEmptyWinningCounts() {
        HashMap<Rank, Integer> emptyWinningCounts = new HashMap<>();
        for (Rank rank : Rank.values()) {
            emptyWinningCounts.put(rank, DEFAULT_COUNT);
        }
        return emptyWinningCounts;
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();

        for (Lotto lotto : lottos) {
            message.append(lotto).append(NEW_LINE);
        }
        return message.toString();
    }
}
