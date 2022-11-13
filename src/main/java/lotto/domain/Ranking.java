package lotto.domain;

public enum Ranking {
    FIRST (6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD (5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH (3, 5000, false),
    SIXTH (0, 0, false);

    private int countWinningNumbers;
    private int winningPrice;
    private boolean containsBonus;

    public int getCountWinningNumbers() {
        return countWinningNumbers;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public boolean isContainsBonus() {
        return containsBonus;
    }

    Ranking(int countNumbers, int winningPrice, boolean hasBonusNumber) {
        this.countWinningNumbers = countNumbers;
        this.winningPrice = winningPrice;
        this.containsBonus = hasBonusNumber;
    }

    public static Ranking getRanking(int countMatch, boolean isMatchBonus) {

        Ranking[] arr = Ranking.values();
        for (Ranking ranking : arr) {
            if (ranking.getCountWinningNumbers() == countMatch && ranking.isContainsBonus() == isMatchBonus) {
                return ranking;
            }
        }
        return Ranking.SIXTH;
    }



}
