package lotto;

import lotto.domain.LottoGenerator;
import lotto.view.Money;

public class Application {
    public static void main(String[] args) {
        Money money = new Money();
        money.get();
        LottoGenerator generator = new LottoGenerator();
    }
}
