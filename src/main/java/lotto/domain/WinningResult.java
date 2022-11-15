package lotto.domain;

public enum WinningResult {
    FIRST(2_000_000_000, 6, 0),
    SECOND(30_000_000, 5, 1),
    THIRD(1_500_000, 5, 0),
    FOURTH(50_000, 4, 0),
    FIFTH(5_000, 3, 0),
    NONE(0, 0, 0);

    private final int prize;
    private final int winning;
    private final int bonus;

    WinningResult(int prize, int winning, int bonus) {
        this.prize = prize;
        this.winning = winning;
        this.bonus = bonus;
    }

    public int getPrize() {
        return prize;
    }

    public int getWinning() {
        return winning;
    }

    public int getBonus() {
        return bonus;
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
