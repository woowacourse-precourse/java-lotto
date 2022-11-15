package lotto.ui;

import java.util.List;
import lotto.domain.Lotto;

public class LottoShopView {

    private final List<Lotto> lottos;

    public LottoShopView(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void printLottoQuantity() {
        int lottoQuantity = lottos.size();
        System.out.println(lottoQuantity + "개를 구매했습니다.");
    }

    public void printLottos() {
        lottos.forEach(lotto -> {
            List<Integer> lottoNumbers = lotto.getNumbers();
            System.out.println(lottoNumbers);
        });
    }
}
