package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

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

    @Nested
    @DisplayName("당첨 번호를 입력한다. 제약 조건에 맞지 않으면 예외발생를 시킨다.")
    class inputWinningNumbers {

        @Test
        @DisplayName("comma로 구분되어있지 않으면 예외발생")
        void validateCommaSplit() {
            // Given
            String input = "123456";

            // When
            command(input);

            // Then
            assertThatThrownBy(() -> inputView.inputWinningNumbers())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
        @Test
        @DisplayName("중복값을 입력하면 예외발생")
        void validateDuplicateNumber() {
            // Given
            String input = "1,2,2,3,4,5";

            // When
            command(input);

            // Then
            assertThatThrownBy(() -> inputView.inputWinningNumbers())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }

        @Test
        @DisplayName("숫자가 아닐때 예외발생")
        void validateCastInteger() {
            // Given
            String input = "1,이,2,3,4,오";

            // When
            command(input);

            // Then
            assertThatThrownBy(() -> inputView.inputWinningNumbers())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");

        }
        @Test
        @DisplayName("1~45 범위가 아닐때 예외발생")
        void validateRange() {
            // Given
            String input = "1,2,3,4,5,88";

            // When
            command(input);

            // Then
            assertThatThrownBy(() -> inputView.inputWinningNumbers())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");

        }
    }

    @Nested
    @DisplayName("보너스 번호를 입력한다. 제약 조건에 맞지 않으면 예외발생를 시킨다.")
    class inputBonusNumber {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        @Test
        @DisplayName("숫자가 아닐때 예외발생")
        void validateCastInteger() {
            // Given
            String input = "ㅋ";

            // When
            command(input);

            // Then
            assertThatThrownBy(() -> inputView.inputBonusNumber(winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
        @Test
        @DisplayName("1~45 범위가 아닐때 예외발생")
        void validateRange() {
            // Given
            String input = "88";

            // When
            command(input);

            // Then
            assertThatThrownBy(() -> inputView.inputBonusNumber(winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
        @Test
        @DisplayName("당첨 번호에 존재하는 값을 보너스 번호로 입력하면 예외발생")
        void validateNotContainWinningNumbers() {
            // Given
            String input = "1";

            // When
            command(input);

            // Then
            assertThatThrownBy(() -> inputView.inputBonusNumber(winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
    }

}