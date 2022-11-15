package lotto;

import lotto.domain.Game;
import lotto.domain.GameResult;
import lotto.ui.Input;
import lotto.ui.Output;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static Game game = new Game();

    public static void main(String[] args) {
        Output.inputPurchaseAmountMessage();

        int purChaseAmount = Input.getPurchaseAmount();
        int count = game.getLottoCount(purChaseAmount);
        Output.lottoCount(count);

        List<List<Integer>> randomLottos = game.getSortLottos(game.createLottoWithCount(count));
        Output.sortedLotto(randomLottos);

        Output.inputWinningNumberMessage();
        List<Integer> winningLotto = Input.getWiningNumber();

        Output.inputBonusNumberMessage();
        Integer bonusNumber = Input.getBonusNumber();

        Output.winningStatisticsMessage();

        List<Integer> ranks = new ArrayList<>();

        for (List<Integer> randomLotto : randomLottos) {
            ranks.add(GameResult.getGameRank(randomLotto, winningLotto, bonusNumber));
        }

        List<Integer> counts = GameResult.getGameRankCount(ranks);
        Output.winningStatistics(counts);
        
        Output.rateOfReturn(GameResult.calculateRateOfReturn(purChaseAmount, GameResult.calculateSum(counts)));
    }
}
