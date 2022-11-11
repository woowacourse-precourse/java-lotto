package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.MoneyConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @DisplayName("로또 구매 금액이 비어있으면 이유를 나타내는 메세지를 포함한 예외가 발생한다.")
    @Test
    void createMoneyByEmptyInput() {
        //given
        String userInput = "";
        //when
        //then
        assertThatThrownBy(() -> Money.valueOf(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MoneyConstants.EMPTY_MONEY_MSG);
    }
}
