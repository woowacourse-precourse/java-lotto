package lotto;

import static java.util.stream.Collectors.toList;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Rank getRankOfLotto(Lotto lotto) {
        List<Integer> userNumbers = lotto.getNumbers();
        int countOfMatchingNumbers = userNumbers.stream()
                .filter(this.lotto::contains)
                .collect(toList())
                .size();

        boolean includesBonusNumber = lotto.contains(bonusNumber);

        return Rank.of(countOfMatchingNumbers, includesBonusNumber);
    }
}
