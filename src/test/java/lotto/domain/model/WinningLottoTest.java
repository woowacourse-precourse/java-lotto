package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Winning Lotto 모델 생성 테스트")
public class WinningLottoTest {

    @DisplayName("당첨 번호 개수가 6개가 아닐 경우 예외가 발생한다.")
    @Test
    void createWinningLottoWithNotSixNumbers() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningLottoWithDuplicatedNumbers() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 3, 4, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 1~45 범위에서 벗어난 숫자가 있을 경우 예외가 발생한다.")
    @Test
    void createWinningLottoWithOutOfRangeNumbers() {
        assertThatThrownBy(() -> new WinningLotto(List.of(0, 1, 2, 3, 4, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 46), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 범위에서 벗어날 경우 예외가 발생한다.")
    @Test
    void createWinningLottoWithOutOfRangeBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
