package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest extends NsTest {
    LottoGame lottoGame;

    @BeforeEach
    void setup(){
        lottoGame = new LottoGame();
    }

    @Test
    void getMoneyInputTest(){
        assertSimpleTest(() -> {
            runException("14000");
            assertThat(output()).contains("14개를 구매했습니다.");
        });
    }

    @Override
    protected void runMain() {
        lottoGame.getMoneyInput();
    }
}