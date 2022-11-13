package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    NOTHING(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matchCount;
    private final int price;

    Rank(int matchCount, int price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public static Rank from(WinningLotto winningLotto, Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int matchCount = winningLotto.match(lotto);

        if (isSecondPlace(winningLotto, lottoNumbers, matchCount)) {
            return Rank.SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchCount() == matchCount)
                .findFirst()
                .orElse(NOTHING);
    }
    
    private static boolean isSecondPlace(WinningLotto winningLotto, List<Integer> lottoNumbers, int matchCount) {
        return isSecondMatchCount(matchCount) && winningLotto.isMatchedBonusNumber(lottoNumbers);
    }

    private static boolean isSecondMatchCount(int matchCount) {
        return Rank.SECOND.getMatchCount() == matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrice() {
        return price;
    }
}
