package lotto.domain;

import java.util.Arrays;

public enum WinningLotto {
    FIRST(6),
    SECOND(5),
    THIRD(5),
    FOURTH(4),
    FIFTH(3),
    NOTHING(0);

    private int winningNuberCount;

    WinningLotto(int winningNuberCount) {
        this.winningNuberCount = winningNuberCount;
    }

    public int getWinningNuberCount() {
        return winningNuberCount;
    }

    public static WinningLotto from(int winningNuberCount, boolean hasBonus) {
        if (winningNuberCount == SECOND.winningNuberCount && hasBonus) {
            return WinningLotto.SECOND;
        }
        if (winningNuberCount == THIRD.winningNuberCount && !hasBonus) {
            return WinningLotto.THIRD;
        }
        return Arrays.stream(WinningLotto.values())
                .filter(item -> item.getWinningNuberCount() == winningNuberCount)
                .findAny()
                .orElse(NOTHING);
    }
}
