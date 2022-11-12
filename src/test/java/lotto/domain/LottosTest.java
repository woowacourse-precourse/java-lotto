package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void create() {
        Lottos actual = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));

        assertThat(actual).isEqualTo(new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)))));
    }
}
