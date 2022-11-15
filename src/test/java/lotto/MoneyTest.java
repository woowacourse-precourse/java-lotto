package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
class MoneyTest {

    @Test
    void 구입금액이_숫자아니면_에러발생() {
        //given
        String frontCharacterMoney = "A123000";
        String middleCharacterMoney = "123H000";
        String lastCharacterMoney = "123000J";

        //when, then
        assertThatThrownBy(() -> new Money(frontCharacterMoney))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 구입금액은 숫자로만 입력해야 합니다.");
        assertThatThrownBy(() -> new Money(middleCharacterMoney))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 구입금액은 숫자로만 입력해야 합니다.");
        assertThatThrownBy(() -> new Money(lastCharacterMoney))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 구입금액은 숫자로만 입력해야 합니다.");
    }

    @Test
    void 콤마를_넣으면_에러발생() {
        //때로는 1,000 이라고 입력할 수도 있다.
        //given
        String moneyWithComma = "2,000";

        //when, then
        assertThatThrownBy(() -> new Money(moneyWithComma))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 구입금액은 숫자로만 입력해야 합니다.");
    }

    @Test
    void 로또구입금액_단위로_입력하지않으면_에러발생() {
        //given
        String inputMoney = "12321";

        //when, then
        assertThatThrownBy(() -> new Money(inputMoney))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 구입금액은 1000원 단위여야만 합니다.");
    }

    @Test
    void 로또구입금액_단위로_입력() {
        //given
        String inputMoney = "123000";

        //when
        Money money = new Money(inputMoney);

        //then
        assertThat(money.getMoney()).isEqualTo(123000);
    }
}