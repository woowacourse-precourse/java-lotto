package lotto.domain.generator;

import lotto.domain.Rank;
import lotto.domain.Lotto;
import lotto.domain.LottoGameResult;
import lotto.domain.WinningNumbers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.LottoConstants.MIN_WINNING_COUNT;
import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.THIRD;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.FIRST;


public class LottoGameResultGenerator {
    private final Map<Integer, Integer> winningDetails;
    private double earningRate;

    public LottoGameResultGenerator() {
        winningDetails = new HashMap<>();
        initializeWinningDetails();
    }

    private void initializeWinningDetails() {
        for (Rank rank : Rank.values()) {
            winningDetails.put(rank.prizeMoney(), 0);
        }
    }

    public LottoGameResult generateLottoGameResult(List<Lotto> lottos,
                                                   WinningNumbers winningNumbers,
                                                   int paidMoney) {
        calculateWinningDetails(lottos, winningNumbers);
        calculateEarningRate(paidMoney);
        return new LottoGameResult(winningDetails, earningRate);
    }

    private void calculateWinningDetails(List<Lotto> lottos, WinningNumbers winningNumbers) {
        for (Lotto lotto : lottos) {
            int winningCount = calculateWinningCount(lotto, winningNumbers);
            updateWinningDetails(lotto, winningNumbers, winningCount);
        }
    }

    private int calculateWinningCount(Lotto lotto, WinningNumbers winningNumbers) {
        int winningCount = 0;
        for (int number : winningNumbers.getNumbers()) {
            if (lotto.contains(number)) {
                winningCount += 1;
            }
        }
        return winningCount;
    }

    private void updateWinningDetails(Lotto lotto, WinningNumbers winningNumbers, int winningCount) {
        if (winningCount < MIN_WINNING_COUNT.getValue()) {
            return;
        }

        int prizeMoney = getPrizeMoneyByWinningCount(lotto, winningNumbers, winningCount);
        int oldValue = winningDetails.get(prizeMoney);
        int newValue = oldValue + 1;
        winningDetails.put(prizeMoney, newValue);
    }

    private int getPrizeMoneyByWinningCount(Lotto lotto, WinningNumbers winningNumbers, int winningCount) {
        int bonusNumber = winningNumbers.getBonusNumber();
        if (winningCount == FIRST.winningCount()) {
            return FIRST.prizeMoney();
        }
        if (winningCount == FOURTH.winningCount()) {
            return FOURTH.prizeMoney();
        }
        if (winningCount == FIFTH.winningCount()) {
            return FIFTH.prizeMoney();
        }
        if (lotto.contains(bonusNumber)) {
            return SECOND.prizeMoney();
        }
        return THIRD.prizeMoney();
    }

    private void calculateEarningRate(int paidMoney) {
        int profits = calculateProfits();
        earningRate = (profits / (double)paidMoney) * 100;
    }

    private int calculateProfits() {
        int profits = 0;
        for (int prizeMoney : winningDetails.keySet()) {
            profits += prizeMoney * winningDetails.get(prizeMoney);
        }
        return profits;
    }
}
