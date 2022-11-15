package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class ConsumerLottoNumberView {

    public static void show(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
