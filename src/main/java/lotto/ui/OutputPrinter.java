package lotto.ui;

import java.util.List;

public class OutputPrinter {
    OutputPrinter() {}

    public void printPurchasedNumbers(long bundleSize, List<List<Integer>> lottoBundle) {
        System.out.println(bundleSize+"개를 구매했습니다.");

        for (List<Integer> singleLotto : lottoBundle) {
            System.out.println(singleLotto);
        }
    }
}
