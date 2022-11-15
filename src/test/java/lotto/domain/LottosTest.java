package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {
    @DisplayName("로또 구매 개수만큼 로또 객체를 생성하고 Lottos로 감싼다.")
    @Test
    void checkCreateLottos() {
        assertThatCode(() -> new Lottos(10))
                .doesNotThrowAnyException();
    }
}