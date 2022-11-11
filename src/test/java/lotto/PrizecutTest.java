package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PrizecutTest {

    @Test
    void enumTest() {
        Prizecut[] values = Prizecut.values();
        for (Prizecut value : values) {
            System.out.println(value + "\t" + value.getPrizeMoney());
        }

        assertThat(values).contains(Prizecut.FIRST, Prizecut.SECOND, Prizecut.THIRD, Prizecut.FOURTH, Prizecut.FIFTH);

        assertThat(Prizecut.THIRD.getPrizeMoney()).isEqualTo("1,500,000원");
    }
}