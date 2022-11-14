package lotto;

public enum Rank { //여기에 겹치는 개수 변수도 추가하는 건 어떰??
    FIRST(2000000000, 6, 0), SECOND(30000000, 5, 1), THIRD(1500000, 5, 0),
    FORTH(50000, 4, 0), FIFTH(5000, 3, 0);

    Rank(int reward, int overlappingNumber, int bonusBall) {
        this.reward = reward;
        this.overlappingNumber = overlappingNumber;
        this.bonusBall = bonusBall;
    }
    private final int reward;
    private final int overlappingNumber;
    private final int bonusBall;

    public int getReward() {
        return reward;
    }

    public int getOverlappingNumber() {
        return overlappingNumber;
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
