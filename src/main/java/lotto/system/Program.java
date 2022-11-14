package lotto.system;

import lotto.calculation.Rank;
import lotto.calculation.Statistics;
import lotto.calculation.Winning;
import lotto.generation.Lotto;
import lotto.generation.LottoGenerator;

import javax.swing.*;
import java.util.List;

public class Program {

    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final Parser parser = new Parser();
    private final Statistics statistics = new Statistics();
    private List<Lotto> lottos;
    private Winning winning;
    private int purchaseAmount;

    public void startProgram() {
        purchaseAmount = SystemUi.getPurchaseAmount();
        lottos = lottoGenerator.generateLottos(purchaseAmount);
        SystemUi.printLotto(lottos);
    }

    public void winningProgram() {
        String winningNumber = SystemUi.getWinningNumber();
        winning = new Winning(parser.parseWinningNumbers(winningNumber));
        winning.setBonusNumber(SystemUi.getBonusNumber());
    }

    public void statisticsProgram() {
        List<List<Integer>> totalWinningCount = statistics.getTotalWinningCount(lottos, winning);
        List<Rank> rankCount = statistics.getRankCount(totalWinningCount);
        SystemUi.printResult(rankCount);
        SystemUi.printRevenue(statistics.getRevenue(rankCount), purchaseAmount);
    }
}
