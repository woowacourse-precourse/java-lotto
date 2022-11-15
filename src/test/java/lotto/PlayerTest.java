package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {
    Player player = new Player();

    @DisplayName("로또 구입 금액이 1000원 단위가 아니면 에러가 발생한다. ")
    @Test
    void createLottoCashBy1000(){
        int money = 1255;

        assertThatThrownBy(()-> player.checkDivideBy1000(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("로또 ticket 계산 결과 맞는지 확인한다. ")
    void moneydivdeBy1000() {
        String money = "10000";
        int ticket = player.putMoneyforLotto(money);
        assertThat(ticket).isEqualTo(10);
    }

//    @DisplayName("로또 구입 입력이 정수가 아니면 에러가 발생한다. ")
//    @Test
//    void createLottoCashByInteger(){
//        String money = "123j";
//        Player player = new Player();
//        assertThatThrownBy(()-> player.putMoneyforLotto(money))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//    @DisplayName("보너스 정수가 1~45가 아니면 에러가 발생한다. ")
//    @Test
//    void createBonusByRange(){
//        Player player = new Player();
//        assertThatThrownBy(()-> player.setBonusNumber(55))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
}
