package lotto.dto;

import lotto.system.validator.ConvertingToWinningInfoValidator;
import lotto.system.validator.ConvertingToLottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("WinningInfoDto 테스트")
class WinningInfoDtoTest {
    @Nested
    @DisplayName("WinningInfoDto 를 WinningInfo 객체로 바꾸는 toWinningInfo 메소드 테스트")
    class toWinningInfoTest {
        @Nested
        @DisplayName("사용자 입력값 중 로또 번호 테스트")
        class WinningNumbersTest {
            @ParameterizedTest(name = "{displayName} - {0}")
            @MethodSource("lotto.dto.WinningInfoDtoTest#SourceOfWinningNumbersNotNumbersWithRest")
            @DisplayName("입력값이 쉼표로 구분된 정수로 이루어지지 않으면 WinningInfo 객체를 만드려고 할 때 예외가 발생한다.")
            void givenInputNotNumbersWithComma_whenMakingWinning_thenThrowsException(String winningNumbers) {
                //given
                String bonus = "3";
                WinningInfoDto winningInfoDto = new WinningInfoDto(winningNumbers, bonus);

                //when & then
                assertThatThrownBy(winningInfoDto::toWinningInfo)
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ConvertingToWinningInfoValidator.INVALID_WINNING_NUMBERS_FORMAT_MESSAGE);
            }

            @ParameterizedTest(name = "{displayName} - {0}")
            @MethodSource("lotto.dto.WinningInfoDtoTest#SourceOfInvalidWinningNumbersAndErrorMessage")
            @DisplayName("입력한 로또 번호가 로또의 조건에 부합하지 않으면 예외가 발생한다.")
            void givenInvalidWinningNumbers_whenConvertingToWinningInfo_thenThrowsException(String winningNumbers, String errorMessage) {
                //given
                String bonus = "5";
                WinningInfoDto winningInfoDto = new WinningInfoDto(winningNumbers, bonus);

                //when & then
                assertThatThrownBy(winningInfoDto::toWinningInfo)
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(errorMessage);
            }

            @Test
            @DisplayName("입력한 로또 번호 사이에 띄어쓰기가 있어도 허용해 준다.")
            void givenWinningNumbersWithSpace_whenConvertingToWinningInfo_thenSuccess() {
                //given
                String winningNumbers = "1, 2, 5, 23, 34, 44";
                String bonus = "6";
                WinningInfoDto winningInfoDto = new WinningInfoDto(winningNumbers, bonus);

                //when & then
                assertDoesNotThrow(winningInfoDto::toWinningInfo);
            }
        }

        @Nested
        @DisplayName("사용자 입력값 중 보너스 번호 테스트")
        class BonusNumberTest {
            @ParameterizedTest(name = "{displayName} - {0}")
            @MethodSource("lotto.dto.WinningInfoDtoTest#SourceOfBonusNotNumber")
            @DisplayName("입력값이 정수로 이루어지지 않은 보너스 번호로 WinningInfo 객체를 만드려고 할 때 예외가 발생한다.")
            void givenBonusNotNumber_whenConvertingToWinningInfo_thenThrowsException(String bonus) {
                //given
                String winningNumbers = "1,3,7,14,34,43";
                WinningInfoDto winningInfoDto = new WinningInfoDto(winningNumbers, bonus);

                //when & then
                assertThatThrownBy(winningInfoDto::toWinningInfo)
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ConvertingToWinningInfoValidator.INVALID_BONUS_NUMBER_FORMAT_MESSAGE);
            }

            @Test
            @DisplayName("보너스 번호의 범위가 로또 번호를 벗어나면 예외가 발생한다.")
            void givenInvalidRangeBonus_whenConvertingToWinningInfo_thenThrowsException() {
                //given
                String winningNumbers = "1,3,7,14,34,43";
                String bonus = "46";
                WinningInfoDto winningInfoDto = new WinningInfoDto(winningNumbers, bonus);

                //when & then
                assertThatThrownBy(winningInfoDto::toWinningInfo)
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ConvertingToWinningInfoValidator.INVALID_NUMBER_RANGE_MESSAGE);
            }

            @Test
            @DisplayName("이미 입력한 로또 번호와 보너스 번호가 겹치면 예외가 발생한다.")
            void givenBonusInWinningNumbers_whenConvertingToWinningInfo_thenThrowsException() {
                String winningNumbers = "1,3,7,14,34,43";
                String bonus = "14";
                WinningInfoDto winningInfoDto = new WinningInfoDto(winningNumbers, bonus);

                //when & then
                assertThatThrownBy(winningInfoDto::toWinningInfo)
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ConvertingToWinningInfoValidator.BONUS_DUPLICATING_WITH_WINNING_NUMBERS_MESSAGE);
            }
        }
    }

    private static Stream<String> SourceOfWinningNumbersNotNumbersWithRest() {
        return Stream.of(
                "1,3,7,14,,34,43",
                "1,3,7,14,Rr,34,43",
                "1,3,7,14,3.5,34,43"
        );
    }

    public static Stream<Arguments> SourceOfInvalidWinningNumbersAndErrorMessage() {
        return Stream.of(
                Arguments.of("1,3,3,15,22,34", ConvertingToLottoValidator.DUPLICATING_NUMBER_MESSAGE),
                Arguments.of("1,0,3,15,22,34", ConvertingToLottoValidator.INVALID_NUMBER_RANGE_MESSAGE),
                Arguments.of("1,3,7,15,22,34,35", ConvertingToLottoValidator.INVALID_LIST_SIZE_MESSAGE)
        );
    }

    private static Stream<String> SourceOfBonusNotNumber() {
        return Stream.of(
                "R",
                "3.5",
                "3-"
        );
    }
}