package lotto.domain;

import java.util.*;

public enum LottoRank {
    RANK_5(3, false, 5000, "3개 일치 (5,000원)"),
    RANK_4(4, false, 50000, "4개 일치 (50,000원)"),
    RANK_3(5, false, 1500000, "5개 일치 (1,500,000원)"),
    RANK_2(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    RANK_1(6, false, 2000000000, "6개 일치 (2,000,000,000원)");

    public final int CORRECT_COUNT_CONDITION; // 해당 등수에서 필요한 당첨 번호 개수
    public final boolean IS_BONUS_NEEDED; // 보너스 번호도 맞아야 하는지
    public final long PRIZE_MONEY; // 해당 등수에서의 상금
    public final String PRIZE_DESCRIPTION; // 해당 등수에 대한 서술

    LottoRank(int correctCountCondition, boolean isBonusNeeded, long prizeMoney, String prizeDescription) {
        this.CORRECT_COUNT_CONDITION = correctCountCondition;
        this.IS_BONUS_NEEDED = isBonusNeeded;
        this.PRIZE_MONEY = prizeMoney;
        this.PRIZE_DESCRIPTION = prizeDescription;
    }

    public static List<LottoRank> getSortedValues() {
        List<LottoRank> sortedLottoRank = new ArrayList<>(Arrays.asList(LottoRank.values()));

        sortedLottoRank.sort(Comparator.comparingLong(rank -> rank.PRIZE_MONEY));
        Collections.reverse(sortedLottoRank);

        return sortedLottoRank;
    }
}
