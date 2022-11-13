package lotto;

import lotto.domain.Publisher;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatistics;
import lotto.ui.UI;

public class Application {
    public static void main(String[] args) {
        UI ui = new UI();
        Publisher lottoPublisher;
        WinningLotto winningLotto;
        WinningStatistics lottoStatistics;
        
        lottoPublisher = new Publisher(ui.inputPurchasePrice());
        ui.outputPurchaseLotto(lottoPublisher.getLottos());
        winningLotto = new WinningLotto(ui.inputWinningNumbers(), ui.inputBonusNumber());
        lottoStatistics = new WinningStatistics(lottoPublisher, winningLotto);
        ui.outputWinningInfo(lottoStatistics.getNumberOfWinningLottos());
        ui.outputEarningRate(lottoStatistics.getEarningRate());
    }
}
