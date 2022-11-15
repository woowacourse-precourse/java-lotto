package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.Util.Converter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;



class ConverterTest {
    @DisplayName("예외 처리 테스트")
    @Nested
    class ExceptionTest {
        @DisplayName("입력한 당첨번호에 ','와 숫자가 아닌 문자가 존재하면 예외를 던진다.")
        @ParameterizedTest
        @ValueSource(strings = {"1, 3, 2, 4, 5, 7;", "1, 2, 3, 4 + 5 , 6, 7"})
        void inputNumbersByInvalidSeparator(String input) {
            assertThatThrownBy(() -> Converter.convertToIntegerList(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("사용자가 올바르지 않은 money를 넣을 시 예외를 던진다")
        @ParameterizedTest
        @ValueSource(strings = {"1,000", "1_000", "30,000"})
        void inputMoneyByInvalidForm(String input) {
            assertThatThrownBy(() -> Converter.convertToInteger(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("사용자가 숫자가 아닌 보너스 숫자를 넣을 시 예외를 던진다")
        @ParameterizedTest
        @ValueSource(strings = {"일", "삼", "육", "seven"})
        void inputBonusNumberByInvalidForm(String input) {
            assertThatThrownBy(() -> Converter.convertToInteger(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("올바른 숫자 변환 테스트")
    @Nested
    class ConvertTest {
        @DisplayName("돈 입력")
        @ParameterizedTest
        @ValueSource(strings = {"1000", "3000", "4000", "4050"})
        void inputMoneyConvert(String input) {
            assertThat(Converter.convertToInteger(input))
                    .isEqualTo(Integer.parseInt(input));
        }

        @DisplayName("로또 번호 입력")
        @Test
        void inputLottoNumbersConvert() {
            String input = "1,3,2,6,4,5";

            assertThat(Converter.convertToIntegerList(input))
                    .isEqualTo(List.of(1, 3, 2, 6, 4, 5));
        }
    }
}
