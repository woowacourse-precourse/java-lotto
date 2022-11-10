package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {
    @Test
    @DisplayName("1000원으로 나누어 떨어지는 금액의 플레이어를 새로 만든다.")
    void createPlayerWithInitialMoneySuccess(){
        long testMoney = 4000;
        assertThatCode(() -> new Player(testMoney))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("1000원으로 나누어 떨어지지 않는 금액의 플레이어를 새로 만들면 예외가 발생한다.")
    void createPlayerWithInitialMoneyThrowsException(){
        long testMoney = 4300;
        assertThatThrownBy(() -> new Player(testMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
