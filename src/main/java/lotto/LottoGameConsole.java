package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.Rank.*;

public class LottoGameConsole {

    private final Map<Rank, Integer> prize = Map.of(
            FIRST_SIX_MATCHED, 2_000_000_000,
            SECOND_FIVE_WITH_BONUS, 30_000_000,
            THIRD_FIVE_MATCHED, 1_500_000,
            FOURTH_FOUR_MATCHED, 50_000,
            FIFTH_THREE_MATCHED, 5_000);

    private final Emcee emcee = new Emcee();
    private final Player player = new Player();
    private final LottoPublisher publisher = new LottoPublisher();
    private final LottoMatcher matcher = new LottoMatcher();
    private final Validator validator = new Validator();

    public void startLottoGame() {
        emcee.guideGame();
        int payment = handlePayment();
        List<Lotto> publishedLottos = publishLottos(payment);
        WinningLotto winningLotto = createWinningLotto();
        Map<Rank, Integer> tallyOfRanks = matcher.matchAllLottos(publishedLottos, winningLotto);
        handlePrizeOfLottoGame(tallyOfRanks, payment);
    }

    private int handlePayment() {
        emcee.guideAmountOfPurchaseMoney();
        String paymentOfPurchase = player.paymentOfPurchase();
        validator.validatePayment(paymentOfPurchase);
        return Integer.parseInt(paymentOfPurchase);
    }

    private List<Lotto> publishLottos(int payment) {
        List<Lotto> lottos = publisher.publishLottos(payment);
        emcee.showPublishedLottos(lottos);
        return lottos;
    }

    private WinningLotto createWinningLotto() {
        List<Integer> winningNumbers = createWinningNumbers();
        int bonusNumber = createBonusNumber(winningNumbers);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private List<Integer> createWinningNumbers() {
        emcee.guideWinningNumber();
        String winningNumbers = player.selectWinningNumbers();
        validator.validateWinningNumbers(winningNumbers);
        return Arrays.stream(winningNumbers.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    private int createBonusNumber(List<Integer> winningNumbers) {
        emcee.guideBonusNumber();
        String bonusNumber = player.selectBonusNumber();
        validator.validateBonusNumber(bonusNumber, winningNumbers);
        return Integer.parseInt(bonusNumber);
    }

    private void handlePrizeOfLottoGame(Map<Rank, Integer> tallyOfRanks, int payment) {
        emcee.showStatistics(tallyOfRanks);
        double rateOfReturn = calculateRateOfReturn(tallyOfRanks, payment);
        emcee.showRateOfReturn(rateOfReturn);
    }

    private double calculateRateOfReturn(Map<Rank, Integer> tallyOfRanks, int payment) {
        double totalProfit = tallyOfRanks.get(FIRST_SIX_MATCHED) * prize.get(FIRST_SIX_MATCHED)
                + tallyOfRanks.get(SECOND_FIVE_WITH_BONUS) * prize.get(SECOND_FIVE_WITH_BONUS)
                + tallyOfRanks.get(THIRD_FIVE_MATCHED) * prize.get(THIRD_FIVE_MATCHED)
                + tallyOfRanks.get(FOURTH_FOUR_MATCHED) * prize.get(FOURTH_FOUR_MATCHED)
                + tallyOfRanks.get(FIFTH_THREE_MATCHED) * prize.get(FIFTH_THREE_MATCHED);
        totalProfit /= payment * 100;
        return Math.round(totalProfit * 10) / 10.0;
    }
}
