package lotto;

public enum Rank {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000);

    private final int matchNumber;
    private final int prize;
    private int count;

    Rank(int matchNumber, int prize) {  // Default 생성자는 private 으로 설정되어 있음.
        this.matchNumber = matchNumber;
        this.prize = prize;
    }

    public void plusCount() {
        this.count++;
    }
}
