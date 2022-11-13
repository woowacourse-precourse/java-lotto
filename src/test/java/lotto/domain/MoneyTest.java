package lotto.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MoneyTest {


    @Test
    void 구입_금액은_1000원으로_나누어_떨어져야_한다() {
        //given
        int money = 10000;

        //when then
        assertThatNoException()
                .isThrownBy(() -> new Money(money));
    }

    @Test
    void 구입_금액이_1000원으로_나누어_떨어지지_않는_경우_예외를_발생시킨다() {
        //given
        int money = 1001;

        //when then
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 1000원으로 나누어 떨어져야 합니다.");
    }

    @Test
    void 구입_금액이_0원인_경우_올바른_리턴을_한다() {
        int money = 0;

        //when then
        assertThatNoException()
                .isThrownBy(() -> new Money(money));
    }

    @Test
    void 구입_금액이_음수인_경우_예외를_발생시킨다() {
        //given
        int money = -1000;

        //when then
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 음수일 수 없습니다.");
    }
}