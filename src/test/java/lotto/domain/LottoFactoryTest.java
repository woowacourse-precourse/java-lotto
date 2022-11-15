package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoFactoryTest {
    @Test
    void 예외_테스트() {

        assertThatThrownBy(() -> LottoFactory.makeLottos(8500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid Argument");
    }

    @Test
    void 정상_개수_생성_테스트() {
        Lottos lottos = LottoFactory.makeLottos(6000);
        assertThat(lottos.getSize())
                .isEqualTo(6);
    }
}