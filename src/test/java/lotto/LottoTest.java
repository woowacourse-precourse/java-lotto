package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.controller.LottoController;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 오름차순으로 정렬되어있지 않으면 예외가 발생한다.")
    @Test
    void createByNotSortedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 6, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복없는 6개의 번호를 가진 8개의 로또를 생성한다.")
    @Test
    void createLotteriesByZeroSize() {
        LottoController controller = new LottoController();
        List<Lotto> lotteries = controller.createLotteries(8);
        assertThat(lotteries)
            .hasSize(8)
            .allMatch(lotto -> lotto.getNumbers().size() == 6)
            .doesNotHaveDuplicates();
    }

    @DisplayName("0개 로또 생성을 시도하여 예외가 발생한다.")
    @Test
    void createLotteriesByEightSize() {
        LottoController controller = new LottoController();
        assertThatThrownBy(() -> {
            new Lotto(List.of(1, 2, 3, 4, 5, 6));
            controller.createLotteries(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
