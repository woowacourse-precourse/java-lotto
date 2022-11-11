package lotto.model.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    private static final String NUMBER_SEPARATOR = ",";
    private static final int FIFTH_SCORE = 3;
    private static final int FOURTH_SCORE = 4;
    private static final int THIRD_SCORE = 5;
    private static final int FIRST_SCORE = 6;

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningNumber(String winningNumber, String bonusNumber) {
        List<Integer> numbers = Arrays.stream(winningNumber.split(NUMBER_SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        lotto = new Lotto(numbers);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public Rank computeRank(Lotto lotto) {
        int numOfMatch = this.lotto.countMatch(lotto);
        boolean isBonusMatch = lotto.contains(bonusNumber);

        return computeRank(numOfMatch, isBonusMatch);
    }

    private Rank computeRank(int numOfMatch, boolean isBonusMatch) {
        if (numOfMatch == FIFTH_SCORE) {
            return Rank.FIFTH;
        }
        if (numOfMatch == FOURTH_SCORE) {
            return Rank.FOURTH;
        }
        if (numOfMatch == THIRD_SCORE && !isBonusMatch) {
            return Rank.THIRD;
        }
        if (numOfMatch == THIRD_SCORE && isBonusMatch) {
            return Rank.SECOND;
        }
        if (numOfMatch == FIRST_SCORE) {
            return Rank.FIRST;
        }
        return Rank.NOTHING;
    }
}
