package view;

import java.util.List;
import lotto.domain.Lotto;

public class LottoView {

    private final List<Lotto> lottos;

    public LottoView(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void show() {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.showNumbers());
        }
        System.out.println();
    }
}
