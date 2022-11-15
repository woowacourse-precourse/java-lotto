package lotto.domain;

import static lotto.utils.message.ErrorMessagesUtil.NOT_DIVIDE;
import static lotto.utils.message.ErrorMessagesUtil.ONLY_NUMBERS;
import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("구매 비용이 로또 가격 단위가 아니라면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1500", "1000aaa"})
    void 구매_비용이_로또_가격_단위가_아니라면_예외가_발생한다(String input) {
        setInput(input);

        assertThatThrownBy(() -> new User().buyLotto())
                .isInstanceOf(IllegalArgumentException.class);
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
