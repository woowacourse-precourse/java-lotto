package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @Test
    void 입력받은_문자열이_숫자인지1() {
        Money money = new Money("2000");
        assertThat(2000).isEqualTo(money.getMoney());
    }

    @Test
    void 입력받은_문자열이_숫자인지2() {
        assertThatThrownBy(() -> new Money("A2000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액에는 숫자만 입력해야 합니다.");
    }

    @Test
    void 금액이_단위가_맞는지1() {
        Money money = new Money("2000");
        assertThat(2000 % Money.MONEY_DIVIDE_UNIT).isEqualTo(0);
    }

    @Test
    void 금액이_단위가_맞는지2() {
        assertThatThrownBy(() -> new Money("2500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 단위만 입력해야 합니다.");
    }

    @Test
    void 금액이_단위가_맞는지3() {
        assertThatThrownBy(() -> new Money("500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원보다 커야합니다.");
    }

    @Test
    void 발행할_로또의_개수가_맞는지() {
        Money money = new Money("8000");
        assertThat(money.getTicketCount()).isEqualTo(8);
    }
}