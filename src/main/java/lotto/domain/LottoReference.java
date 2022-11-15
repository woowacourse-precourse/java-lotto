package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoReference {
    FIFTH(5,"3개 일치", "(5,000원)", 5000),
    FOURTH(4,"4개 일치", "(50,000원)", 50000),
    THIRD(3,"5개 일치", "(1,500,000원)", 1500000),
    SECOND(2,"5개 일치, 보너스 볼 일치", "(30,000,000원)", 30000000),
    FIRST(1,"6개 일치", "(2,000,000,000원)", 2000000000)
    ;

    private static final Map<Integer, LottoReference> rankCashing = new HashMap<>();
    static {
        for (LottoReference rankPlace : values()) {
            rankCashing.put(rankPlace.rank, rankPlace);
        }
    }
    private final int rank;
    private final String matching;
    private final String prizeRefer;
    private final int prizeMoney;

    LottoReference(int rank, String matching, String prizeRefer, int prizeMoney) {
        this.rank = rank;
        this.matching = matching;
        this.prizeRefer = prizeRefer;
        this.prizeMoney = prizeMoney;
    }

    public static LottoReference getRankByMatchCount(final int matchCount) {
        if(!rankCashing.containsKey(matchCount)){
            throw new IllegalArgumentException("[Error]: 잘못된 등수를 조회했습니다");
        }
        return rankCashing.get(matchCount);
    }

    public String getMatching() {
        return matching;
    }
    public String getPrizeRefer() {
        return prizeRefer;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getWinInformation() {
        return getMatching() + " " + getPrizeRefer();
    }
}
