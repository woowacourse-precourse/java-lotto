package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrizeTest {
    @DisplayName("3개 일치할 경우 5000원을 불러온다.")
    @Test
    void isRightPrize() {
        int award = Prize.THREE.getPrize();
        Assertions.assertThat(award).isEqualTo(5000);
    }

}