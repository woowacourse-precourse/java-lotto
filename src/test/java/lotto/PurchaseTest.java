package lotto;

import lotto.domain.Purchase;
import lotto.domain.Winning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseTest {

    @DisplayName("입력금액에 문자 포함시 예외 발생")
    @Test
    void includeCharacter() {
        String input1 = "ds1000";
        assertThatThrownBy(()->new Purchase(input1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->new Purchase(input1)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 숫자만 입력 가능합니다.");

        String input2 = "12d34";
        assertThatThrownBy(()->new Purchase(input2)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->new Purchase(input2)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 숫자만 입력 가능합니다.");
    }

    @DisplayName("입력금액이 1000원 단위가 아닐 경우 예외 발생")
    @Test
    void invalidUnit() {
        Winning winning = new Winning();

        String input1 = "1234";
        assertThatThrownBy(()->new Purchase(input1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->new Purchase(input1)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 단위로 입력해 주세요.");

        String input2 = "12432422211534";
        assertThatThrownBy(()->new Purchase(input2)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->new Purchase(input2)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 단위로 입력해 주세요.");

        String input3 = "0";
        assertThatThrownBy(()->new Purchase(input3)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->new Purchase(input3)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 단위로 입력해 주세요.");

        String input4 = "999";
        assertThatThrownBy(()->new Purchase(input4)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->new Purchase(input4)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 단위로 입력해 주세요.");
    }

    @DisplayName("입력안할 경우 예외 발생")
    @Test
    void blankInput() {
        String input = "";
        assertThatThrownBy(()->new Purchase(input)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->new Purchase(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액을 입력해 주세요.");
    }
}
