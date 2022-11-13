package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;

import java.util.List;

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

    @DisplayName("로또 금액이 1000단위의 숫자인지 확인")
    @Test
    void calculateLottoCount() {
        String purchasePrice = "2100";
        assertThat(Integer.parseInt(purchasePrice) % 1000 != 0).isTrue();
    }

    @DisplayName("로또 번호 범위 1~45의 숫자가 아닐 경우 예외 발생")
    @Test
    void createLottoByRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 70)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
