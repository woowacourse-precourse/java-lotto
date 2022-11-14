package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningNumbers {

    private final int ONE_HUNDRED_PERCENT = 100;
    private final List<Integer> LOTTO_NUMBER;
    private final int BONUS_NUMBER;
    private Map<Rank, Integer> totalResult = new HashMap<>();


    public WinningNumbers (List<Integer> lottoNumber, int bonusNumber) {
        validate(lottoNumber, bonusNumber);
        this.LOTTO_NUMBER = lottoNumber;
        this.BONUS_NUMBER = bonusNumber;
    }

    public void makeResult(List<List<Integer>> lottoNumbers) {
        setTotalResult(); // Map 에 0 넣기

        for (List<Integer> lottoNumber : lottoNumbers) {
            Rank rank = prize(lottoNumber);
            addResult(rank);
        }
    }

    private long calculatorBenefit() {
        long result = 0L;
        for (Rank rank : totalResult.keySet()) {
            result += (long) rank.getPrize() * totalResult.get(rank);
        }
        return result;
    }

    public double calculatorRevenue(int purchaseAmount) {
        return calculatorBenefit() / (double) purchaseAmount * ONE_HUNDRED_PERCENT;
    }

    private boolean isValidUnique(List<Integer> numbers, int number) {
        return ! numbers.contains(number);
    }

    public Rank prize(List<Integer> lotto) {
        boolean bonus = lotto.contains(BONUS_NUMBER);

        lotto.retainAll(LOTTO_NUMBER);
        int match = lotto.size();

        for (Rank rank : Rank.values()) {
            if (rank.hasSameRank(match, bonus)) {
                return rank;
            }
        }
        return null;
    }

    private void setTotalResult() {
        for (Rank rank : Rank.values()) {
            totalResult.put(rank, 0);
        }
    }

    private void addResult(Rank rank) {
        if (rank == null) {
            return;
        }
        int winningCount = totalResult.get(rank);
        totalResult.put(rank, winningCount+1);
    }

    public Map<Rank, Integer> getTotalResult() {
        return this.totalResult;
    }
    private void validate(List<Integer> numbers, int number) {
        if (! isValidUnique(numbers, number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
