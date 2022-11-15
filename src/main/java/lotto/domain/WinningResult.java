package lotto.domain;

public enum WinningResult {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    NONE(0);

    private final int prize;

    WinningResult(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static WinningResult match(int count, boolean bonus) {
        if (count >= 3) {
            return win(count, bonus);
        }
        return WinningResult.NONE;
    }

    private static WinningResult win(int count, boolean bonus) {
        if (bonus && count == 5) {
            return WinningResult.SECOND;
        }
        return winWithoutBonus(count);
    }

    private static WinningResult winWithoutBonus(int count) {
        if (count == 6) {
            return WinningResult.FIRST;
        }
        if (count == 5) {
            return WinningResult.THIRD;
        }
        if (count == 4) {
            return WinningResult.FOURTH;
        }
        return WinningResult.FIFTH;
    }
}
