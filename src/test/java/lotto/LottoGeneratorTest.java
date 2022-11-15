package lotto;

import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGeneratorTest {

    @DisplayName("로또 생성기에 1000원 단위의 돈을 투입하지 않으면 예외가 발생한다.")
    @Test
    void inputLottoGeneratorNotCorrectUnit() {
        assertThatThrownBy(() -> new LottoGenerator(11111))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 생성기에 음수를 투입하지 않으면 예외가 발생한다.")
    @Test
    void inputNegativeLottoGenerator() {
        assertThatThrownBy(() -> new LottoGenerator(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
