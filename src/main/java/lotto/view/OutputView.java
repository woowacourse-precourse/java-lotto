package lotto.view;

import java.util.List;
import lotto.domain.lotto.Lotto;

public class OutputView {

    public static void printBuyingCount(List<Lotto> lotteries) {
        System.out.printf("%s개를 구매했습니다.%n", lotteries.size());
        
        for (Lotto lotto : lotteries) {
            System.out.println(lotto);
        }
    }
}
