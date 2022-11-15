package lotto.mvc.util.message;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.mvc.util.LottoGameStatus;
import lotto.mvc.util.exception.NotFoundViewMessageException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

class InputViewMessageUtilsTest {

    @Nested
    @DisplayName("findInputViewMessage 메소드는")
    class FindInputViewMessageMethodTest {

        @ParameterizedTest
        @CsvSource(
                value = {
                    "PURCHASE_AMOUNT:구입금액을 입력해 주세요.",
                    "WINNING_NUMBERS:당첨 번호를 입력해 주세요.",
                    "BONUS_NUMBER:보너스 번호를 입력해 주세요."
                },
                delimiter = ':'
        )
        @DisplayName("만약 입력 시 안내 문구가 필요한 LottoGameStatus가 주어지면 그에 맞는 메세지를 반환한다.")
        void success_test(LottoGameStatus lottoGameStatus, String expectedMessage) {
            String actualMessage = InputViewMessageUtils.findMessage(lottoGameStatus);

            assertThat(actualMessage).contains(expectedMessage);
        }

        @ParameterizedTest
        @EnumSource(names = {"APPLICATION_EXIT", "APPLICATION_EXCEPTION"})
        @DisplayName("만약 안내 문구가 필요하지 않은 LottoGameStatus가 주어지면 NotFoundViewMessageException 예외가 발생한다.")
        void not_found_message_exception_test(LottoGameStatus lottoGameStatus) {
            assertThatThrownBy(() -> InputViewMessageUtils.findMessage(lottoGameStatus))
                    .isInstanceOf(NotFoundViewMessageException.class);
        }
    }
}