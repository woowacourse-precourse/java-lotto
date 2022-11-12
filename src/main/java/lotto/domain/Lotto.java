package lotto.domain;

import constants.ExceptionMessage;
import constants.LottoGame;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import lotto.domain.dto.MatchResultDTO;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.MUST_SIX_DIGIT);
        }

        if (Set.copyOf(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBERS);
        }

        if(isWithinRange(numbers)) {
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

    public Match match(WinNumber winNumber) {
        MatchResultDTO dto = winNumber.matching(this);

        return Match.findByMatchCountAndMatchBonus(dto.getMatchCount(), dto.isMatchBonus());
    }

    private boolean isWithinRange(List<Integer> generalWinNumbers) {
        return generalWinNumbers.stream()
                .anyMatch(number -> !(number >= LottoGame.LOTTO_MIN_RANGE && number <= LottoGame.LOTTO_MAX_RANGE));
    }

}
