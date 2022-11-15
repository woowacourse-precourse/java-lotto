package lotto.service;

import static lotto.domain.LottoMatch.NULL_RESULT;
import static lotto.domain.LottoMatch.THREE_MATCHES;
import static lotto.domain.LottoMatch.FOUR_MATCHES;
import static lotto.domain.LottoMatch.FIVE_MATCHES;
import static lotto.domain.LottoMatch.FIVE_MATCHES_PLUS_BONUS;
import static lotto.domain.LottoMatch.SIX_MATCHES;
import static lotto.ui.LottoConsole.printTotalResult;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.CalculatedLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoMatch;
import lotto.domain.UserLottoInfo;
import lotto.domain.WinningLotto;

public class LottoCalculator {
    private final UserLottoInfo userLottoInfo;
    private final WinningLotto winningLotto;
    private final BonusNumber bonusNumber;

    private List<CalculatedLotto> calculatedLottos;

    public LottoCalculator(UserLottoInfo userLottoInfo, WinningLotto winningLotto, BonusNumber bonusNumber) {
        this.userLottoInfo = userLottoInfo;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public void calculate() {
        calculatedLottos = new ArrayList<>();
        for (Lotto userLotto :
                userLottoInfo.getUserLotto()) {
            compareSingleLotto(userLotto);
        }
    }

    private void compareSingleLotto(Lotto userLotto) {
        CalculatedLotto calculatedLotto = new CalculatedLotto();

        List<Integer> winningLottoNumbers = winningLotto.getWinningLottoNumbers().getNumbers();
        for (Integer number : userLotto.getNumbers()) {
            if (winningLottoNumbers.contains(number)) {
                calculatedLotto.increaseWinningLottoCount();
            }
        }
        if (winningLottoNumbers.contains(bonusNumber.getNumber())) {
            calculatedLotto.switchToTrue();
        }

        calculatedLottos.add(calculatedLotto);
    }

    public void getTotalResult() {
        EnumMap<LottoMatch, Integer> statistics = initLottoMatchMap();
        long profit = 0;

        for (CalculatedLotto lotto : calculatedLottos) {
            profit = getProfit(statistics, profit, lotto);
        }

        printTotalResult(statistics, calculateProfitRate(profit));
    }

    private long getProfit(EnumMap<LottoMatch, Integer> statistics, long profit, CalculatedLotto lotto) {
        LottoMatch lottoMatch = LottoMatch.calculatedLottoMapper(lotto);
        if (lottoMatch != NULL_RESULT) {
            int curruentCnt = statistics.get(lottoMatch);
            statistics.put(lottoMatch, curruentCnt + 1);
            profit += lottoMatch.getProfit();
        }
        return profit;
    }

    private float calculateProfitRate(long profit) {
        return (float) profit / userLottoInfo.getLottoPrice() * 100;
    }

    private EnumMap<LottoMatch, Integer> initLottoMatchMap() {
        return new EnumMap<>(
                Map.of(
                        SIX_MATCHES, 0,
                        FIVE_MATCHES_PLUS_BONUS, 0,
                        FIVE_MATCHES, 0,
                        FOUR_MATCHES, 0,
                        THREE_MATCHES, 0)
        );
    }

}
