package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameMoneyTest {

    @DisplayName(value = "1000단위에 대한 게임머니 예외 테스트")
    @ParameterizedTest
    @CsvSource({"1000,true", "12000,true", "100,false", "12001,false"})
    void createGameMoneyExceptionTest(int money, boolean expectedException) {
        if (expectedException) {
            GameMoney gameMoney = new GameMoney(money);
            assertThat(gameMoney).isInstanceOf(GameMoney.class);
        }
        if (!expectedException) {
            assertThatThrownBy(() -> new GameMoney(money))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}