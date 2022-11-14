package lotto.domain;

import java.util.Arrays;
import java.util.List;

import static lotto.dto.GameResultResponseDtos.GameResultResponseDto;

public enum LottoResult {

    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    ELSE(0, 0, false);

    private final int sameNumberCount;
    private final int winnerPrice;
    private final boolean hasBonus;

    LottoResult(int sameNumberCount, int winnerPrice, boolean hasBonus) {
        this.sameNumberCount = sameNumberCount;
        this.winnerPrice = winnerPrice;
        this.hasBonus = hasBonus;
    }

    public static LottoResult of(int sameNumberCount, boolean hasBonus) {
        return Arrays.stream(LottoResult.values())
                .filter(gameResult -> gameResult.isEqualSameNumberCount(sameNumberCount))
                .filter(gameResult -> gameResult.isEqualHasBonus(hasBonus))
                .findFirst()
                .orElse(ELSE);
    }

    private boolean isEqualSameNumberCount(int sameCount) {
        return this.sameNumberCount == sameCount;
    }

    private boolean isEqualHasBonus(boolean hasBonus) {
        return this.hasBonus == hasBonus;
    }

    public static int sumWinnerPrice(List<LottoResult> lottoResults) {
        return lottoResults.stream()
                .mapToInt(LottoResult::getWinnerPrice)
                .sum();
    }

    private static int getWinnerPrice(LottoResult lottoResult) {
        return lottoResult.winnerPrice;
    }

    public GameResultResponseDto toResponseDto(int totalCount) {
        return new GameResultResponseDto(sameNumberCount, winnerPrice, hasBonus, totalCount);
    }

    public boolean isFirst() {
        return this == FIRST;
    }

    public boolean isSecond() {
        return this == SECOND;
    }

    public boolean isThird() {
        return this == THIRD;
    }

    public boolean isFourth() {
        return this == FOURTH;
    }

    public boolean isFifth() {
        return this == FIFTH;
    }

    public boolean isElse() {
        return this == ELSE;
    }

    public boolean equals(LottoResult lottoResult) {
        return this == lottoResult;
    }
}
