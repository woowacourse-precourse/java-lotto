package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoDrawingMachine;
import lotto.model.LottoIssuingMachine;
import lotto.model.LottoWinningStatistics;
import lotto.view.LottoView;

public class Application {

    public static void main(String[] args) {
        LottoController lottoGame = getLottoGame();
        try {
            lottoGame.play();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private static LottoController getLottoGame() {
        LottoIssuingMachine issuingMachine = new LottoIssuingMachine();
        LottoDrawingMachine drawingMachine = new LottoDrawingMachine();
        LottoWinningStatistics winningStatistics = new LottoWinningStatistics();
        LottoView lottoView = LottoView.getInstance();
        return new LottoController(issuingMachine, drawingMachine, winningStatistics, lottoView);
    }
}
