package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class LottoMachineTest {

    @DisplayName("부적합한 가격을 입력하였을 경우, 상황별 예외메세지를 담은 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1001", "500", "100s", " "})
    void givenPrice_whenIllegalPrice_thenTrowsException(String input) {
        assertThatThrownBy(() -> {
            new LottoMachine(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("적합한 가격을 입력하였을 경우, 합당한 개수의 로또를 발행한다")
    @Test
    void GivenPrice_WhenLegalPrice_ThenGenerateLotto() {
        assertThat(new LottoMachine("5000").getLottoCount()).isEqualTo(5);
    }
}