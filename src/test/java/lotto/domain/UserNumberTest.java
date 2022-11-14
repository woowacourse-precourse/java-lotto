package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserNumberTest {

    @DisplayName("당첨 번호에 숫자, 쉼표 외의 문자가 있으면 예외가 발생한다.")
    @Test
    void createWinNumberByNotInType() {
        assertThatThrownBy(() -> new UserNumber("1.?3,4,5,6", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WIN_NUMBER_TYPE.getMessage());
    }

    @DisplayName("보너스 번호에 문자가 있으면 예외가 발생한다.")
    @Test
    void createBonusNumberByNotInType() {
        assertThatThrownBy(() -> new UserNumber("1,2,3,4,5,6", ","))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_TYPE.getMessage());
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicate() {
        assertThatThrownBy(() -> new UserNumber("1,2,3,4,5,6", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_SAME.getMessage());
    }

    @DisplayName("올바른 당첨 번호와 보너스 번호가 입력되면 정상적으로 당첨 번호를 리턴한다.")
    @ParameterizedTest
    @MethodSource("generateRightData")
    void createRightWinNumber(String winNumber, String bonusNumber) {
        List<Integer> expected = Arrays.stream(winNumber.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        UserNumber userNumber = new UserNumber(winNumber, bonusNumber);

        assertThat(userNumber.getWinNumbers().getNumbers()).isEqualTo(expected);
    }

    @DisplayName("올바른 당첨 번호와 보너스 번호가 입력되면 정상적으로 보너스 번호를 리턴한다.")
    @ParameterizedTest
    @MethodSource("generateRightData")
    void createRightBonusNumber(String winNumber, String bonusNumber) {
        UserNumber userNumber = new UserNumber(winNumber, bonusNumber);
        assertThat(userNumber.getBonusNumber()).isEqualTo(Integer.parseInt(bonusNumber));
    }

    static Stream<Arguments> generateRightData() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", "11"),
                Arguments.of("2,8,14,22,31,44", "28"),
                Arguments.of("1,2,11,22,31,32", "28"),
                Arguments.of("7,14,18,21,24,29", "28"),
                Arguments.of("4,6,27,36,41,45", "28")
        );
    }
}
