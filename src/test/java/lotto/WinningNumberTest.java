package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {

    @DisplayName("당첨 번호 입력 개수가 6개를 넘어서면 예외가 발생한다.")
    @Test
    void 당첨번호입력_개수_테스트() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력 범위가 1~45 사이가 아니라면 예외가 발생한다.")
    @Test
    void 당첨번호입력_범위_테스트() {
        assertThatThrownBy(() -> new WinningNumber(List.of(-1, 2, 46, 4, 5, 50), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력에서 중복된 숫자가 있다면 예외가 발생한다.")
    @Test
    void 당첨번호입력_중복_테스트() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 5), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 범위가 1~45 사이가 아니라면 예외가 발생한다.")
    @Test
    void 보너스번호입력_범위_테스트() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력에서 당첨번호와 중복된 숫자가 있다면 예외가 발생한다.")
    @Test
    void 보너스번호입력_중복_테스트() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
