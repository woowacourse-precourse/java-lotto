package lotto;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.participant.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.domain.Rank.*;

public class LottoGameConsole {

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
        double totalProfit = tallyOfRanks.getOrDefault(FIRST_SIX_MATCHED, 0) * FIRST_SIX_MATCHED.getPrize()
                + tallyOfRanks.getOrDefault(SECOND_FIVE_WITH_BONUS, 0) * SECOND_FIVE_WITH_BONUS.getPrize()
                + tallyOfRanks.getOrDefault(THIRD_FIVE_MATCHED, 0) * THIRD_FIVE_MATCHED.getPrize()
                + tallyOfRanks.getOrDefault(FOURTH_FOUR_MATCHED, 0) * FOURTH_FOUR_MATCHED.getPrize()
                + tallyOfRanks.getOrDefault(FIFTH_THREE_MATCHED, 0) * FIFTH_THREE_MATCHED.getPrize();
        double rateOfReturn = totalProfit / payment * 100;
        return Math.round(rateOfReturn * 10) / 10.0;
    }
}
