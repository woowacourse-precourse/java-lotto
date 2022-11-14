package lotto.vo;

import lotto.system.validator.ConvertingToWinningInfoValidator;
import lotto.system.validator.ConvertingToLottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("WinningInfo 테스트")
class WinningInfoTest {
    @Nested
    @DisplayName("WinningInfo 생성자 메소드 테스트")
    class toWinningInfoTest {
        @Nested
        @DisplayName("사용자 입력값 중 로또 번호 테스트")
        class WinningNumbersTest {
            @ParameterizedTest(name = "{displayName} - {0}")
            @MethodSource("lotto.vo.WinningInfoTest#SourceOfInvalidWinningNumbersAndErrorMessage")
            @DisplayName("입력한 로또 번호가 로또의 조건에 부합하지 않으면 예외가 발생한다.")
            void givenInvalidWinningNumbers_whenConvertingToWinningInfo_thenThrowsException(List<Integer> winningNumbers, String errorMessage) {
                //given
                int bonus = 5;

                //when & then
                assertThatThrownBy(() -> new WinningInfo(winningNumbers, bonus))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(errorMessage);
            }
        }

        @Nested
        @DisplayName("사용자 입력값 중 보너스 번호 테스트")
        class BonusNumberTest {
            @Test
            @DisplayName("보너스 번호의 범위가 로또 번호를 벗어나면 예외가 발생한다.")
            void givenInvalidRangeBonus_whenConvertingToWinningInfo_thenThrowsException() {
                //given
                List<Integer> winningNumbers = Arrays.asList(1, 3, 7, 14, 34, 43);
                int bonus = 46;

                //when & then
                assertThatThrownBy(() -> new WinningInfo(winningNumbers, bonus))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ConvertingToWinningInfoValidator.INVALID_NUMBER_RANGE_MESSAGE);
            }

            @Test
            @DisplayName("이미 입력한 로또 번호와 보너스 번호가 겹치면 예외가 발생한다.")
            void givenBonusInWinningNumbers_whenConvertingToWinningInfo_thenThrowsException() {
                List<Integer> winningNumbers = Arrays.asList(1, 3, 7, 14, 34, 43);
                int bonus = 14;

                //when & then
                assertThatThrownBy(() -> new WinningInfo(winningNumbers, bonus))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ConvertingToWinningInfoValidator.BONUS_DUPLICATING_WITH_WINNING_NUMBERS_MESSAGE);
            }
        }
    }

    public static Stream<Arguments> SourceOfInvalidWinningNumbersAndErrorMessage() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 3, 3, 15, 22, 34), ConvertingToLottoValidator.DUPLICATING_NUMBER_MESSAGE),
                Arguments.of(Arrays.asList(1, 0, 3, 15, 22, 34), ConvertingToLottoValidator.INVALID_NUMBER_RANGE_MESSAGE),
                Arguments.of(Arrays.asList(1, 3, 7, 15, 22, 34, 35), ConvertingToLottoValidator.INVALID_LIST_SIZE_MESSAGE)
        );
    }
}