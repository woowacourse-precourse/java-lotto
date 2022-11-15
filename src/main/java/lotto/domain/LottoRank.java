package lotto.domain;

import org.assertj.core.groups.Tuple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.util.ConstValue.LottoConst.*;

public enum LottoRank {

    WIN_1ST(1, PRIZE_MONEY_1ST, String.format("6개 일치 (%,d원)", PRIZE_MONEY_1ST)),
    WIN_2ND(2, PRIZE_MONEY_2ND, String.format("5개 일치, 보너스 볼 일치 (%,d원)", PRIZE_MONEY_2ND)),
    WIN_3RD(3, PRIZE_MONEY_3RD, String.format("5개 일치 (%,d원)", PRIZE_MONEY_3RD)),
    WIN_4TH(4, PRIZE_MONEY_4TH, String.format("4개 일치 (%,d원)", PRIZE_MONEY_4TH)),
    WIN_5TH(5, PRIZE_MONEY_5TH, String.format("3개 일치 (%,d원)", PRIZE_MONEY_5TH)),
    ;

    private final int ranking;
    private final long prizeMoney;
    private final String message;
    private final static Map<Tuple, LottoRank> rankMatcher = new HashMap<>();

    static {
        rankMatcher.put(new Tuple(3), WIN_5TH);
        rankMatcher.put(new Tuple(4), WIN_4TH);
        rankMatcher.put(new Tuple(5), WIN_3RD);
        rankMatcher.put(new Tuple(5, true), WIN_2ND);
        rankMatcher.put(new Tuple(6), WIN_1ST);
    }

    LottoRank(final int ranking, final long prizeMoney, final String message) {
        this.ranking = ranking;
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public static LottoRank getLottoRank(final Tuple key) {
        final List<Object> keys = key.toList();
        if (is2ndRank(keys)) {
            return rankMatcher.get(key);
        }
        return rankMatcher.get(new Tuple(keys.get(0)));
    }

    private static boolean is2ndRank(final List<Object> keys) {
        return keys.contains(5) && keys.contains(true);
    }
}
