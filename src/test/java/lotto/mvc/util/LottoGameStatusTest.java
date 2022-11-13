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
                    "GUIDE_PURCHASE_AMOUNT:PROCESS_PURCHASE_LOTTO",
                    "PROCESS_PURCHASE_LOTTO:GUIDE_WINNING_NUMBERS",
                    "GUIDE_WINNING_NUMBERS:PROCESS_WINNING_LOTTO",
                    "PROCESS_WINNING_LOTTO:GUIDE_BONUS_NUMBER",
                    "GUIDE_BONUS_NUMBER:PROCESS_LOTTO_RANKING",
                    "PROCESS_LOTTO_RANKING:APPLICATION_EXIT",
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
    @DisplayName("isInput 메소드는")
    class IsInputMethodTest {

        @ParameterizedTest
        @CsvSource(
                value = {
                    "GUIDE_PURCHASE_AMOUNT:true",
                    "PROCESS_PURCHASE_LOTTO:false",
                    "GUIDE_WINNING_NUMBERS:true",
                    "PROCESS_WINNING_LOTTO:false",
                    "GUIDE_BONUS_NUMBER:true",
                    "PROCESS_LOTTO_RANKING:false",
                    "APPLICATION_EXIT:false",
                    "APPLICATION_EXCEPTION:false"
                },
                delimiter = ':'
        )
        @DisplayName("만약 호출하면 해당 LottoGameStatus가 입력용 안내 문구를 출력해야 하는지 여부를 반환한다.")
        void success_test(LottoGameStatus lottoGameStatus, boolean expected) {
            boolean actual = lottoGameStatus.isInput();

            assertThat(actual).isSameAs(expected);
        }
    }

    @Nested
    @DisplayName("isLogic 메소드는")
    class IsLogicMethodTest {

        @ParameterizedTest
        @CsvSource(
            value = {
                "GUIDE_PURCHASE_AMOUNT:false",
                "PROCESS_PURCHASE_LOTTO:true",
                "GUIDE_WINNING_NUMBERS:false",
                "PROCESS_WINNING_LOTTO:true",
                "GUIDE_BONUS_NUMBER:false",
                "PROCESS_LOTTO_RANKING:true",
                "APPLICATION_EXIT:false",
                "APPLICATION_EXCEPTION:false"
            },
            delimiter = ':'
        )
        @DisplayName("만약 호출하면 해당 LottoGameStatus가 로직을 수행해야 하는지 여부를 반환한다.")
        void success_test(LottoGameStatus lottoGameStatus, boolean expected) {
            boolean actual = lottoGameStatus.isLogic();

            assertThat(actual).isSameAs(expected);
        }
    }

    @Nested
    @DisplayName("isExit 메소드는")
    class IsExitMethodTest {

        @ParameterizedTest
        @CsvSource(
            value = {
                "GUIDE_PURCHASE_AMOUNT:false",
                "PROCESS_PURCHASE_LOTTO:false",
                "GUIDE_WINNING_NUMBERS:false",
                "PROCESS_WINNING_LOTTO:false",
                "GUIDE_BONUS_NUMBER:false",
                "PROCESS_LOTTO_RANKING:false",
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