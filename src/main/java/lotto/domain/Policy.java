package lotto.domain;

public class Policy {

    public static final int PRICE = 1000; // 로또 한장당 가격

    public enum WinningCriteria { // 당첨기준
        WINNING_FIVE(3, 0),
        WINNING_FOUR(4, 0),
        WINNING_THREE(5, 0),
        WINNING_TWO(5, 1),
        WINNING_ONE(6, 0);
        private final int matchingCount; // 당첨번호와 일치하는 수
        private final int bonusNumberCount; // 보너스 번호 일치여부 (-1: 의미없음, 0: 일치X, 1: 일치)

        WinningCriteria(int matchingCount, int bonusNumberCount) {
            this.matchingCount = matchingCount;
            this.bonusNumberCount = bonusNumberCount;
        }

        public int getMatchingCount() {
            return this.matchingCount;
        }

        public int getBonusNumberCount() {
            return this.bonusNumberCount;
        }

        public static WinningCriteria find(int[] grade) {
            WinningCriteria[] winnings = WinningCriteria.values();
            for (WinningCriteria winning : winnings) {
                if (grade[0] == winning.matchingCount && grade[1] == winning.bonusNumberCount) {
                    return winning;
                }
            }
            return null;
        }
    }

    public enum WinningAmount { // 각 등수별 당첨금액
        WINNING_FIVE(5000),
        WINNING_FOUR(50000),
        WINNING_THREE(1500000),
        WINNING_TWO(30000000),
        WINNING_ONE(2000000000);

        private final long amount;

        WinningAmount(long amount) {
            this.amount = amount;
        }

        public long getAmount() {
            return this.amount;
        }
    }
}
