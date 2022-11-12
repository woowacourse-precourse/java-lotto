package view;

import lotto.LottoMachine;

import java.util.List;

public class OutputView {

    public void printLotteries() {
        LottoMachine lottoMachine = new LottoMachine();
        List<List<Integer>> totalLotteries = lottoMachine.createLotto();
        printLottoCount();
        for (int i = 0; i < totalLotteries.size(); i++) {
            List<Integer> lotto = totalLotteries.get(i);
            System.out.println(lotto);
        }
    }

    public void printLottoCount() {
        LottoMachine lottoMachine = new LottoMachine();
        int lottoCount = lottoMachine.CalculateLottoCount();
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
    }
}
