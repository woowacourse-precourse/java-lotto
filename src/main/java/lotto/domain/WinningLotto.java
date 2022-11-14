package lotto.domain;

import java.util.Arrays;

public enum WinningLotto {
    FIRST(6, "6개 일치 (2,000,000,000원)", 2000000000),
    SECOND(5, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    THIRD(5, "5개 일치 (1,500,000원)", 1500000),
    FOURTH(4, "4개 일치 (50,000원)", 50000),
    FIFTH(3, "3개 일치 (5,000원)", 5000),
    NOTHING(0, "miss", 0);

    private int winningNuberCount;
    private String name;
    private int winningPrice;

    WinningLotto(int winningNuberCount, String name, int winningPrice) {
        this.winningNuberCount = winningNuberCount;
        this.name = name;
        this.winningPrice = winningPrice;
    }

    public String getName() {
        return name;
    }

    public int getWinningNuberCount() {
        return winningNuberCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public static WinningLotto from(int winningNuberCount, boolean hasBonus) {
        if (winningNuberCount == SECOND.winningNuberCount && hasBonus) {
            return WinningLotto.SECOND;
        }
        if (winningNuberCount == THIRD.winningNuberCount && !hasBonus) {
            return WinningLotto.THIRD;
        }
        return Arrays.stream(WinningLotto.values()).filter(item -> item.getWinningNuberCount() == winningNuberCount)
                .findAny().orElse(NOTHING);
    }
}
