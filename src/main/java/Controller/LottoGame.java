package Controller;

import UI.Output;
import lotto.Ranking;

import java.util.List;
import java.util.Map;

public class LottoGame {
    private int purchaseAmount;
    private List<List<Integer>> randomLottos;
    private List<Integer> winningLotto;
    private int bonusNumber;

    public LottoGame() {
        try {
            InputController inputController = new InputController();
            purchaseAmount = inputController.getpurchaseAmount();
            randomLottos = inputController.getRandomLottos();
            winningLotto = inputController.getWinningLotto();
            bonusNumber = inputController.getBonusNumber();
        } catch (IllegalArgumentException e) {
            throw e;
        }

    }

    public void gameStart() {
        ServiceController lottoController = new ServiceController(purchaseAmount, randomLottos, winningLotto, bonusNumber);
        Output output = new Output();

        Map<Ranking, Integer> rankingResults = lottoController.getRankingResults();
        double profitRate = lottoController.getProfitRate();

        output.printLottoRankingResult(rankingResults);
        output.printProfitRate(profitRate);
    }
}
