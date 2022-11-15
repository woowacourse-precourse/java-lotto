package lotto.Model;

import lotto.Application;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;

public class Result {

    private final static List<Prize> prizes = List.of(Prize.FIRST, Prize.THIRD, Prize.FOURTH, Prize.FIFTH);
    private HashMap<Prize, Integer> result = new HashMap<>();
    private double profitRate = 0D;

    /**
     * 당첨 결과 상수를 정의하고 있는 enum
     */
    public static enum Prize {
        FIRST(2_000_000_000),
        SECOND(30_000_000),
        THIRD(1_500_000),
        FOURTH(50_000),
        FIFTH(5_000),
        NONE(0);
        private final int prizeMoney;

        Prize(int prizeMoney) {
            this.prizeMoney = prizeMoney;
        }

        public int getValue() {
            return prizeMoney;
        }
    }

    public Result() {
        result.put(Prize.FIRST, 0);
        result.put(Prize.SECOND, 0);
        result.put(Prize.THIRD, 0);
        result.put(Prize.FOURTH, 0);
        result.put(Prize.FIFTH, 0);
        result.put(Prize.NONE, 0);
    }

    /**
     * 로또 번호들과 당첨 번호를 비교하여 당첨 결과를 반환
     *
     * @param lottos     랜덤으로 선택한 로또들
     * @param luckyLotto 당첨 로또
     * @return
     */
    public void computeLottoResult(List<Lotto> lottos, LuckyLotto luckyLotto) {
        for (Lotto lotto : lottos) {
            int duplicated = getDuplicated(lotto.getLottoNumbers(), luckyLotto.getLottoNumbers());
            boolean hasBonusNumber = checkBonusNumber(lotto.getLottoNumbers(), luckyLotto.getBonusNumber());
            Prize prize = ranking(duplicated, hasBonusNumber);
            result.put(prize, result.get(prize).intValue() + 1);
        }
    }

    private int getDuplicated(List<Integer> target, List<Integer> luckyNumber) {
        int duplicated = 0;
        for (Integer number : luckyNumber) {
            if (target.contains(number)) {
                duplicated++;
            }
        }
        return duplicated;
    }

    private boolean checkBonusNumber(List<Integer> target, int bonusNumber) {
        if (target.contains(bonusNumber))
            return true;
        return false;
    }

    private Prize ranking(int duplicated, boolean hasBonusNumber) {
        if (duplicated < 3) {
            return Prize.NONE;
        }
        if (duplicated == 5 && hasBonusNumber) {
            return Prize.SECOND;
        }
        Prize prize = prizes.get(6 - duplicated);
        return prizes.get(6 - duplicated);
    }

    /**
     * 로또 구매 금액과 당첨 금액을 바탕으로 수익률을 계산
     *
     * @return 수익률
     */
    public void computeProfitRate(int purchased) {
        int profit = computeProfit();
        profitRate = (double) profit / purchased * 100D;
    }

    private int computeProfit() {
        int profit = 0;
        for (Prize prize : result.keySet()) {
            profit += result.get(prize).intValue() * prize.getValue();
        }
        return profit;
    }

    public HashMap<Prize, Integer> getResult() {
        return result;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
