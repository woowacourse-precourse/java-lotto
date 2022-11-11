package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.MoneyConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("로또 구매 금액에 숫자 외 다른 문자가 포함될 경우 이유를 나타내는 메세지를 포함한 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1 "," 1"," 1 ","1 2","1a","1a2","a1b","1가나","가2나","가나1","abc","가나다","a가b나c"})
    void createMoneyWithNotOnlyDigitsButAlsoChar(String userInput) {
        //given
        //when
        //then
        assertThatThrownBy(() -> Money.valueOf(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MoneyConstants.CHARACTER_IN_MONEY_MSG);
    }

    @DisplayName("로또 구매 금액이 1000으로 나눠 떨어지지 않는 경우 이유를 나타내는 메세지를 포함한 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1","12","123","1234","0001","0011","0101","10001","1000000001","100300"})
    void createMoneyWithRemainder(String userInput) {
        //given
        //when
        //then
        assertThatThrownBy(() -> Money.valueOf(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MoneyConstants.REMAINDER_IN_MONEY_MSG);
    }
}
