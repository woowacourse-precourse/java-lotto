package lotto.vo;

import lotto.dto.WinningDto;
import lotto.system.LottoApplication;
import lotto.system.validator.IntegerListToLottoValidator;
import lotto.system.validator.WinningDtoToWinningValidator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class WinningTest {
    @BeforeEach
    void setup() {
        LottoApplication.initializeValidators();
        LottoApplication.initializeConverters();
    }

    @AfterEach
    void runAfter() {
        LottoApplication.doAfter();
    }

    @Nested
    @DisplayName("사용자 입력값 중 로또 번호 테스트")
    class WinningNumbersTest {
        @ParameterizedTest(name = "{displayName} - {0}")
        @MethodSource("lotto.vo.WinningTest#SourceOfWinningNotIntegerWithRest")
        @DisplayName("입력값이 쉼표로 구분된 정수로 이루어지지 않으면 Winning 객체를 만드려고 할 때 예외가 발생한다.")
        void givenInputNotIntegerWithRest_whenMakingWinning_thenThrowsException(String winning) {
            //given
            String bonus = "3";
            WinningDto winningDto = WinningDto.of(winning, bonus);

            //when & then
            assertThatThrownBy(winningDto::toWinning)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(WinningDtoToWinningValidator.INVALID_WINNING_NUMBER_FORMAT_MESSAGE);
        }

        @ParameterizedTest(name = "{displayName} - {0}")
        @MethodSource("lotto.vo.WinningTest#SourceOfInvalidWinningNumberAndErrorMessage")
        @DisplayName("입력한 로또 번호가 로또의 조건에 부합하지 않으면 예외가 발생한다.")
        void givenInvalidWinningNumber_whenMakingWinning_thenThrowsException(String winningNumber, String errorMessage) {
            //given
            String bonus = "5";
            WinningDto winningDto = WinningDto.of(winningNumber, bonus);

            //when & then
            assertThatThrownBy(winningDto::toWinning)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(errorMessage);
        }

        @Test
        @DisplayName("입력한 로또 번호 사이에 띄어쓰기가 있어도 허용해 준다.")
        void givenWinningNumberWithSpace_whenMakingWinning_thenReturnsWinning() {
            //given
            String winningNumber = "1, 2, 5, 23, 34, 44";
            String bonus = "6";
            WinningDto winningDto = WinningDto.of(winningNumber, bonus);

            //when & then
            assertDoesNotThrow(winningDto::toWinning);
        }
    }

    private static Stream<String> SourceOfWinningNotIntegerWithRest() {
        return Stream.of(
                "1,3,7,14,,34,43",
                "1,3,7,14,Rr,34,43",
                "1,3,7,14,3.5,34,43"
        );
    }

    public static Stream<Arguments> SourceOfInvalidWinningNumberAndErrorMessage() {
        return Stream.of(
                Arguments.of("1,3,3,15,22,34", IntegerListToLottoValidator.DUPLICATING_NUMBER_MESSAGE),
                Arguments.of("1,0,3,15,22,34", IntegerListToLottoValidator.INVALID_NUMBER_RANGE_MESSAGE),
                Arguments.of("1,3,7,15,22,34,35", IntegerListToLottoValidator.INVALID_LIST_SIZE_MESSAGE)
        );
    }

    @Nested
    @DisplayName("사용자 입력값 중 보너스 번호 테스트")
    class BonusNumberTest {
        @ParameterizedTest(name = "{displayName} - {0}")
        @MethodSource("lotto.vo.WinningTest#SourceOfBonusNotInteger")
        @DisplayName("입력값이 정수로 이루어지지 않은 bonus 값이면 Winning 객체를 만드려고 할 때 예외가 발생한다.")
        void givenBonusNotInteger_whenMakingWinning_thenThrowsException(String bonus) {
            //given
            String winning = "1,3,7,14,34,43";
            WinningDto winningDto = WinningDto.of(winning, bonus);

            //when & then
            assertThatThrownBy(winningDto::toWinning)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(WinningDtoToWinningValidator.INVALID_BONUS_NUMBER_FORMAT_MESSAGE);
        }

        @Test
        @DisplayName("보너스 번호의 범위가 로또 번호를 벗어나면 예외가 발생한다.")
        void givenInvalidRangeBonus_whenMakingWinning_thenThrowsException() {
            //given
            String winning = "1,3,7,14,34,43";
            String bonus = "46";
            WinningDto winningDto = WinningDto.of(winning, bonus);

            //when & then
            assertThatThrownBy(winningDto::toWinning)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(WinningDtoToWinningValidator.INVALID_NUMBER_RANGE_MESSAGE);
        }

        @Test
        @DisplayName("이미 입력한 로또 번호와 보너스 번호가 겹치면 예외가 발생한다.")
        void givenBonusInWinningNumbers_whenMakingWinning_thenThrowsException() {
            String winning = "1,3,7,14,34,43";
            String bonus = "14";
            WinningDto winningDto = WinningDto.of(winning, bonus);

            //when & then
            assertThatThrownBy(winningDto::toWinning)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(WinningDtoToWinningValidator.BONUS_DUPLICATING_WITH_WINNING_MESSAGE);
        }
    }

    private static Stream<String> SourceOfBonusNotInteger() {
        return Stream.of(
                "R",
                "3.5",
                "3-"
        );
    }
}