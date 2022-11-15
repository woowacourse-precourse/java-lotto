package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest {
    @Test
    void getPayMoneyTest1(){
        Input input = new Input();

        assertThatThrownBy(() -> input.getPayMoney("12ab12"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getPayMoneyTest2(){
        Input input = new Input();

        assertThatThrownBy(() -> input.getPayMoney("123452853740958342000"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void getPayMoneyTest3(){
        Input input = new Input();

        assertThatThrownBy(() -> input.getPayMoney("135700"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getWinningNumberTest1(){
        Input input = new Input();

        assertThat(input.getWinningNumber("1,2,3,4,5,6"))
                .isEqualTo(new Lotto(List.of(1,2,3,4,5,6)));
    }

    @Test
    void getWinningNumberTest2(){
        Input input = new Input();

        assertThatThrownBy(() -> input.getWinningNumber("1,2,3,4,5,a6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getWinningNumberTest3(){
        Input input = new Input();

        assertThatThrownBy(() -> input.getWinningNumber("1,2,3,4,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getBonusNumberTest1(){
        Input input = new Input();

        assertThat(input.getBonusNumber("4"))
                .isEqualTo(4);
    }

    @Test
    void getBonusNumberTest2(){
        Input input = new Input();

        assertThatThrownBy(() -> input.getBonusNumber("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}