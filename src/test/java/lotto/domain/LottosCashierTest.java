package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosCashierTest {

    @DisplayName("10000원이 주어졌을 때 살수있는 로또의 개수는 10개")
    @Test
    void canByLottoCount() {
        int count = LottosCashier.calculateLottoCount(10000);
        assertThat(count).isEqualTo(10);
    }

    @DisplayName("구임 금액이 1000으로 나누어 떨어지지 않으면 예외 발생")
    @Test
    void validatePrice() {
        assertThatThrownBy(() -> LottosCashier.calculateLottoCount(1350))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.");
    }

    @DisplayName("주어진 금액 많큼 로또를 발행하는 기능")
    @Test
    void buyLottos() {
        Lottos createLottos = LottosCashier.create(3000, createLottoNumbers());

        assertThat(createLottos.size()).isEqualTo(3);
    }

    private List<List<Integer>> createLottoNumbers() {
        return List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 8)
        );
    }

    @DisplayName("주어진 금액으로 살 수 있는 로또 개수와 로또 넘버의 개수가 같이 않는 경우 예외 발생")
    @Test
    void buyLottosDifferentSize() {
        assertThatThrownBy(() -> LottosCashier.create(4000, createLottoNumbers()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 주어진 금액과 주어진 로또 번호의 개수가 일치하지 않습니다.");
    }
}