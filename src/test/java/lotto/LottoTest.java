package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @DisplayName("로또 번호 1과 45사이의 범위를 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByNumberRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, -2, 3, 4, 5, 6, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("구매 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void inputBuyMoneyByNot1000Multi() {
        final Application application = new Application();
        final int money = 1100;
        final RuntimeException exception = assertThrows(RuntimeException.class, ()-> Application.checkPayMoney(money));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 1000원 단위의 금액만 가능합니다.");
    }
}
