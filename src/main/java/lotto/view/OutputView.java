package lotto.view;

import lotto.model.GenerateLotto;
import lotto.model.Lotto;
import lotto.model.Money;

import java.util.List;

public class OutputView {
    private static final String PURCHASE_OUTPUT = "개를 구매했습니다.";

    public static void lottoTicketsOut(int tickets, List<Lotto> newLotto) {
        System.out.println();
        System.out.println(tickets + PURCHASE_OUTPUT);

        for(Lotto lotto: newLotto) {
            System.out.println(lotto.getLotto());
        }
    }
}
