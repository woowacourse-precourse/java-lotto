package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.Application.*;
import static org.assertj.core.api.Assertions.*;
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
    @DisplayName("입력금액에 문자 포함시 예외 발생")
    @Test
    void 구매금액_문자포함() {
        String input1 = "ds1000";
        String input2 = "12d34";

        assertThatThrownBy(()->validatePurchaseAmountInput(input1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->validatePurchaseAmountInput(input2)).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->validatePurchaseAmountInput(input1)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 숫자만 입력 가능합니다.");
        assertThatThrownBy(()->validatePurchaseAmountInput(input2)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 숫자만 입력 가능합니다.");
    }

    @DisplayName("입력금액이 1000원 단위가 아닐 경우 예외 발생")
    @Test
    void 구매금액_1000원단위_아닌입력() {
        String input1 = "1234";
        String input2 = "12432422211534";
        String input3 = "0";
        String input4 = "999";

        assertThatThrownBy(()->validatePurchaseAmountInput(input1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->validatePurchaseAmountInput(input2)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->validatePurchaseAmountInput(input3)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->validatePurchaseAmountInput(input4)).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->validatePurchaseAmountInput(input1)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 단위로 입력해 주세요.");
        assertThatThrownBy(()->validatePurchaseAmountInput(input2)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 단위로 입력해 주세요.");
        assertThatThrownBy(()->validatePurchaseAmountInput(input3)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 단위로 입력해 주세요.");
        assertThatThrownBy(()->validatePurchaseAmountInput(input4)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 단위로 입력해 주세요.");
    }

    @DisplayName("입력안할 경우 예외 발생")
    @Test
    void 미입력() {
        String input = "";
        assertThatThrownBy(()->validatePurchaseAmountInput(input)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->validatePurchaseAmountInput(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액을 입력해 주세요.");
    }


}
