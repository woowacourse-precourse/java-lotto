package lotto.view;

import lotto.domain.Lotto;

import java.math.BigDecimal;
import java.util.List;

public class OutputView {
    public static void printLottoPurchaseInformation(List<Lotto> myLotto) {
        int lottoIssueCount = InputView.getLottoIssueCount();
        System.out.println(lottoIssueCount + "개를 구매했습니다.");

        for (int count = 0; count < lottoIssueCount; count++) {
            System.out.println(myLotto.get(count).getLottoNumbers().toString());
        }
        System.out.println();
    }
    public static void printLottoResult(List<Integer> result, double earningsRate) {
        BigDecimal rate = new BigDecimal(earningsRate);
        System.out.println("당첨통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result.get(5) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.get(3) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.get(2) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.get(1) + "개");
        System.out.println("총 수익률은 " + String.format("%.1f", rate) + "%입니다.");
    }
}
