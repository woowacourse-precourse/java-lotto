package lotto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호가 6자리가 아닙니다.");
        }
        this.isDuplicateNumberExist(numbers);
        this.isInRange(numbers, LottoUtil.LottoNumberPromise.MIN_LOTTO_NUM.getValue(),
                LottoUtil.LottoNumberPromise.MAX_LOTTO_NUM.getValue());
    }

    private void isDuplicateNumberExist(List<Integer> input) {
        Set<Integer> set = new HashSet<>(input);
        if (input.size() != set.size())
            throw new IllegalArgumentException("중복된 숫자가 존재합니다");
    }

    private void isInRange(List<Integer> numbers, int min, int max) {
        for (int number : numbers) {
            if (!isBetween(min, max, number)) {
                throw new IllegalArgumentException(String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", min, max));
            }
        }
    }

    private boolean isBetween(int min, int max, int target) {
        if (min <= target && target <= max)
            return true;
        else
            return false;
    }

    public Map<MatchInfo, Integer> calculateLottoStatistics(List<List<Integer>> userLottoList, int bonusNumber) {
        Map<MatchInfo, Integer> calculateResult = this.initializeCalculateLottoStaticsResultMap();

        for (List<Integer> current : userLottoList) {
            MatchInfo currentResult = this.calculateSingleLottoResult(current, bonusNumber);

            if (currentResult != null) {
                int count = calculateResult.get(currentResult);
                calculateResult.replace(currentResult, count + 1);
            }
        }
        return calculateResult;
    }

    private Map<MatchInfo, Integer> initializeCalculateLottoStaticsResultMap() {
        Map<MatchInfo, Integer> calculateResult = new TreeMap<>();

        calculateResult.put(MatchInfo.MATCH_THREE, 0);
        calculateResult.put(MatchInfo.MATCH_FOUR, 0);
        calculateResult.put(MatchInfo.MATCH_FIVE, 0);
        calculateResult.put(MatchInfo.MATCH_SIX, 0);
        calculateResult.put(MatchInfo.MATCH_FIVE_WITH_BONUS, 0);

        return calculateResult;
    }

    private MatchInfo calculateSingleLottoResult(List<Integer> input, int bonusNumber) {
        int count = 0;
        boolean bonus = false;

        for (int current : input) {
            if (numbers.contains(current)) {
                count += 1;
            }
        }

        if (count == 5 && input.contains(bonusNumber))
            bonus = true;

        return convertLottoResultToEnum(count, bonus);
    }

    private MatchInfo convertLottoResultToEnum(int count, boolean bonus) {
        if (count == MatchInfo.MATCH_THREE.getMatchNumber()) {
            return MatchInfo.MATCH_THREE;
        }
        if (count == MatchInfo.MATCH_FOUR.getMatchNumber()) {
            return MatchInfo.MATCH_FOUR;
        }
        if (count == MatchInfo.MATCH_FIVE.getMatchNumber()) {
            if (bonus) {
                return MatchInfo.MATCH_FIVE_WITH_BONUS;
            }
            return MatchInfo.MATCH_FIVE;
        }
        if (count == MatchInfo.MATCH_SIX.getMatchNumber()) {
            return MatchInfo.MATCH_SIX;
        }
        return null;
    }

    public BigInteger calculateWinningAmount(Map<MatchInfo, Integer> lottoStatistics) {
        BigInteger result = new BigInteger("0");
        for (MatchInfo key : lottoStatistics.keySet()) {
            int value = lottoStatistics.get(key);
            result = result.add(key.getWinningAmount().multiply(BigInteger.valueOf(value)));
        }
        return result;
    }

    public BigDecimal calculateProfitRatio(BigInteger income, int expense) {
        BigDecimal profit = new BigDecimal(income).multiply(BigDecimal.valueOf(100)).
                divide(new BigDecimal(expense), 1, RoundingMode.HALF_UP);
        return profit;
    }

    public enum MatchInfo {
        MATCH_THREE(3, "5000"),
        MATCH_FOUR(4, "50000"),
        MATCH_FIVE(5, "1500000"),
        MATCH_FIVE_WITH_BONUS(5, "30000000"),
        MATCH_SIX(6, "2000000000");

        private final int matchNumber;
        private final BigInteger winningAmount;

        MatchInfo(int matchNumber, String winningAmount) {
            this.matchNumber = matchNumber;
            this.winningAmount = new BigInteger(winningAmount);
        }

        public BigInteger getWinningAmount() {
            return winningAmount;
        }

        public int getMatchNumber() {
            return matchNumber;
        }
    }
}
