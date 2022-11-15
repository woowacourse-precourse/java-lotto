package lotto;

public enum Prize {
    FAIL(0, 0),
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FORTH(4, 50000),
    FIFTH(3, 5000);

    private final int correctCount;
    private final int prize;

    Prize(int correctCount, int prize) {
        this.correctCount = correctCount;
        this.prize = prize;
    }

    public static Prize makingResult(int correctCount, boolean correctBonus) {
        if (correctCount < 3) {
            return FAIL;
        }
        if (correctCount == 3 && correctBonus == true) {
            return SECOND;
        }
        for (Prize prize : values()) {
            if (prize.getCorrectCount() == correctCount) {
                return prize;
            }
        }
        throw new IllegalArgumentException("[ERROR] 맞춘 번호의 수가 6을 초과합니다.");
    }


    public int getCorrectCount() {
        return correctCount;
    }

    public int getPrize() {
        return prize;
    }

}