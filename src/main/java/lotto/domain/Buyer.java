package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.constants.Constants.*;

public class Buyer {

    private final List<Lotto> lottos = new ArrayList<>();
    private final Map<Rank, Integer> result = new HashMap<>();
    private final int money;

    public Buyer(int money) {
        this.money = money;
        initResult();
    }

    public void buyLotto(int money) {
        int amount = caculateAmount(money);
        for (int count = 0; count < amount; count++) {
            lottos.add(new Lotto(generateRandomNumber()));
        }
    }

    public long caculateProfit() {
        long profit = DEFAULT_VALUE;
        for (Rank rank : result.keySet()) {
            profit += rank.calculatePrize(result.get(rank));
        }
        return profit;
    }

    public double getProfit() {
        return (caculateProfit() / (double) money) * PERCENT;
    }

    private void initResult() {
        for (Rank rank : Rank.values()) {
            result.put(rank, DEFAULT_VALUE);
        }
    }

    public int caculateAmount(int money) {
        return money / LOTTO_COST;
    }

    private List<Integer> generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public Map<Rank, Integer> getResult() {
        return this.result;
    }

    public int getMoney() {
        return this.money;
    }
}
