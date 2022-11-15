package lotto;

public class LottoMetadata {
    private final Integer startNumberInRange;
    private final Integer endNumberInRange;
    private final Integer wonPerLotto;
    private final Integer numberSize;

    public LottoMetadata(
            Integer startNumberInRange,
            Integer endNumberInRange,
            Integer wonPerLotto,
            Integer numberSize
    ) {
        this.startNumberInRange = startNumberInRange;
        this.endNumberInRange = endNumberInRange;
        this.wonPerLotto = wonPerLotto;
        this.numberSize = numberSize;
    }

    public Integer getStartNumberInRange() {
        return startNumberInRange;
    }

    public Integer getEndNumberInRange() {
        return endNumberInRange;
    }

    public Integer getWonPerLotto() {
        return wonPerLotto;
    }

    public Integer getNumberSize() {
        return numberSize;
    }
}
