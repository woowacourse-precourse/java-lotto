package lotto.entity;

import java.util.ArrayList;
import lotto.data.entity.LottoBundle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 구매에 대해서,")
class LottoBundleTest {
    @DisplayName("적어도 1매는 구매해야 한다.")
    @Test
    void createBundleWithoutContent() {
        assertThatThrownBy(() -> new LottoBundle(0L, 0L, new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
