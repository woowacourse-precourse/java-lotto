package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatingLottoTest {
    CalculatingLotto calculatingLotto = new CalculatingLotto();
    @Test
    void findSameNumberTest() {
        assertThat(calculatingLotto.findSameNumber(6,6)).isEqualTo(1);

        assertThat(calculatingLotto.findSameNumber(5,6)).isEqualTo(0);
    }
}