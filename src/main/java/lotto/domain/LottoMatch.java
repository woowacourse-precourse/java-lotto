package lotto.domain;

public enum LottoMatch {

    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    BONUS(7);

    private int value;

    LottoMatch(int value) {
        this.value = value;
    }

    public static LottoMatch match(int target) {
        for (LottoMatch lottoMatch: LottoMatch.values()) {
            if (lottoMatch.value == target) {
                return lottoMatch;
            }
        }

        return ZERO;
    }
}
