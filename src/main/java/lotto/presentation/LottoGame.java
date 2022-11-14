package lotto.presentation;

import lotto.data.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.LottoComparator;
import lotto.domain.LottoGenerator;
import lotto.domain.RewardCalculator;

import java.util.List;
import java.util.Map;

import static lotto.data.LottoInfo.*;

public class LottoGame {
    private final LottoGenerator lottoGenerator;
    private final LottoForm lottoForm;
    private final LottoComparator lottoComparator;
    private final RewardCalculator rewardCalculator;
    private final LottoPrinter lottoPrinter;

    public LottoGame() {
        lottoForm = new LottoForm();
        lottoComparator = new LottoComparator();
        rewardCalculator = new RewardCalculator();
        lottoPrinter = new LottoPrinter();
        lottoGenerator = new LottoGenerator(
                START_NUMBER.getValue(),
                END_NUMBER.getValue(),
                NUMBER_COUNT.getValue(),
                PRICE_UNIT.getValue(),
                lottoPrinter);
    }

    public void play() throws IllegalArgumentException {
        int price = lottoForm.inputPrice();
        List<Lotto> lottos = lottoGenerator.createLottos(price);
        lottoPrinter.printLottos(lottos);

        List<Integer> winningNumbers = lottoForm.inputWinningNumbers();
        int bonus = lottoForm.inputBonus();

        Map<LottoRank, Integer> winningCounts = lottoComparator.createWinningCounts(lottos, winningNumbers, bonus);
        double profit = rewardCalculator.calculateProfit(winningCounts, price);

        lottoPrinter.printLottoResult(winningCounts, profit);
    }
}