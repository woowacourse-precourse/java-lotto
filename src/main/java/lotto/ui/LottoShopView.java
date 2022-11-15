package lotto.ui;

import java.util.List;

public class LottoShopView {

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
