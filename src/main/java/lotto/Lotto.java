package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    }

    public Map<LottoMatch, Integer> calculateLottoStatistics(List<List<Integer>> userLottoList, int bonusNumber) {
        Map<LottoMatch, Integer> calculateResult = new HashMap<>();

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
}
