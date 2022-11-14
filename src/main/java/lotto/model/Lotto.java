package lotto.model;

import lotto.validator.LottoValidator;

import java.util.List;

import static lotto.global.LottoConstants.LOTTO_COUNT_BY_2ND_AWARD;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validate(numbers);
        this.numbers = numbers;
    }

    public LottoRank getCorrectLottoCount(Lotto winningLotto, int bounsNumber) {
        int matchingCount = getMatchingCount(winningLotto);
        boolean bounsFlag = false;

        if (matchingCount == LOTTO_COUNT_BY_2ND_AWARD && numbers.contains(bounsNumber)) {
            bounsFlag = true;
        }

        return LottoRank.getRank(matchingCount, bounsFlag);
    }

    private int getMatchingCount(Lotto winningLotto) {
        int matchingCount = 0;

        for (Integer number : winningLotto.numbers) {
            if (numbers.contains(number)) {
                matchingCount++;
            }
        }

        return matchingCount;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
