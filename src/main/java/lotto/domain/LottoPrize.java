package lotto.domain;

public enum LottoPrize {
    FIRST_PRIZE(6, 0, 2_000_000_000),
    SECOND_PRIZE(5, 1, 30_000_000),
    THIRD_PRIZE(5, 0, 1_500_000),
    FOURTH_PRIZE(4, 0, 50_000),
    FIFTH_PRIZE(3, 0, 5_000),
    NO_PRIZE(0,0, 0);

    LottoPrize(int lottoNumberCount, int bonusNumberCount, int prize) {
    }

}
