package lotto;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Number;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final RandomGenerator randomGenerator = new RandomGenerator();
    private final List<Lotto> lotteries = new ArrayList<>();
    private Lotto winningNumber;
    private Number bonusNumber;

    public void purchase(Money money) {
        int buyQuantity = money.getWon() / 1000;

        for (int i = 0; i < buyQuantity; i++) {
            lotteries.add(new Lotto(randomGenerator.createRandomNumbers()));
        }
    }

    public List<Lotto> getPurchaseLotteries() {
        return lotteries;
    }

    public void setWinningNumber(String inputWinningNumber) {
        winningNumber = Lotto.from(inputWinningNumber);
    }

    public void setBonusNumber(String inputBonusNumber) {
        bonusNumber = new Number(inputBonusNumber);
    }
}
