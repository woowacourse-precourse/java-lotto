package lotto;

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

    @DisplayName("로또 구매 금액이 1,000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void enterPurchaseAmountNot1000Units(){
        assertThatThrownBy(() -> new Exception().isDividedByTicketPrice(1234))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액 입력 값에 문자가 포함되어 있는 경우 예외가 발생한다.")
    @Test
    void enterCharacterContainingValue(){
        assertThatThrownBy(() -> new Exception().isContainCharacter("300d0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액이 정상적이지 않을 시 예외가 발생한다.")
    @Test
    void enterAbnormalPurchaseAmount(){
        assertThatThrownBy(() -> new Exception().isCorrectAmount("100d0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
