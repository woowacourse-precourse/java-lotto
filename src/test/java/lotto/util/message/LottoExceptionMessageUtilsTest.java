package lotto.util.message;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoExceptionMessageUtilsTest {

    @Nested
    @DisplayName("findExceptionMessage 메소드는")
    class FindExceptionMessageMethodTest {

        private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR]";
        private static final String NUMBER_SEPARATOR = ",";

        @ParameterizedTest
        @ValueSource(strings = {"a,2,3,4,5,6", " ,2,3,4,5,6", " 1 2,3,4,5,6", "@,2,3,4,5,6"})
        @DisplayName("만약 입력 값을 숫자로 치환할 수 없다면 입력 값을 포함한 예외 메세지를 반환한다.")
        void invalid_number_format_exception_message_test(String invalidInput) {
            String messageTarget = invalidInput.split(NUMBER_SEPARATOR)[0];

            String message = LottoExceptionMessageUtils.INVALID_NUMBER_FORMAT.findExceptionMessage(messageTarget);

            assertThat(message)
                    .contains(EXCEPTION_MESSAGE_PREFIX)
                    .contains(messageTarget);
        }

        @ParameterizedTest
        @ValueSource(strings = {"0,1,2,3,4,5", "1,2,3,4,5,46"})
        @DisplayName("만약 입력 값의 범위가 유효하지 않다면 입력 값을 포함한 예외 메세지를 반환한다.")
        void invalid_number_range_exception_message_test(String invalidInput) {
            String message = LottoExceptionMessageUtils.INVALID_NUMBER_RANGE.findExceptionMessage(invalidInput);

            assertThat(message)
                    .contains(EXCEPTION_MESSAGE_PREFIX)
                    .contains(invalidInput);
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 4, 5, 7, 8})
        @DisplayName("만약 입력 값의 유효한 숫자가 6개가 아니라면 유효 숫자 개수를 포함한 예외 메세지를 반환한다.")
        void invalid_number_count_exception_message_test(int invalidInput) {
            String message = LottoExceptionMessageUtils.INVALID_NUMBER_SIZE.findExceptionMessage(invalidInput);

            assertThat(message)
                    .contains(EXCEPTION_MESSAGE_PREFIX)
                    .contains(String.valueOf(invalidInput));
        }

        @ParameterizedTest
        @ValueSource(strings = {"1001", "15600", "300", "4500"})
        @DisplayName("만약 입력한 금액이 1000원 단위가 아니라면 입력한 금액을 포함한 예외 메세지를 반환한다.")
        void invalid_purchase_amount_unit_exception_message_test(String invalidInput) {
            String message = LottoExceptionMessageUtils.INVALID_PURCHASE_AMOUNT_UNIT.findExceptionMessage(invalidInput);

            assertThat(message)
                    .contains(EXCEPTION_MESSAGE_PREFIX)
                    .contains(invalidInput);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1:2:3:4:5:6", "1213141516", "1.2.3.4.5.6", "1@2@3@4@5@6"})
        @DisplayName("만약 입력 값의 적합한 구분자인 쉼표가 포함되지 않았다면 입력 값을 포함한 예외 메세지를 반환한다.")
        void invalid_input_number_separator_exception_message_test(String invalidInput) {
            String message = LottoExceptionMessageUtils.INVALID_SEPARATOR.findExceptionMessage(invalidInput);

            assertThat(message)
                    .contains(EXCEPTION_MESSAGE_PREFIX)
                    .contains(invalidInput);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5", "12,23,34,21,24,123", "123,234,345,456,567,678"})
        @DisplayName("만약 입력 값의 길이가 11(한 자릿수 6 + 구분자 5)에서 17(두 자릿수 12 + 구분자 5) 사이의 값이 아니라면 입력 값을 포함한 예외 메세지를 반환한다.")
        void invalid_input_number_length_exception_message_test(String invalidInput) {
            String message = LottoExceptionMessageUtils.INVALID_NUMBER_LENGTH.findExceptionMessage(invalidInput.length());

            assertThat(message)
                    .contains(EXCEPTION_MESSAGE_PREFIX)
                    .contains(String.valueOf(invalidInput.length()));
        }

        @Test
        @DisplayName("만약 유효하지 않은 당첨 등수를 입력하면 입력 값을 포함한 예외 메세지를 반환한다.")
        void invalid_lotto_ranking_exception_message_test() {
            String invalidRankingName = "?등";

            String message = LottoExceptionMessageUtils.INVALID_RANKING.findExceptionMessage(invalidRankingName);

            assertThat(message)
                    .contains(EXCEPTION_MESSAGE_PREFIX)
                    .contains(invalidRankingName);
        }
    }
}