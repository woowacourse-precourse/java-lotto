package lotto.view.output;

import lotto.model.Lotto;
import java.util.List;

public class BuyListView {
    public static void show(List<Lotto> lotteryNumbers, int purchaseAmount) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.%n", purchaseAmount);
        for (Lotto lotto : lotteryNumbers) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            System.out.println(lottoNumbers);
        }
    }
}
