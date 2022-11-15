package lotto;

import java.util.List;
import java.util.Map;

import static lotto.Constants.*;

public class OutputView {


    public static int getLottoCount(String purchaseAmount, int unit) {
        int lottoCount = Integer.getInteger(purchaseAmount) / unit;
        System.out.println(lottoCount + OUTPUT_COUNT_MSG);
        return lottoCount;
    }

    public static void showLottoSheets(List<Lotto> userLotto) {
        for (Lotto numbers : userLotto) {
            System.out.println(numbers.toString());
        }
    }

    public static void showWinningHistory(Map<RankEnum, Integer> winningHistory){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(
            "3개 일치 (5,000원) - " +  "개\n" +
                "4개 일치 (50,000원) - " + "개\n" +
                "5개 일치 (1,500,000원) - " + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + "개\n" +
                "6개 일치 (2,000,000,000원) - " + "개\n"
        );
    }
}
