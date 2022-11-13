package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final LottoManager lottoManager = new LottoManager();
    private final RandomGenerator randomGenerator = new RandomGenerator();

    public List<Lotto> purchase() {
        lottoManager.printPurchaseMessage();
        Money money = new Money(Console.readLine());

        return createLotteries(money);
    }

    private List<Lotto> createLotteries(Money money) {
        int buyQuantity = money.getWon() / 1000;
        List<Lotto> lotteries = new ArrayList<>(buyQuantity);

        for (int i = 0; i < buyQuantity; i++) {
            lotteries.add(new Lotto(randomGenerator.createRandomNumbers()));
        }

        return lotteries;
    }
}
