package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest extends NsTest {
    LottoGame lottoGame;

    @BeforeEach
    void setup(){
        lottoGame = new LottoGame();
    }

    @DisplayName("입력한 값에 따라 제대로 된 개수를 출력하는지 확인")
    @Test
    void getMoneyInputTest(){
        assertSimpleTest(() -> {
            runException("14000");
            assertThat(output()).contains("14개를 구매했습니다.");
        });
    }
    @DisplayName("구매한 로또 개수만큼 로또 번호를 발행하는지 확인")
    @Test
    void getLottoNumberList(){
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }
    @DisplayName("입력 받은 당첨 로또 번호가 1~45 사이 숫자가 아닌 경우 예외처리 확인")
    @Test
    void getLottoWinningNumberInput1(){
        assertThatThrownBy(()->{
            runException("1,2,3,4,5,46");
            lottoGame.getLottoWinningNumberInput();
        })
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력 받은 당첨 로또 번호가 6개가 아닌 경우 예외처리 확인")
    @Test
    void getLottoWinningNumberInput2(){
        assertThatThrownBy(()->{
            runException("1,2,3,4,5,6,7");
            lottoGame.getLottoWinningNumberInput();
        })
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력 받은 당첨 로또 번호가 중복이 있는 경우 예외처리 확인")
    @Test
    void getLottoWinningNumberInput3(){
        assertThatThrownBy(()->{
            runException("1,2,3,4,5,5");
            lottoGame.getLottoWinningNumberInput();
        })
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Override
    protected void runMain() {
        lottoGame.startGame();
    }
}