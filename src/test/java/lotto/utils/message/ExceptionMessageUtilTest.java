package lotto.utils.message;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ExceptionMessageUtilTest {

    @Nested
    @DisplayName("findFullMessage 메소드는")
    class DescribeFindFullMessageMethodTest {

        @Nested
        @DisplayName("만약 상수가 하나인 예외 메세지를 호출하면")
        class ContextWithConstTest {

            @ParameterizedTest
            @CsvSource(
                    value = {
                        "WRONG_NUMBER_SIZE:6",
                        "WRONG_PURCHASE_AMOUNT_UNIT:1000",
                        "WRONG_PURCHASE_AMOUNT_VALUE:1000",
                        "WRONG_SEPARATOR:,"
                    },
                    delimiter = ':'
            )
            @DisplayName("상수가 적용된 예외 메세지를 반환한다")
            void it_returns_exception_message(ExceptionMessageUtil util, String expectedConst) {
                String actual = util.findFullMessage();

                assertThat(actual).contains(expectedConst);
            }
        }

        @Nested
        @DisplayName("만약 상수가 두개인 예외 메세지를 호출하면")
        class ContextWithConstsTest {

            @Test
            @DisplayName("상수가 적용된 예외 메세지를 반환한다")
            void it_returns_exception_message() {
                String actual = ExceptionMessageUtil.WRONG_NUMBER_RANGE.findFullMessage();

                assertThat(actual)
                        .contains("1")
                        .contains("45");
            }
        }

        @Nested
        @DisplayName("만약 상수가 존재하지 않는 예외 메세지를 호출하면")
        class ContextWithoutConstTest {

            @ParameterizedTest
            @CsvSource(
                    value = {
                        "WRONG_NUMBER_FORMAT:입력한 값을 숫자로 치환할 수 없습니다.",
                        "WRONG_NUMBER_LENGTH:유효하지 않은 길이입니다.",
                        "WRONG_RANKING:존재하지 않는 등수입니다.",
                        "WRONG_BONUS_NUMBER:당첨 번호와 보너스 번호는 중복될 수 없습니다."
                    },
                    delimiter = ':'
            )
            @DisplayName("예외 메세지를 반환한다")
            void it_returns_exception_message(ExceptionMessageUtil util, String expected) {
                String actual = util.findFullMessage();

                assertThat(actual).contains(expected);
            }
        }
    }
}