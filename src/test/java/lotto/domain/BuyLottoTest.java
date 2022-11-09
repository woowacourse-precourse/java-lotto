package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class BuyLottoTest {
    @ParameterizedTest
    @ValueSource(strings = {"english", "한글", "--", "12ㅋz!"})
    @NullAndEmptySource
    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    void isNumber_InvalidNumber_ExceptionThrown(String input) {
        assertThatThrownBy(() -> new BuyLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}