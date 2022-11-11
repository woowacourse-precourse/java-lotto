package lotto.view;

import java.util.List;

public class OutputView {
    public static void printPurchaseResult(List<List<Integer>> purchaseResult) {
        System.out.printf("%n%d개를 구매했습니다.%n", purchaseResult.size());
        for (List<Integer> lottoNumbers : purchaseResult) {
            System.out.println(lottoNumbers);
        }
    }

    public static void printWinningResult(List<String> winningResults) {
        System.out.println("\n당첨 통계\n---");
        for (String winningResult : winningResults) {
            System.out.println(winningResult);
        }
    }

    public static void printProfitRate(String profitRate) {
        System.out.printf("총 수익률은 %s입니다.", profitRate);
    }
}
