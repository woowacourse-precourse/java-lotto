package lotto.ui;

import java.util.List;
import lotto.domain.Lotto;

public class LottoShopView {

    public static void printLottoQuantity(List<Lotto> lottos) {
        int lottoQuantity = lottos.size();
        System.out.println(lottoQuantity + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> {
            List<Integer> lottoNumbers = lotto.getNumbers();
            System.out.println(lottoNumbers);
        });
    }
}
