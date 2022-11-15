package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatingLottoTest {
    CalculatingLotto calculatingLotto = new CalculatingLotto();



    @Test
    void findSameNumberTest() {
        assertThat(calculatingLotto.findSameNumber(6,6)).isEqualTo(1);

        assertThat(calculatingLotto.findSameNumber(5,6)).isEqualTo(0);
    }

    @Test
    void checkBonusTest() {
        assertThat(calculatingLotto.checkBonus(6, List.of(1, 2, 3, 4, 5, 6))).isEqualTo(true);

        assertThat(calculatingLotto.checkBonus(6, List.of(1, 2, 3, 4, 5, 8))).isEqualTo(false);
    }
}