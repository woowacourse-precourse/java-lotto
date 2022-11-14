package lotto.layer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningLotto;

public class Table {

    private final List<Lotto> lotteries = new ArrayList<>();
    private final Map<WinningLotto, Integer> frequency = new HashMap<>();
    private Money money;

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public Money getMoney() {
        return money;
    }

    public Map<WinningLotto, Integer> getFrequency() {
        return this.frequency;
    }

    public void saveLottoAll(List<Lotto> lotteries) {
        this.lotteries.addAll(lotteries);
    }

    public void saveMoney(Money money) {
        this.money = money;
    }

    public void saveFrequency(Map<WinningLotto, Integer> frequency) {
        this.frequency.putAll(frequency);
    }

    public void clear() {
        this.lotteries.clear();
        this.money = null;
        this.frequency.clear();
    }
}
