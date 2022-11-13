package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @DisplayName("장당 구매 가격으로 나눌 수 없는 구입 금액을 설정 시 예외가 발생한다.")
    @Test
    public void setIndivisibleBudget(){
        Game game = new Game();
        assertThatThrownBy(() -> game.setBudget(500))
                .isInstanceOf(IllegalArgumentException.class);
    }


}