package view;

import lotto.LottoMachine;
import lotto.LottoStore;

import java.util.List;

public class OutputView {
    public static void printLotteries(List<List<Integer>> totalLotteries) {
        for (int i = 0; i < totalLotteries.size(); i++) {
            List<Integer> lotto = totalLotteries.get(i);
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printLottoCount(int lottoCount) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
    }
}
