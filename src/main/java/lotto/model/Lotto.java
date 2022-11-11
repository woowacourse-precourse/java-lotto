package lotto.model;

import lotto.validator.LottoValidator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validate(numbers);
        this.numbers = numbers;
    }

    public LottoRank getCorrectLottoCount(Lotto winningLotto, int bounsNumber) {
        int matchingCount = 0;
        boolean bounsFlag = false;

        for (Integer number : winningLotto.numbers) {
            if (numbers.contains(number)) {
                matchingCount++;
            }
        }

        if (matchingCount == 5 && numbers.contains(bounsNumber)) {
            bounsFlag = true;
        }

        return LottoRank.getRank(matchingCount, bounsFlag);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
