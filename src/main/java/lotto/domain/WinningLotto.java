package lotto.domain;

import static lotto.utils.Constant.NUMBER_OF_LOTTO;
import static lotto.utils.Validation.validateNumberInLottoRange;

import java.util.HashSet;
import java.util.List;
import lotto.utils.ExceptionType;

public class WinningLotto {

    private final Lotto winning;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.winning = new Lotto(numbers);

        validateForBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateForBonusNumber(int number) {
        validateNumberInLottoRange(number);
        validateByOverlapForAddBonusNumber(number);
    }

    private void validateByOverlapForAddBonusNumber(int bonusNumber) {
        HashSet<Integer> checkNumbers = new HashSet<>(winning.getNumbers());
        checkNumbers.add(bonusNumber);

        if (checkNumbers.size() != NUMBER_OF_LOTTO + 1) {
            throw new IllegalArgumentException(ExceptionType.HAVE_OVERLAP.getMessage());
        }
    }

    public Rank match(Lotto lotto) {
        int countOfMatch = (int) lotto.getNumbers().stream().
                filter(number -> winning.getNumbers().contains(number)).count();
        boolean bonusMatching = lotto.getNumbers().contains(bonusNumber);
        return Rank.matchRank(countOfMatch, bonusMatching);
    }
}
