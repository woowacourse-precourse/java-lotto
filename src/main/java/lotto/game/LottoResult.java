package lotto.game;

public enum LottoResult {

    FIRST(1, 6, 0, 2000000000),
    SECOND(2, 5, 1, 30000000),
    THIRD(3, 5, 0, 1500000),
    FOURTH(4, 4, 0, 50000),
    FIFTH(5, 3, 0, 5000),
    NOTHING(6, -1, -1, 0);


    private final int rank;
    private final int lottoNumberCount;
    private final int bonusNumberCount;
    private final int amount;

    private LottoResult(int rank, int lottoNumberCount, int bonusNumberCount, int amount) {
        this.rank = rank;
        this.lottoNumberCount = lottoNumberCount;
        this.bonusNumberCount = bonusNumberCount;
        this.amount = amount;
    }

    public int getRank() {
        return rank;
    }

    public int getLottoNumberCount() {
        return lottoNumberCount;
    }

    public int getBonusNumberCount() {
        return bonusNumberCount;
    }

    public int getAmount() {
        return amount;
    }

    public static LottoResult get(int lottoNumberCount, int bonusNumberCount) {
        if (lottoNumberCount == FIRST.getLottoNumberCount()) {
            return FIRST;
        }
        if (lottoNumberCount == SECOND.getLottoNumberCount() && bonusNumberCount == SECOND.getBonusNumberCount()) {
            return SECOND;
        }
        if (lottoNumberCount == THIRD.getLottoNumberCount() && bonusNumberCount == THIRD.getBonusNumberCount()) {
            return THIRD;
        }
        if (lottoNumberCount == FOURTH.getLottoNumberCount()) {
            return FOURTH;
        }
        if (lottoNumberCount == FIFTH.getLottoNumberCount()) {
            return FIFTH;
        }
        return NOTHING;
    }
}
