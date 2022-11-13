package lotto;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoPieces;
import lotto.domain.Lottos;
import lotto.domain.Prize;
import lotto.domain.ProfitCalculator;
import lotto.strategy.LottoGenerateStrategy;
import lotto.strategy.RandomLottoGenerateStrategy;
import lotto.view.PrintResult;
import lotto.view.UserInput;

public class Application {

    public static void main(String[] args) {
        int money = UserInput.InputMoney();
        LottoPieces lottoPieces = new LottoPieces(money);
        int pieces = lottoPieces.pieces;
        PrintResult.PrintPieces(pieces);

        LottoGenerateStrategy lottoGenerateStrategy = new RandomLottoGenerateStrategy();
        Lottos lottos = new Lottos(pieces, lottoGenerateStrategy);
        PrintResult.PrintLottos(lottos);

        Lotto winningLotto = new Lotto(UserInput.InputWinningNums());
        int bonusNum = UserInput.InputBonusNum();

        Map<Prize,Integer> prizeBoard = LottoMachine.checkPrizes(winningLotto,lottos,bonusNum);
        PrintResult.PrintPrizeStatistic(prizeBoard);
        float profit = ProfitCalculator.calculateProfitRate(prizeBoard,money);
        PrintResult.PrintProfitRate(profit);
    }
}
