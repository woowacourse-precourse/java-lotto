package lotto;

public enum LottoReward {
    first(1, 2_000_000_000),
    second(2, 30_000_000),
    third(3, 1_500_000),
    fourth(4, 50_000),
    fifth(5, 5_000);

    private final int rank;
    private final int reward;

    LottoReward(int rank, int reward) {
        this.rank = rank;
        this.reward = reward;
    }
}
