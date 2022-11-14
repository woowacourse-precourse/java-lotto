package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class ResultPrint {
    public void numberOfPurchase(int numberOfPurchase) {
        System.out.println(numberOfPurchase + "개를 구매했습니다.");
    }

    public void generateLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLotto());
        }
        System.out.println();
    }
}
