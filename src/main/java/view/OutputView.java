package view;

import lotto.LottoMachine;
import lotto.WinningLotto;

import java.util.List;

public class OutputView {
    public void printLotteries() {
        LottoMachine lottoMachine = new LottoMachine();
        WinningLotto winningLotto = new WinningLotto();
        List<List<Integer>> totalLotteries = lottoMachine.createLotto();
        for (int i = 0; i < totalLotteries.size(); i++) {
            List<Integer> lotto = totalLotteries.get(i);
            System.out.println(lotto);
        }
        System.out.println();
        winningLotto.creteWinningNumbers();
    }
}
