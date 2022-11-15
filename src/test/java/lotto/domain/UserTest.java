package lotto.domain;

import static lotto.utils.message.ErrorMessagesUtil.NOT_DIVIDE;
import static lotto.utils.message.ErrorMessagesUtil.ONLY_NUMBERS;
import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {
    
    @Test
    @DisplayName("로또를 구매할 수 있다.")
    void 로또를_구매할_수_있다() {
        // given
        setInput("1000");
        User user = new User();

        // when
        user.buyLotto();

        // then
        assertThat(user.getBuyAmount()).isEqualTo(1);
    }

    @Test
    @DisplayName("구매 비용이 로또 가격으로 나눠지지 않으면 예외가 발생한다.")
    void 구매_비용이_로또_가격으로_나눠지지_않으면_예외가_발생한다() {
        setInput("1500");

        assertThatThrownBy(() -> new User().buyLotto())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_DIVIDE.getMessage());
    }

    @Test
    @DisplayName("구매 비용에 문자가 입력되면 예외가 발생한다.")
    void 구매_비용에_문자가_입력되면_예외가_발생한다() {
        setInput("1000abc");

        assertThatThrownBy(() -> new User().buyLotto())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ONLY_NUMBERS.getMessage());
    }

    @Test
    @DisplayName("발행한 로또 수량을 알 수 있다.")
    void 발행한_로또_수량을_알_수_있다() {
        // given
        setInput("8000");
        User user = new User();
        user.buyLotto();

        // when
        int result = user.getBuyAmount();

        // then
        assertThat(result).isEqualTo(8);
    }

    private void setInput(String... inputs) {
        final byte[] buf = String.join("\n", inputs).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

}
