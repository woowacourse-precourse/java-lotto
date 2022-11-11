package lotto;

import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    @DisplayName("로또 리스트 사이즈가 1 미만일 때 예외")
    void validList() {
        Assertions.assertThatThrownBy(() -> new Lottos(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
