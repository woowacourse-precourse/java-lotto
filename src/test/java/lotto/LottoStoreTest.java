package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoStoreByOverSize() {
        assertThatThrownBy(() -> new LottoStore(new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoStoreByDuplicatedNumber() {
        assertThatThrownBy(() -> new LottoStore(new Lotto(List.of(1, 2, 3, 4, 5, 5)), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoStoreByOverRange() {
        assertThatThrownBy(() -> new LottoStore(new Lotto(List.of(1, 2, 3, 4, 5, 6, 47)), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호에 포함되면 예외가 발생한다.")
    @Test
    void createLottoBySameBonusNumber() {
        assertThatThrownBy(() -> new LottoStore(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createBonusNumberByOverSize() {
        assertThatThrownBy(() -> new LottoStore(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
