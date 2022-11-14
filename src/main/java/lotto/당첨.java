package lotto;

import java.util.Arrays;
import java.util.Optional;

public enum 당첨 {
    FIRST(6,2_000_000_000,"6개 일치 (2,000,000,000원)"),
    SECOND(5,30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5,1_500_000,"5개 일치 (1,500,000원)"),
    FOURTH(4,50_000, "4개 일치 (50,000원)"),
    FIFTH(3,5_000,"3개 일치 (5,000원)");

    private final int matchingNumbers;
    private final int prize;
    private final String result;

    당첨(int matchingNumbers, int prize,String result) {
        this.matchingNumbers=matchingNumbers;
        this.prize=prize;
        this.result=result;
    }

    public static Optional<당첨> getRank(int matchingCount, boolean isBonus) {
        if(!isBonus && matchingCount==5)
            return Optional.of(THIRD);
        return Arrays.stream(당첨.values())
                .filter(당첨->당첨.matchingNumbers == matchingCount)
                .findFirst();
    }
}
