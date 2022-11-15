package domain;

import dto.ResultDto;
import ui.ExceptionMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isUniqueNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void isUniqueNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer value : numbers) {
            set.add(value);
        }

        if (set.size() != numbers.size())
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_UNIQUE_LOTTO_NUMBER.getTxt());
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public ResultDto getResult(List<Lotto> boughtLottos, Integer bonus) {
        ResultDto result = new ResultDto();
        for (Lotto boughtLotto : boughtLottos) {
            int count = 0;
            int bonusCount = 0;
            for (Integer value : boughtLotto.getNumbers()) {
                if (this.getNumbers().contains(value))
                    count++;
                if (value == bonus)
                    bonusCount++;
            }
            if (count == 3)
                result.setThreeCount(result.getThreeCount() + 1);
            else if (count == 4)
                result.setFourCount(result.getFourCount() + 1);
            else if (count == 5 && bonusCount == 1)
                result.setFiveBonusCount(result.getFiveBonusCount() + 1);
            else if (count == 5)
                result.setFiveCount(result.getFiveCount() + 1);
            else if (count == 6)
                result.setSixCount(result.getSixCount() + 1);
        }

        return result;
    }
}
