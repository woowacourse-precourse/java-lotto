package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UtilsTest {
    @DisplayName("로또 번호가 1 ~ 45 범위를 넘으면 false")
    @Test
    void 로또_번호_유효_범위_넘으면_false() {
        List<Integer> numbers = List.of(1, 2, 3, 48, 5, 6);
        assertThat(Utils.validateLottoNumbers(numbers)).isFalse();
    }
}