package lotto.domain;

import static lotto.utils.Constant.NUMBER_OF_LOTTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import lotto.utils.ExceptionType;
import lotto.view.Output;

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

    private void validateNumberInLottoRange(int number) {
        if (number < 1 || number > 45) {
            Output.printErrorAndExit(ExceptionType.NOT_WITHIN_THE_RANGE.getMessage());
            throw new IllegalArgumentException(ExceptionType.NOT_WITHIN_THE_RANGE.getMessage());
        }
    }

    private void validateByOverlapForAddBonusNumber(int bonusNumber) {
        HashSet<Integer> checkNumbers = new HashSet<>(winning.getNumbers());
        checkNumbers.add(bonusNumber);

        if (checkNumbers.size() != NUMBER_OF_LOTTO + 1) {
            Output.printErrorAndExit(ExceptionType.HAVE_OVERLAP.getMessage());
            throw new IllegalArgumentException(ExceptionType.HAVE_OVERLAP.getMessage());
        }
    }

    public List<? extends Serializable> match(Lotto lotto) {
        int mainMatching = (int) lotto.getNumbers().stream().
                filter(number -> winning.getNumbers().contains(number)).count();
        boolean bonusMatching = lotto.getNumbers().contains(bonusNumber);
        return List.of(mainMatching, bonusMatching);
    }
}
