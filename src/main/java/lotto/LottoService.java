package lotto;

import lotto.domain.Lotto;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final RandomGenerator randomGenerator = new RandomGenerator();

    public List<Lotto> purchase(Money money) {
        int buyQuantity = money.getWon() / 1000;
        List<Lotto> lotteries = new ArrayList<>(buyQuantity);

        for (int i = 0; i < buyQuantity; i++) {
            lotteries.add(new Lotto(randomGenerator.createRandomNumbers()));
        }

        return lotteries;
    }
}
