package lotto.domain;

public enum Prize {
    FIRST(6, 2000000000, "(2,000,000,000원)"), SECOND(5, 30000000, "(30,000,000원)"), THIRD(5, 1500000, "(1,500,000원)"), FOURTH(4, 50000, "(50,000원)"), FIFTH(3, 5000, "(5,000원)"), NOTHING(0, 0, "");

    private final int countAnswer;
    private final int prize;
    private final String prizeString;

    Prize(int countAnswer, int prize, String prizeString) {
        this.countAnswer = countAnswer;
        this.prize = prize;
        this.prizeString = prizeString;
    }

    public int getCountAnswer() {
        return countAnswer;
    }

    public String getPrizeString() {
        return prizeString;
    }

    public int getPrize() {
        return prize;
    }

    /**
     * 도메인 로직
     */
    public static Prize getResult(int countAnswer, int countBonus) {
        if (countAnswer == 6)
            return FIRST;
        if (countAnswer == 5 && countBonus == 1) return SECOND;
        if (countAnswer == 5) return THIRD;
        if (countAnswer == 4) return FOURTH;
        if (countAnswer == 3) return FIFTH;

        return NOTHING;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(countAnswer + "개 일치");

        if (prize == 30000000) result.append(", 보너스 볼 일치");

        return result.append(" ").append(getPrizeString()).append(" - ").toString();
    }
}
