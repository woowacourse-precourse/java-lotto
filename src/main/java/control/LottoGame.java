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
        try {
            int purchaseQuantity = inputView.purchaseAmount();
            lottoAnalysis.makeLottoList(purchaseQuantity);
            outputView.printAmount(purchaseQuantity);
            outputView.printLotto(lottoAnalysis.lottoList);

            lottoAnalysis.countWinning(purchaseQuantity, inputView.getWinningNumbers(), inputView.getBonusNumber());
            outputView.printTotalResult();
            outputView.printReturnRate(lottoAnalysis.getTotalReward(), purchaseQuantity);

        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }
}
