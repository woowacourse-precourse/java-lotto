package lotto.config;

import java.util.Arrays;

public enum LottoPrize {

    LOST(0, false, 0),
    FIFTH_PLACE(3, false, 5_000),
    FOURTH_PLACE(4, false, 50_000),
    THIRD_PLACE(5, false, 1_500_000),
    SECOND_PLACE(5, true, 30_000_000),
    FIRST_PLACE(6, false, 2_000_000_000);

    private final int lottoNumber;
    private final boolean bonusNumber;
    private final int winnings;

    LottoPrize(int lottoNumber, boolean bonusNumber, int winnings) {
        this.lottoNumber = lottoNumber;
        this.bonusNumber = bonusNumber;
        this.winnings = winnings;
    }

    public static LottoPrize findByMatchAndBonus(int match, boolean bonus) {
        return Arrays.stream(LottoPrize.values())
                .filter(winning -> winning.findByLottoNumber(match, bonus))
                .findAny()
                .orElse(LOST);
    }

    private boolean findByLottoNumber(int match, boolean bonus) {
        return lottoNumber == match && bonusNumber == bonus;
    }

    public static int getWinningsByPrize(String name){
        return LottoPrize.valueOf(name).winnings;
    }
}
