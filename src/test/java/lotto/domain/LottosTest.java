package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottosTest {
    @DisplayName("로또들을 생성할 때 null 을 입력하면 IEA 예외")
    @Test
    void Lottos_생성자_null_예외() {
        assertThrows(IllegalArgumentException.class, () -> new Lottos(null));
    }
}
