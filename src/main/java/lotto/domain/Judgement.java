package lotto.domain;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lotto.domain.Rank.*;

public class Judgement {
    private static final int FIFTH_PLACE_COUNT = 3;
    private static final int FOURTH_PLACE_COUNT = 2;
    private static final int THIRD_OR_SECOND_PLACE_CANDIDATE_COUNT = 1;

    public Rank getLottoRank(Lotto lotto, WinningLotto winningLotto) {
        List<Integer> differentNumbers = compare(lotto, winningLotto);
        if (differentNumbers.size() > FIFTH_PLACE_COUNT) {
            return UNRANK;
        }
        if (differentNumbers.size() == FIFTH_PLACE_COUNT) {
            return FIFTH_PLACE;
        }
        if (differentNumbers.size() == FOURTH_PLACE_COUNT) {
            return FOURTH_PLACE;
        }
        if (differentNumbers.size() == THIRD_OR_SECOND_PLACE_CANDIDATE_COUNT) {
            int bonusNumber = winningLotto.getBonusNumber();
            if (!differentNumbers.contains(bonusNumber)) {
                return THIRD_PLACE;
            }
            return SECOND_PLACE;
        }
        return FIRST_PLACE;
    }

    private List<Integer> compare(Lotto lotto, WinningLotto winningLotto) {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getWinningLottoNumbers();
        return numbers.stream()
                .filter(number -> !winningNumbers.contains(number))
                .collect(toList());
    }
}
