package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {
    @DisplayName("로또 구입 금액이 1000원 단위가 아니면 에러가 발생한다. ")
    @Test
    void createLottoCashBy1000(){
        int money = 1255;
        Player player = new Player();
        assertThatThrownBy(()-> player.checkDivideBy1000(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 구입 입력이 정수가 아니면 에러가 발생한다. ")
    @Test
    void createLottoCashByInteger(){

    }
}
