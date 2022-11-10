package lotto.view;

import java.util.List;

public class OutputView {
    public static void printPurchaseResult(List<List<Integer>> purchaseResult) {
        System.out.printf("%n%d개를 구입하였습니다.%n", purchaseResult.size());
        for (List<Integer> lottoNumbers: purchaseResult) {
            System.out.println(lottoNumbers);
        }
    }
}
