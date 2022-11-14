package lotto.service;

import lotto.entity.Lotto;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningDecision {

    private final List<Lotto> myLotto;
    private final Lotto winningLotto;
    private final int bonus;
    private final int purchaseAmount;
    private Map<Integer, Integer> winningPrizes;

    public WinningDecision(List<Lotto> myLotto, Lotto winningLotto, int bonus, int purchaseAmount) {
        this.myLotto = myLotto;
        this.winningLotto = winningLotto;
        this.bonus = bonus;
        this.purchaseAmount = purchaseAmount;
    }

    // for test
    public Map<Integer, Integer> getWinningPrizes() {
        return winningPrizes;
    }

    public void showWinningDecision() {
        System.out.println("당첨 통계\n---");

        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        for (WinningResult result : WinningResult.values()) {
            String winningPrize = decimalFormat.format(result.getPrize());

            System.out.printf("%s (%s원) - %d개\n", result.getMatching(), winningPrize, winningPrizes.get(result.getPrize()));
        }

        long totalWinningPrize = Calculator.sumWinningPrize(winningPrizes);
        String yield = Calculator.getYield(totalWinningPrize, purchaseAmount);
        System.out.printf("총 수익률은 %s입니다.", yield);
    }

    public void initMyPrizes() {
        winningPrizes = new HashMap<>();
        for (WinningResult result : WinningResult.values()) {
            winningPrizes.put(result.getPrize(), 0);
        }
    }

    public void setMyPrizes() {
        for (int i = 0; i < myLotto.size(); i++) {
            List<Integer> myNumbers = myLotto.get(i).getNumbers();
            int matchingCount = getMatchingCount(myNumbers);
            increasePrizeCount(matchingCount, myNumbers);
        }
    }

    private int getMatchingCount(List<Integer> myNumbers) {
        int cnt = 0;
        for (int myNumber : myNumbers) {
            if (winningLotto.getNumbers().contains(myNumber)) {
                cnt++;
            }
        }
        return cnt;
    }

    private void increasePrizeCount(int matchingCount, List<Integer> myNumbers) {
        if (matchingCount == 3) {
            winningPrizes.merge(WinningResult.MATCH_THREE.getPrize(), 1, Integer::sum);
        }
        if (matchingCount == 4) {
            winningPrizes.merge(WinningResult.MATCH_FOUR.getPrize(), 1, Integer::sum);
        }
        if (matchingCount == 5 && !hasBonus(myNumbers)) {
            winningPrizes.merge(WinningResult.MATCH_FIVE.getPrize(), 1, Integer::sum);
        }
        if (matchingCount == 5 && hasBonus(myNumbers)) {
            winningPrizes.merge(WinningResult.MATCH_BONUS.getPrize(), 1, Integer::sum);
        }
        if (matchingCount == 6) {
            winningPrizes.merge(WinningResult.MATCH_SIX.getPrize(), 1, Integer::sum);
        }
    }

    private boolean hasBonus(List<Integer> myNumbers) {
        return myNumbers.contains(bonus);
    }
}
