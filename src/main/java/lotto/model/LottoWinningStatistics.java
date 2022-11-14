package lotto.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static lotto.constant.LottoConstant.*;
import static lotto.model.LottoWinningStatus.*;

public class LottoWinningStatistics {

    private Map<LottoWinningStatus, Integer> winningCounts;
    private double earningsRate;

    public LottoWinningStatistics() {
        initWinningCounts();
        earningsRate = 0;
    }

    private void initWinningCounts() {
        winningCounts = new LinkedHashMap<>();
        winningCounts.put(THREE_NUMBERS_MATCH, 0);
        winningCounts.put(FOUR_NUMBERS_MATCH, 0);
        winningCounts.put(FIVE_NUMBERS_MATCH, 0);
        winningCounts.put(FIVE_NUMBERS_WITH_BONUS_NUMBER_MATCH, 0);
        winningCounts.put(SIX_NUMBERS_MATCH, 0);
    }

    public Integer getWinningCount(LottoWinningStatus winningStatus) {
        return winningCounts.get(winningStatus);
    }

    public double getEarningsRate() {
        return earningsRate;
    }

    public void generate(LottoIssuingMachine issuingMachine, LottoDrawingMachine drawingMachine) {
        List<Lotto> issuedLottos = issuingMachine.getLottos();
        Lotto winningLotto = drawingMachine.getWinningLotto();
        Integer bonusNumber = drawingMachine.getBonusNumber();
        matchLottoNumbers(issuedLottos, winningLotto, bonusNumber);
        calculateEarningsRate(issuedLottos.size() * LOTTO_PRICE);
    }

    private void matchLottoNumbers(List<Lotto> issuedLottos, Lotto winningLotto, Integer bonusNumber) {
        for (Lotto issuedLotto : issuedLottos) {
            int numberOfMatch = winningLotto.countNumberOfMatch(issuedLotto);
            boolean hasBonusNumber = issuedLotto.hasNumber(bonusNumber);
            LottoWinningStatus winningStatus = LottoWinningStatus.valueOf(numberOfMatch, hasBonusNumber);
            winningCounts.computeIfPresent(winningStatus, (ws, wcnt) -> wcnt + 1);
        }
    }

    private void calculateEarningsRate(double lottoExpense) {
        double lottoEarnings = 0;
        for (LottoWinningStatus winningStatus : winningCounts.keySet()) {
            Integer winningCount = winningCounts.get(winningStatus);
            long winningMoney = winningStatus.getWinningMoney();
            lottoEarnings += winningCount * winningMoney;
        }
        earningsRate = (lottoEarnings / lottoExpense) * 100;
    }
}
