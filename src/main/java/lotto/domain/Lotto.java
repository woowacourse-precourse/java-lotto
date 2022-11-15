package lotto.domain;

import constants.ExceptionMessage;
import constants.LottoGame;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import lotto.domain.dto.MatchResultDTO;
import lotto.presentation.view.LottoExceptionPrinter;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            LottoExceptionPrinter.throwMustSixDigit();
            throw new IllegalArgumentException(ExceptionMessage.MUST_SIX_DIGIT);
        }

        if (Set.copyOf(numbers).size() != numbers.size()) {
            LottoExceptionPrinter.throwDuplicateNumbers();
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBERS);
        }

        if(isWithinRange(numbers)) {
            LottoExceptionPrinter.throwWithinRange();
            throw new IllegalArgumentException(ExceptionMessage.WITHIN_RANGE);
        }
    }


    @Override
    public String toString() {
        return numbers.toString();
    }

    public void sortAscending() {
        Collections.sort(numbers);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public boolean matchBonusBall(BonusBall bonusBall) {
        return numbers.stream()
                .anyMatch(number -> bonusBall.isSame(number));
    }

    public int matchWinningBalls(WinningBalls winningBalls) {
        return (int) numbers.stream()
                .filter(number -> winningBalls.contains(number))
                .count();
    }

    public Match match(Balls balls) {
        MatchResultDTO dto = balls.matching(this);

        return Match.findByMatchCountAndIsMatchBonus(dto.getMatchCount(), dto.isMatchBonus());
    }

    private boolean isWithinRange(List<Integer> generalWinNumbers) {
        return generalWinNumbers.stream()
                .anyMatch(number -> !(number >= LottoGame.LOTTO_MIN_RANGE && number <= LottoGame.LOTTO_MAX_RANGE));
    }

}
