package lotto;

import view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        LottoBank lottoBank = new LottoBank();
        outputView.printLotteries();
        lottoBank.LottoNumberCompareResult();
    }
}
