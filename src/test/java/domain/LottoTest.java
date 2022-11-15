package domain;

import domain.Lotto.Lotto;
import domain.Lotto.LottoController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    LottoController lottoController = new LottoController();

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 6개의 숫자여야 합니다.");
    }

    @DisplayName("당첨 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange1() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 46, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("당첨 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange2() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 0, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호 가운데 중복된 숫자가 없어야 합니다.");
    }

    @DisplayName("당첨 번호를 쉼표로 구분하여 입력하지 않으면 예외가 발생한다.")
    @Test
    void createLottoByWithoutComma1() {
        assertThatThrownBy(() -> lottoController.createLotto("1.2.3.4.5.6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 공백 없이 쉼표로 구분된 6개의 숫자여야 합니다.");
    }

    @DisplayName("당첨 번호를 쉼표로 구분하여 입력하지 않으면 예외가 발생한다.")
    @Test
    void createLottoByWithoutComma2() {
        assertThatThrownBy(() -> lottoController.createLotto("1, 2, 3, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 공백 없이 쉼표로 구분된 6개의 숫자여야 합니다.");
    }
}