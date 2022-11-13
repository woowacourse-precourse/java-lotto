package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.view.Money;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Money money = new Money();
        LottoGenerator generator = new LottoGenerator();
        List<Lotto> lottoList = generator.generate(money.get());
    }
}
