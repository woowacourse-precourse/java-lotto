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
        winningCounts.put(MATCH_THREE_NUMBERS, 0);
        winningCounts.put(MATCH_FOUR_NUMBERS, 0);
        winningCounts.put(MATCH_FIVE_NUMBERS, 0);
        winningCounts.put(MATCH_FIVE_NUMBERS_WITH_BONUS_NUMBER, 0);
        winningCounts.put(MATCH_SIX_NUMBERS, 0);
    }

    public double getEarningsRate() {
        return earningsRate;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (LottoWinningStatus winningStatus : winningCounts.keySet()) {
            builder.append(winningStatus)
                    .append(" - ")
                    .append(winningCounts.get(winningStatus))
                    .append("개\n");
        }
        return builder.toString();
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
