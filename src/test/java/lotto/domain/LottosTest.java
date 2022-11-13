package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottosTest {
    @DisplayName("로또들을 생성할 때 null 을 입력하면 IEA 예외")
    @Test
    void case1() {
        assertThrows(IllegalArgumentException.class, () -> new Lottos(null));
    }

    @DisplayName("getLottos 메서드는 전달 시에 불변 리스트를 반환한다")
    @Test
    void case2() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(new ArrayList<>(List.of(lotto)));

        assertThrows(UnsupportedOperationException.class, () -> {
            lottos.getLottos().add(lotto);
        });
    }
}
