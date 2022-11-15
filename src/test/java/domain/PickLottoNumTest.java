package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PickLottoNumTest {
    @DisplayName("로또 번호가 숫자가 아닌 경우 예외 발생.")
    @Test
    void checkLottoDigit() {
        assertThatThrownBy(() -> new PickLottoNum("1,2,a,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
