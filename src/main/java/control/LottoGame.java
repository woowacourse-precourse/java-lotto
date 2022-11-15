package control;

import view.InputView;
import view.OutputView;
import domain.LottoAnalysis;


public class LottoGame {

    private final LottoAnalysis lottoAnalysis;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoAnalysis = new LottoAnalysis();
    }

    public void playLotto() {
        int purchaseQuantity = inputView.purchaseAmount();
        lottoAnalysis.makeLottoList(purchaseQuantity);
        outputView.printAmount(purchaseQuantity);
        outputView.printLotto(lottoAnalysis.lottoList);
        lottoAnalysis.countWinning(purchaseQuantity,inputView.getWinningNumbers(),inputView.getBonusNumber());
        outputView.printTotalResult(lottoAnalysis.getTotalReward(),purchaseQuantity);

    }

}
