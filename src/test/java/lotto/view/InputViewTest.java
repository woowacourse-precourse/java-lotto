package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    InputView inputView = new InputView();
    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Nested
    @DisplayName("로또 구입금액을 입력한다. 제약 조건에 맞지 않으면 예외발생를 시킨다.")
    class insertMoney {

        @Test
        @DisplayName("양의 수가 아닐때 예외발생")
        void validateCastPositiveBigInteger() {
            // Given
            String input = "-123123";

            // When
            command(input);

            // Then
            assertThatThrownBy(() -> inputView.insertMoney())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");

        }
        @Test
        @DisplayName("1000이상의 금액이 아닐때 예외발생")
        void validateMinMoney() {
            // Given
            String input = "123";

            // When
            command(input);

            // Then
            assertThatThrownBy(() -> inputView.insertMoney())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
        @Test
        @DisplayName("게임의 단위금액인 1000의 배수가 아닐때 예외발생")
        void validateMultipleOf1000() {
            // Given
            String input = "1230012";
            command(input);

            // When
            command(input);

            // Then
            assertThatThrownBy(() -> inputView.insertMoney())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
    }

}