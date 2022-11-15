package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoSeller lottoSeller = LottoSeller.getInstance();
        LottoMachine lottoMachine = LottoMachine.getInstance();
        WinningResult winningResult = WinningResult.getInstance();

        try {
            List<Lotto> myLotteries = lottoSeller.sellLotto();
            lottoMachine.setWinning();
            winningResult.compileStatistics(myLotteries);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}