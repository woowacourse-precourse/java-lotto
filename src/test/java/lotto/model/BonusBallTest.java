package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.BonusBallConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusBallTest {

    @DisplayName("보너스 볼 값이 비어있으면 이유를 나타내는 메세지를 포함한 예외가 발생한다.")
    @Test
    void createBonusBallByEmptyInput() {
        //given
        String userInput = "";
        //when
        //then
        assertThatThrownBy(() -> BonusBall.from(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BonusBallConstants.EMPTY_BONUSBALL_MSG);
    }

    @DisplayName("보너스 볼 값애 숫자 외 값이 포함되어 있는 경우 이유를 나타내는 메세지를 포함한 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1 "," 1"," 1 ","1 2","1a","1a2","a1b","1가나","가2나","가나1","abc","가나다","a가b나c"})
    void createBonusBallWithNotOnlyDigitsButAlsoChars(String userInput) {
        //given
        //when
        //then
        assertThatThrownBy(() -> BonusBall.from(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BonusBallConstants.INVALID_BONUSBALL_INPUT_MSG);
    }

    @DisplayName("보너스 볼 값이 1에서 45까지의 범위 내 숫자가 아닌 경우 이유를 나타내는 메세지를 포함한 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0","46","111","111111111112","1234567891011"})
    void createBonusBallByInvalidRangeValue(String userInput) {
        //given
        //when
        //then
        assertThatThrownBy(() -> BonusBall.from(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BonusBallConstants.INVALID_BONUSBALL_INPUT_MSG);
    }
}
