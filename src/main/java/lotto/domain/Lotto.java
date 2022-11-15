package lotto.domain;

import static lotto.utils.message.NumberMessageUtil.FIVE;
import static lotto.utils.message.NumberMessageUtil.FOUR;
import static lotto.utils.message.NumberMessageUtil.SIX;
import static lotto.utils.message.NumberMessageUtil.THREE;
import static lotto.utils.validate.NumberValidator.validateNumber;
import static lotto.utils.validate.NumberValidator.validateNumbersSize;

import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.winning.RankUtil;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        List<Integer> distinctNumbers = getDistinctNumbers(numbers);
        validateNumbersSize(distinctNumbers);

        for (Integer number : distinctNumbers) {
            validateNumber(number);
        }
    }

    private List<Integer> getDistinctNumbers(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public RankUtil compare(List<Integer> winningNumbers, int bonusNumber) {
        int count = correctCount(winningNumbers);
        boolean isBonusMatch = isMatchBonusNumber(bonusNumber);

        return getRank(count, isBonusMatch);
    }

    private RankUtil getRank(int count, boolean isBonusMatch) {
        if (count == SIX.getNumber()) {
            return RankUtil.FIRST;
        } else if (count == FIVE.getNumber() && isBonusMatch) {
            return RankUtil.SECOND;
        } else if (count == FIVE.getNumber()) {
            return RankUtil.THIRD;
        } else if (count == FOUR.getNumber()) {
            return RankUtil.FOURTH;
        } else if (count == THREE.getNumber()) {
            return RankUtil.FIFTH;
        }
        return RankUtil.MISS;
    }

    private int correctCount(List<Integer> winningLottoNumbers) {
        int count = 0;

        for (Integer winningLottoNumber : winningLottoNumbers) {
            if (numbers.contains(winningLottoNumber)) {
                count++;
            }
        }

        return count;
    }

    private boolean isMatchBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getSortNumbers() {
        return numbers.stream()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
    }

}
