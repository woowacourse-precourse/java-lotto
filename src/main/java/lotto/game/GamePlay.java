package lotto.game;

import java.util.Map;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoPieces;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Prize;
import lotto.domain.ProfitCalculator;
import lotto.strategy.LottoGenerateStrategy;
import lotto.strategy.RandomLottoGenerateStrategy;
import lotto.view.PrintResult;
import lotto.view.UserInput;

public class GamePlay {

    public static void play() {
        Money money = new Money(UserInput.InputMoney());
        LottoPieces lottoPieces = generateLottoPieces(money);
        Lottos lottos = generateLottos(lottoPieces);
        Map<Prize, Integer> prizeBoard = generatePrizeBoard(lottos);
        generateProfit(money, prizeBoard);
    }

    private static void generateProfit(Money money, Map<Prize, Integer> prizeBoard) {
        float profit = ProfitCalculator.calculateProfitRate(prizeBoard, money);
        PrintResult.PrintProfitRate(profit);
    }

    private static Map<Prize, Integer> generatePrizeBoard(Lottos lottos) {
        Lotto winningLotto = new Lotto(UserInput.InputWinningNums());
        Bonus bonus = new Bonus(UserInput.InputBonusNum(), winningLotto);
        Map<Prize, Integer> prizeBoard = LottoMachine.checkPrizes(winningLotto, lottos,
            bonus);
        PrintResult.PrintPrizeStatistic(prizeBoard);
        return prizeBoard;
    }

    private static LottoPieces generateLottoPieces(Money money) {
        LottoPieces lottoPieces = new LottoPieces(money);
        PrintResult.PrintPieces(lottoPieces.pieces);
        return lottoPieces;
    }

    private static Lottos generateLottos(LottoPieces lottoPieces) {
        LottoGenerateStrategy lottoGenerateStrategy = new RandomLottoGenerateStrategy();
        Lottos lottos = new Lottos(lottoPieces.pieces, lottoGenerateStrategy);
        PrintResult.PrintLottos(lottos);
        return lottos;
    }
}
