package lotto.domain;

import java.util.List;
import java.util.regex.Pattern;

import static lotto.constant.ConstValue.DIGIT_REGEX;
import static lotto.constant.Message.*;

public class WinningLotto extends Lotto{
    private int bonusNumber;

    public WinningLotto(List<Integer> numbers, String inputBonus) {
        super(numbers);
        validate(numbers, inputBonus);
        this.bonusNumber = Integer.parseInt(inputBonus);
    }

    private void validate(List<Integer> numbers, String inputBonus) {
        validateDigit(inputBonus);
        validateDuplicate(numbers, inputBonus);
    }

    private void validateDuplicate(List<Integer> numbers, String inputBonus) {
        int bonus = Integer.parseInt(inputBonus);

        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + DUPLICATE_LOTTO_NUMBER_MESSAGE);
        }
    }

    private void validateDigit(String inputBonus) {
        if (!Pattern.matches(DIGIT_REGEX, inputBonus)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_NUMBER_INPUT_FORMAT_MESSAGE);
        }
    }

    public Rank compareLottoNumber(Lotto lotto) {
        int countOfMatch = getCountOfMatch(lotto);
        boolean isMatchedBonus = isMatchedBonus(lotto);

        return Rank.makeRank(countOfMatch, isMatchedBonus);
    }

    private boolean isMatchedBonus(Lotto lotto) {
        return lotto.getNumbers().contains(this.bonusNumber);
    }

    private int getCountOfMatch(Lotto lotto) {
        return (int) this.getNumbers()
                .stream()
                .filter(
                        number ->
                                lotto.getNumbers().contains(number)
                )
                .count();
    }
}
