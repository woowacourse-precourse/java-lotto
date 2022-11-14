package lotto.model;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoRank {
    NOTHING(0, 0, (correctNumber, matchBonus) -> correctNumber < 3),
    FIFTH(3, 5000, (correctNumber, matchBonus) -> correctNumber == 3),
    FOURTH(4, 50000, (correctNumber, matchBonus) -> correctNumber == 4),
    THIRD(5, 1500000, (correctNumber, matchBonus) -> correctNumber == 5 && !matchBonus),
    SECOND(5, 30000000, (correctNumber, matchBonus) -> correctNumber == 5 && matchBonus),
    FIRST(6, 2000000000, (correctNumber, matchBonus) -> correctNumber == 6);

    private final int correctNumber;
    private final int prizeAmount;
    private final BiPredicate<Integer, Boolean> isMatch;

    LottoRank(final int correctNumber, final int prizeAmount, BiPredicate<Integer, Boolean> isMatch){
        this.correctNumber =correctNumber;
        this.prizeAmount = prizeAmount;
        this.isMatch = isMatch;

    }


    public static LottoRank valueOf(int sameCount, boolean bonus) {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.isMatch.test(sameCount, bonus))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 조건에 맞지 않는 당첨입니다."));
    }
}
