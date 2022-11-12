package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1부터 45까지의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByWrongRange() {
        Utils utils = new Utils();
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 55)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void createLottoByNotNumber() {
        Utils utils = new Utils();
        assertThatThrownBy(() -> utils.validateInputNumbers("1, 2, 3, 4, 5, T"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 구입금액이 1,000원 단위가 아닌 경우 예외가 발생한다.")
    @Test
    void inputMoneyWrongUnit() {
        Utils utils = new Utils();
        assertThatThrownBy(() -> utils.validateMoney("500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 구입금액이 0원 이하인 경우 예외가 발생한다.")
    @Test
    void inputMoneyUnder0() {
        Utils utils = new Utils();
        assertThatThrownBy(() -> utils.validateMoney("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 구입금액이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void inputMoneyNotDigit() {
        Utils utils = new Utils();
        assertThatThrownBy(() -> utils.validateMoney("5000d"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}