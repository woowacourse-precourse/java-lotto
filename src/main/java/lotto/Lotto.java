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
            throw new IllegalArgumentException();
        }
        this.isDuplicateNumberExist(numbers);
    }

    private void isDuplicateNumberExist(List<Integer> input){
        Set<Integer> set = new HashSet<>(input);
        if(input.size() != set.size())
            throw new IllegalArgumentException();
    }

    public Map<LottoMatch, Integer> calculateLottoStatistics(List<List<Integer>> userLottoList, int bonusNumber) {
        Map<LottoMatch, Integer> calculateResult = new TreeMap<>();

        for (List<Integer> current : userLottoList) {
            LottoMatch currentResult = this.calculateSingleLottoResult(current, bonusNumber);
            if (currentResult != null) {
                if (calculateResult.containsKey(currentResult)) {
                    int count = calculateResult.get(currentResult);
                    calculateResult.replace(currentResult, count + 1);
                } else {
                    calculateResult.put(currentResult, 1);
                }
            }
        }
        return calculateResult;
    }

    private LottoMatch calculateSingleLottoResult(List<Integer> input, int bonusNumber) {
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

    private LottoMatch convertLottoResultToEnum(int count, boolean bonus) {
        if (count == 3) {
            return LottoMatch.MATCH_THREE;
        } else if (count == 4) {
            return LottoMatch.MATCH_FOUR;
        } else if (count == 5) {
            if (bonus) {
                return LottoMatch.MATCH_FIVE_WITH_BONUS;
            }
            return LottoMatch.MATCH_FIVE;
        } else if (count == 6) {
            return LottoMatch.MATCH_SIX;
        }
        return null;
    }

    public BigInteger calculateWinningAmount(Map<LottoMatch, Integer> lottoStatistics) {
        BigInteger result = new BigInteger("0");
        for (LottoMatch key : lottoStatistics.keySet()) {
            int value = lottoStatistics.get(key);
            if (key == LottoMatch.MATCH_THREE) {
                result = result.add(WinningAmount.MATCH_THREE.getValue().multiply(BigInteger.valueOf(value)));
            } else if (key == LottoMatch.MATCH_FOUR) {
                result = result.add(WinningAmount.MATCH_FOUR.getValue().multiply(BigInteger.valueOf(value)));
            } else if (key == LottoMatch.MATCH_FIVE) {
                result = result.add(WinningAmount.MATCH_FIVE.getValue().multiply(BigInteger.valueOf(value)));
            } else if (key == LottoMatch.MATCH_FIVE_WITH_BONUS) {
                result = result.add(WinningAmount.MATCH_FIVE_WITH_BONUS.getValue().multiply(BigInteger.valueOf(value)));
            } else if (key == LottoMatch.MATCH_SIX) {
                result = result.add(WinningAmount.MATCH_SIX.getValue().multiply(BigInteger.valueOf(value)));
            }
        }
        return result;
    }

    public BigDecimal calculateProfitRatio(BigInteger income, int expense){
        BigDecimal profit = BigDecimal.valueOf(expense).multiply(BigDecimal.valueOf(100)).
                divide(new BigDecimal(income),1, RoundingMode.HALF_UP);
        return profit;
    }

    public enum LottoMatch {
        MATCH_THREE(0),
        MATCH_FOUR(1),
        MATCH_FIVE(2),
        MATCH_FIVE_WITH_BONUS(3),
        MATCH_SIX(4);

        private final int value;

        LottoMatch(int value) {
            this.value = value;
        }
    }

    public enum WinningAmount {
        MATCH_THREE("5000"),
        MATCH_FOUR("50000"),
        MATCH_FIVE("1500000"),
        MATCH_FIVE_WITH_BONUS("30000000"),
        MATCH_SIX("2000000000");

        private final BigInteger value;

        WinningAmount(String value) {
            this.value = new BigInteger(value);
        }

        public BigInteger getValue() {
            return this.value;
        }
    }
}
