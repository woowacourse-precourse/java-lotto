package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PrizeDetailsTest {

    private static final PrizeDetails notting = PrizeDetails.NOT_THING;

    @Test
    void getPrice() {
        assertThat(notting.getPrice()).isEqualTo(0);
    }

    @Test
    void hasNextTrue() {
        assertThat(notting.hasNext()).isTrue();
    }

    @Test
    void hasNextFalse() {
        assertThat(PrizeDetails.SIX_PRIZE.hasNext()).isFalse();
    }

    @Test
    void next() {
        assertThat(notting.next()).isEqualTo(PrizeDetails.ONE_PRIZE);
    }
}