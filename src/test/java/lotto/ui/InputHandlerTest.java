package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Player;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputHandlerTest {

    static Player player = new Player();

    @Test
    void inputMoney() {
        int money = 10000;
        player.setMoney(money);

        assertThat(money).isEqualTo(player.getMoney());
    }

    @Test
    void inputLottoNumber() {
        InputHandler inputHandler = new InputHandler();
        List<Integer> list = inputHandler.inputLottoNumber();
    }

    @Test
    void inputLottoBonusNumber() {
    }
}