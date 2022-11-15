package lotto.model.statistics;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {

    FIRST(6,2_000_000_000,(correctNumCount,isMatchBonus)-> correctNumCount == 6),
    SECOND(5,30_000_000,(correctNumCount,isMatchBonus)-> correctNumCount == 5 && isMatchBonus),
    THIRD(5,1_500_000,(correctNumCount,isMatchBonus)-> correctNumCount == 5 && !isMatchBonus),
    FOURTH(4,50_000,(correctNumCount,isMatchBonus)-> correctNumCount == 4),
    FIFTH(3,5_000,(correctNumCount,isMatchBonus)-> correctNumCount == 3),
    FAIL(0,0,(correctNumCount,isMatchBonus)-> correctNumCount < 3);

    private final Integer sameCount;
    private final Integer prize;
    private final BiPredicate<Integer,Boolean> matchCase;

    Rank(Integer sameCount,Integer prize, BiPredicate<Integer,Boolean> matchCase){
        this.sameCount = sameCount;
        this.prize = prize;
        this.matchCase = matchCase;
    }

    public static Rank of(Integer sameCount,Boolean isMatchBonus){
        return Arrays.stream(values())
                .filter(rank -> rank.matchCase.test(sameCount, isMatchBonus))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public Integer getSameCount(){
        return sameCount;
    }
    public Integer getPrize() {
        return prize;
    }
}
