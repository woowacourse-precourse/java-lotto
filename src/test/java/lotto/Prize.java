package lotto;

public class Prize {
    public enum Rank {
        FIRST(6, 0, 2_000_000_000),
        SECOND(5, 1, 30_000_000),
        THIRD(5, 0, 1_500_000),
        FOURTH(4, 0, 50_000),
        FIFTH(3, 0, 5_000);

        private final int matchingWinningNumberCount;
        private final int matchingBonusNumberCount;
        private final int money;

        Rank(int matchingWinningNumberCount, int matchingBonusNumberCount, int money) {
            this.matchingWinningNumberCount = matchingWinningNumberCount;
            this.matchingBonusNumberCount = matchingBonusNumberCount;
            this.money = money;
        }

        public int getMoney() {
            return this.money;
        }
    }
}
