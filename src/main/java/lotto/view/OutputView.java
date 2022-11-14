package lotto.view;

import lotto.model.GenerateLotto;
import lotto.model.Lotto;
import lotto.model.Money;

import java.util.List;

public class OutputView {
    private static final String PURCHASE_OUTPUT = "개를 구매했습니다.";

    public static void lottoTicketsOut() {
        Money money = new Money();
        System.out.println(money.getLottoTickets() + PURCHASE_OUTPUT);

        GenerateLotto generateLotto = new GenerateLotto();
        List<Lotto> newLotto = generateLotto.getLotto();

        for(Lotto lotto: newLotto) {
            System.out.println(lotto);
        }
    }
}
