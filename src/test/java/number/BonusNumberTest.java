package number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
class BonusNumberTest {
    @DisplayName("보너스 번호가 1부터 45사이가 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberByOutOfRange() {
        assertThatThrownBy(() -> new BonusNumber(70))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
