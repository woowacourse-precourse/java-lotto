package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ProvidNumberTest {

    @DisplayName("당첨 번호에는 오직 숫자와 콤마만 있어야 한다.")
    @Test
    void createWinningNumbersByNotOnlyNumberAndComma() {
        assertThatThrownBy(() -> new ProvidNumber("1,2,],3,4,5", "10"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WINNING_NUMBER_ONLY_NUMBER_AND_COMMA.getErrorMessage());
    }

    @DisplayName("보너스 숫자에는 숫자만 입력할 수 있다.")
    @Test
    void createBonusNumberOnlyNumber() {
        assertThatThrownBy(() -> new ProvidNumber("1,2,10,3,4,5", "+"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_ONLY_NUMBER.getErrorMessage());
    }

    @DisplayName("보너스 숫자가 당첨 숫자와 중복이 되면 안된다.")
    @Test
    void createBonusNumberDuplicateWinningNumber() {
        assertThatThrownBy(() -> new ProvidNumber("1,2,10,3,4,5", "5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_DUPLICATE_WINNING_NUMBER.getErrorMessage());
    }

    @DisplayName("옳은 당첨 번호와 보너스번호가 입력되면 정상적으로 당첨 번호 리턴")
    @ParameterizedTest
    @MethodSource("rightData")
    void createRightWinningNumber(String winningNumber, String bonusNumber) {
        List<Integer> expected = Arrays.stream(winningNumber.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        ProvidNumber providNumber = new ProvidNumber(winningNumber, bonusNumber);

        assertThat(providNumber.getWinningNumbers().getNumbers()).isEqualTo(expected);
    }

    @DisplayName("옳은 당첨 번호와 보너스번호가 입력되면 정상적으로 보너스 번호 리턴")
    @ParameterizedTest
    @MethodSource("rightData")
    void createRightBonusNumber(String winningNumber, String bonusNumber) {
        ProvidNumber providNumber = new ProvidNumber(winningNumber, bonusNumber);

        assertThat(providNumber.getBonusNumber()).isEqualTo(Integer.parseInt(bonusNumber));
    }

    static Stream<Arguments> rightData() {
        Stream<Arguments> stream = Stream.of(
                Arguments.of("1,2,3,7,8,9", "45"),
                Arguments.of("3,5,13,42,22,11", "1"),
                Arguments.of("40,34,32,31,30,29", "1")
        );

        return stream;
    }
}