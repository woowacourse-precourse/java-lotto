package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.BonusBallConstants;
import lotto.constant.MoneyConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
