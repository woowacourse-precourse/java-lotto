package lotto;

import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Purchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusTest {
    @DisplayName("숫자를 여러 개 입력한 경우 예외가 발생한다.")
    @Test
    void 숫자를_여러_개_입력한_경우() {
        assertThatThrownBy(() -> new Bonus("1200 12", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 보너스_번호가_범위를_벗어난_경우() {
        assertThatThrownBy(() -> new Bonus("55", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호와 중복될 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_로또_번호와_중복된_경우() {
        assertThatThrownBy(() -> new Bonus("5", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
