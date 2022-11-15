package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosGeneratorTest {

    @DisplayName("로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행 한다.")
    @Test
    void createLottos() {
        Lottos lottos = LottosGenerator.generate(new Money(3_000));
        Assertions.assertThat(lottos.getLottos()).hasSize(3);
    }
}
