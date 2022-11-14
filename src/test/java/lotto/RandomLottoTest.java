package lotto;

import lotto.domain.RandomLotto;
import lotto.domain.RandomLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class RandomLottoTest {
    @DisplayName("1000원으로 나누어떨어지는가")
    @Test
    void isDivBy1000() {
        assertThatThrownBy(() -> new RandomLotto(new RandomLottoGenerator()).makeRandomLottos(8700))
                .isInstanceOf(IllegalArgumentException.class);
    }
}