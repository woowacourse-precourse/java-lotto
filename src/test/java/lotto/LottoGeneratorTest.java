package lotto;

import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGeneratorTest {

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void inputLottoGeneratorNotCorrectUnit() {
        assertThatThrownBy(() -> new LottoGenerator(11111))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
