package lotto;

import lotto.domain.Lotto;
import lotto.presentation.dto.PurchaseAmount;
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

    // 아래에 추가 테스트 작성 가능

    @DisplayName("로또 구매 금액 입력값이 숫자일 경우 예외가 발생한다.")
    @Test
    void inputPurchaseAmountNotInteger() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new PurchaseAmount("12q"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PurchaseAmount("@!#qq"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액 입력값이 1000원 단위가 아닌 경우 예외가 발생한다.")
    @Test
    void inputPurchaseAmountUnmatchedUnit() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new PurchaseAmount("4500"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 구매 금액 입력값이 1000원 미만인 경우 예외가 발생한다.")
    @Test
    void inputPurchaseAmountBelow() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new PurchaseAmount("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매한 로또의 숫자가 1~45 사이의 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void numericalRange() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5,46)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("구매한 로또의 숫자가 6자리가 아닌 경우 예외가 발생한다.")
    @Test
    void numberOfDigit() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
