package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @DisplayName("로또 구입 개수가 주엊면 로또가 발급된다.")
    @Test
    void 로또_구입개수에_따라_로또가_발급되는데_성공한다() {
        // given

        // when
        Lottos lottos = new Lottos(10);

        // then
        assertThat(lottos.getLottos()).hasSize(10);
    }
}