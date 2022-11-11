package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.GameResultResponseDto.*;

public enum LottoResult {

    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    ELSE(0, 0, false);

    private final int sameNumberCount;
    private final int winnerPrice;
    private final boolean isSameBonus;

    LottoResult(int sameNumberCount, int winnerPrice, boolean isSameBonus) {
        this.sameNumberCount = sameNumberCount;
        this.winnerPrice = winnerPrice;
        this.isSameBonus = isSameBonus;
    }

    public static LottoResult of(int sameNumberCount, boolean isSameBonus) {
        return Arrays.stream(LottoResult.values())
                .filter(gameResult -> gameResult.isEqualSameNumberCount(sameNumberCount))
                .filter(gameResult -> gameResult.isEqualSameBonus(isSameBonus))
                .findFirst()
                .orElse(ELSE);
    }

    private boolean isEqualSameNumberCount(int sameCount) {
        return this.sameNumberCount == sameCount;
    }

    private boolean isEqualSameBonus(boolean isSameBonus) {
        return this.isSameBonus == isSameBonus;
    }

    public static int sumWinnerPrice(List<LottoResult> lottoResults) {
        return lottoResults.stream()
                .mapToInt(LottoResult::getWinnerPrice)
                .sum();
    }

    private static int getWinnerPrice(LottoResult lottoResult) {
        return lottoResult.winnerPrice;
    }

    public static List<LottoResult> valuesExcludeElse() {
        return Arrays.stream(LottoResult.values())
                .filter(gameResult -> !gameResult.isElse())
                .collect(Collectors.toList());
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

    public LottoResultResponseDto toResponseDto(int totalCount) {
        return new LottoResultResponseDto(sameNumberCount, winnerPrice, isSameBonus, totalCount);
    }
}
