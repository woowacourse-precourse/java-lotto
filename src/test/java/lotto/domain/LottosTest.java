package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    Lotto lotto1;
    Lotto lotto2;
    Lotto lotto3;

    @DisplayName("로또 생성")
    @BeforeEach
    void setUp() {
        lotto1 = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        lotto2 = Lotto.from(List.of(7, 8, 9, 10, 11, 12));
        lotto3 = Lotto.from(List.of(13, 14, 15, 16, 17, 18));
    }

    @DisplayName("Lottos 생성 테스트")
    @Test
    void createLottos() {
        Lottos lottos = Lottos.of(List.of(lotto1, lotto2, lotto3));
        assertThat(lottos.get()).isEqualTo(List.of(lotto1, lotto2, lotto3));
    }

    @DisplayName("Lottos의 크기가 1보다 작으면 예외가 발생한다.")
    @Test
    public void createLottosByEmpty() {
        assertThatThrownBy(() -> {
            Lottos lottos = Lottos.of(new ArrayList<>());
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("1개 이상의 로또가 포함되어 있어야합니다.");
    }
}
