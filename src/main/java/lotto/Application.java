package lotto;

import lotto.controller.LottoGame;
import lotto.model.LottoDrawingMachine;
import lotto.model.LottoIssuingMachine;
import lotto.model.LottoWinningStatistics;
import lotto.view.LottoView;

public class Application {

    public static void main(String[] args) {
        LottoGame lottoGame = getLottoGame();
        lottoGame.play();
    }

    private static LottoGame getLottoGame() {
        LottoIssuingMachine issuingMachine = new LottoIssuingMachine();
        LottoDrawingMachine drawingMachine = new LottoDrawingMachine();
        LottoWinningStatistics winningStatistics = new LottoWinningStatistics();
        LottoView lottoView = LottoView.getInstance();
        return new LottoGame(issuingMachine, drawingMachine, winningStatistics, lottoView);
    }
}
