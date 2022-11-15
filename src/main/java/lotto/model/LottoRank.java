package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

import static lotto.utils.ExceptionMessage.RESULT_NOT_CORRECT_EXCEPTION;

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
                .orElseThrow(() -> new IllegalArgumentException(RESULT_NOT_CORRECT_EXCEPTION));
    }

    public static List<LottoRank> getWithoutDefault() {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> !rank.equals(NOTHING))
                .collect(Collectors.toList());
    }

    public long multiple(Integer count) {
        return (long) prizeAmount * count;
    }

    public int getCorrectNumber() {
        return correctNumber;
    }

    public int getPrizeAmount() {
        return  prizeAmount;
    }
}
