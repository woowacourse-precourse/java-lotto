package lotto.domain;

public enum Prize {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NOTHING(0, 0);

    private final int countAnswer;
    private final int prize;

    Prize(int countAnswer, int prize) {
        this.countAnswer = countAnswer;
        this.prize = prize;
    }

    public int getCountAnswer() {
        return countAnswer;
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
        if (countAnswer == 5 && countBonus == 1)
            return SECOND;
        if (countAnswer == 5)
            return THIRD;
        if (countAnswer == 4)
            return FOURTH;
        if (countAnswer == 3)
            return FIFTH;

        return NOTHING;
    }
}
