package lotto.domain;

import lotto.enumeration.NumberType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PrizeNumberTest {

    @Test
    void isNormal() {
        PrizeNumber prizeNumber = new PrizeNumber(40, NumberType.NORMAL);

        assertThat(prizeNumber.isNormal()).isTrue();
    }

    @Test
    void isBonus() {
        PrizeNumber prizeNumber = new PrizeNumber(40, NumberType.BOUNS);

        assertThat(prizeNumber.isBonus()).isTrue();
    }
}