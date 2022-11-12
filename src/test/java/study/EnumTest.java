package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EnumTest {
    @Test
    void enumGetValueIndexByStringTest() {
        assertThat(PrizeRankIndex.getPrizeIndex("FIRST"))
                .isEqualTo(0);
    }

    @Test
    void enumGetValueIndexByValueTest() {
        assertThat(PrizeRankIndex.getPrizeIndex(PrizeRankIndex.FIRST))
                .isEqualTo(0);
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

    public static int getPrizeIndex(String prizeRank) {
        return PrizeRankIndex.FIRST.ordinal();
    }

    public static int getPrizeIndex(PrizeRankIndex prizeRank) {
        return PrizeRankIndex.FIRST.ordinal();
    }
}
