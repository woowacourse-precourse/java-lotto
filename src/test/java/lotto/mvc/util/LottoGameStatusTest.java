package lotto.mvc.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGameStatusTest {

    @Nested
    @DisplayName("findNextGameStatus 메소드는")
    class FindNextGameStatusMethodTest {

        @ParameterizedTest
        @CsvSource(
                value = {
                    "PURCHASE_AMOUNT:WINNING_NUMBERS",
                    "WINNING_NUMBERS:BONUS_NUMBER",
                    "BONUS_NUMBER:APPLICATION_EXIT",
                    "APPLICATION_EXIT:APPLICATION_EXIT",
                    "APPLICATION_EXCEPTION:APPLICATION_EXCEPTION"
                },
                delimiter = ':'
        )
        @DisplayName("만약 호출되면 다음 단계의 LottoGameStatus를 반환한다.")
        void success_test(LottoGameStatus lottoGameStatus, LottoGameStatus expectedStatus) {
            LottoGameStatus actualStatus = lottoGameStatus.findNextGameStatus();

            assertThat(actualStatus).isSameAs(expectedStatus);
        }
    }

    @Nested
    @DisplayName("isExit 메소드는")
    class IsExitMethodTest {

        @ParameterizedTest
        @CsvSource(
                value = {
                    "PURCHASE_AMOUNT:false",
                    "WINNING_NUMBERS:false",
                    "BONUS_NUMBER:false",
                    "APPLICATION_EXIT:true",
                    "APPLICATION_EXCEPTION:true"
                },
                delimiter = ':'
        )
        @DisplayName("만약 호출하면 해당 LottoGameStatus가 애플리케이션을 종료해야 하는지 여부를 반환한다.")
        void success_test(LottoGameStatus lottoGameStatus, boolean expected) {
            boolean actual = lottoGameStatus.isExit();

            assertThat(actual).isSameAs(expected);
        }
    }
}