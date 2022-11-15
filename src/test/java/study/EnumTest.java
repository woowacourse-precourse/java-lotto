package study;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EnumTest {
    @Test
    void enumGetValueIndexByStringTest() {
        assertThat(PrizeRankIndex.getPrizeIndex("FIRST").ordinal())
                .isEqualTo(0);
    }

    @Test
    void enumGetValueIndexByValueTest() {
        assertThat(PrizeRankIndex.getPrizeIndex(PrizeRankIndex.FIRST))
                .isEqualTo(0);
    }

    @Test
    void enumWithHashMapTest() {
        int FIRST_PRIZE_COUNT = 6;
        int THIRD_PRIZE_COUNT = 5;
        int FOURTH_PRIZE_COUNT = 4;
        int FIFTH_PRIZE_COUNT = 3;

        HashMap<Integer, PrizeRankIndex> countMatchingPrizes = new HashMap<>();
        countMatchingPrizes.put(FIRST_PRIZE_COUNT, PrizeRankIndex.FIRST);
        countMatchingPrizes.put(THIRD_PRIZE_COUNT, PrizeRankIndex.SECOND);
        countMatchingPrizes.put(FOURTH_PRIZE_COUNT, PrizeRankIndex.THIRD);
        countMatchingPrizes.put(FIFTH_PRIZE_COUNT, PrizeRankIndex.FOURTH);

        assertThat(countMatchingPrizes.get(6)).isEqualTo(PrizeRankIndex.FIRST);
    }

    @Test
    void enumWithHashMapIndexTest() {
        int FIRST_PRIZE_COUNT = 6;
        int THIRD_PRIZE_COUNT = 5;
        int FOURTH_PRIZE_COUNT = 4;
        int FIFTH_PRIZE_COUNT = 3;

        HashMap<Integer, PrizeRankIndex> countMatchingPrizes = new HashMap<>();
        countMatchingPrizes.put(FIRST_PRIZE_COUNT, PrizeRankIndex.FIRST);
        countMatchingPrizes.put(THIRD_PRIZE_COUNT, PrizeRankIndex.SECOND);
        countMatchingPrizes.put(FOURTH_PRIZE_COUNT, PrizeRankIndex.THIRD);
        countMatchingPrizes.put(FIFTH_PRIZE_COUNT, PrizeRankIndex.FOURTH);

        assertThat(countMatchingPrizes.get(6).ordinal()).isEqualTo(0);
    }
}

enum PrizeRankIndex {
    FIRST(0),
    SECOND(1),
    THIRD(2),
    FOURTH(3),
    FIFTH(4);

    private final int ranks;

    PrizeRankIndex(int ranks) {
        this.ranks = ranks;
    }

    public static PrizeRankIndex getPrizeIndex(String prizeRank) {
        return PrizeRankIndex.valueOf(prizeRank);
    }

    public static int getPrizeIndex(PrizeRankIndex prizeRank) {
        return prizeRank.ordinal();
    }
}
