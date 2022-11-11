package lotto.output;

import lotto.domain.Lotto;
import java.util.Collections;
import java.util.List;

public class BuyList {

    public static void show(List<Lotto> lotteryNumbers, int purchaseAmount) {
        System.out.println(purchaseAmount + "개를 구매했습니다.");
        for (Lotto lotto : lotteryNumbers) {
            List<Integer> lottoNumbers = lotto.getLottoNumbers();
            Collections.sort(lottoNumbers);
            System.out.println(lotteryNumbers);
        }
    }
}
