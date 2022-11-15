package lotto;

public enum Division {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    public static final int MIN_VALUE = 3;
    public static final int MAX_VALUE = 6;
    private final int matchCount;
    private final int prize;

    Division(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static Division of(int hits) throws IllegalArgumentException {
        if (hits < MIN_VALUE || MAX_VALUE + 1 < hits) {
            throw new IllegalArgumentException("[ERROR]: Division 클래스에 존재하지 않는 개수");
        }
        Division[] divisions = Division.values();
        return divisions[hits - MIN_VALUE];
    }
}
