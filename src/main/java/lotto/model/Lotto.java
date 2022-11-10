package lotto.model;

import java.util.List;

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
}
