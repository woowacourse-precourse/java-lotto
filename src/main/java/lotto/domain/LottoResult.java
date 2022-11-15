package lotto.domain;

final class LottoResult {
    private final LottoSameCount sameCount;
    private final LottoContainBonus containBonus;

    public LottoResult(LottoSameCount sameCount, LottoContainBonus containBonus) {
        this.sameCount = sameCount;
        this.containBonus = containBonus;
    }

    public LottoPrize calculatePrize() {
        if (isFirstPrize()) {
            return LottoPrize.FIRST_PRIZE;
        }
        if (isSecondPrize()) {
            return LottoPrize.SECOND_PRIZE;
        }
        if (isThirdPrize()) {
            return LottoPrize.THIRD_PRIZE;
        }
        if (isFourthPrize()) {
            return LottoPrize.FOURTH_PRIZE;
        }
        if (isFifthPrize()) {
            return LottoPrize.FIFTH_PRIZE;
        }
        return LottoPrize.ZERO;
    }

    private boolean isFirstPrize() {
        return sameCount == LottoSameCount.SIX_SAME;
    }

    private boolean isSecondPrize() {
        return sameCount == LottoSameCount.FIVE_SAME
                && containBonus == LottoContainBonus.CONTAIN;
    }

    private boolean isThirdPrize() {
        return sameCount == LottoSameCount.FIVE_SAME
                && containBonus == LottoContainBonus.NOT_CONTAIN;
    }

    private boolean isFourthPrize() {
        return sameCount == LottoSameCount.FOUR_SAME;
    }

    private boolean isFifthPrize() {
        return sameCount == LottoSameCount.THREE_SAME;
    }
    
    @Override
    public boolean equals(Object other) {
        return other instanceof LottoResult &&
                calculatePrize() == ((LottoResult) other).calculatePrize();
    }
}
