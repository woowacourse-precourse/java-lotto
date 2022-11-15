package lotto.play;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.type.TextType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class GameTest extends NsTest {

    private Game game = new Game();

    @DisplayName("0으로 나눴을때도 결과가 제대로 출력된다.")
    @Test
    void dividedZeroExceptionTest(){
        game.calculateEarnRatio(1000, 0);
        assertSimpleTest(() -> {
            assertThat(output()).contains(TextType.EARN_PERCENT.getText());
        });
    }

    @DisplayName("0으로 나눴을때도 결과가 제대로 출력된다.")
    @Test
    void dividedZeroExceptionTest2(){
        game.calculateEarnRatio(23000, 0);
        assertSimpleTest(() -> {
            assertThat(output()).contains(TextType.EARN_PERCENT.getText());
        });
    }

    @DisplayName("0으로 나눴을때도 결과가 제대로 출력된다.")
    @Test
    void dividedZeroExceptionTest3(){
        game.calculateEarnRatio(200000, 0);
        assertSimpleTest(() -> {
            assertThat(output()).contains(TextType.EARN_PERCENT.getText());
        });
    }

    @DisplayName("정확히 입력시 결과가 정확히 출력된다.")
    @Test
    void dividedTest(){
        game.calculateEarnRatio(1000, 200000);
        assertSimpleTest(() -> {
            assertThat(output()).contains(TextType.EARN_PERCENT.getText());
        });
    }

    @DisplayName("정확히 입력시 결과가 정확히 출력된다.")
    @Test
    void dividedTest2(){
        game.calculateEarnRatio(32000, 60005500);
        assertSimpleTest(() -> {
            assertThat(output()).contains(TextType.EARN_PERCENT.getText());
        });
    }

    @DisplayName("정확히 입력시 결과가 정확히 출력된다.")
    @Test
    void dividedTest3(){
        game.calculateEarnRatio(36000, 24000);
        assertSimpleTest(() -> {
            assertThat(output()).contains(TextType.EARN_PERCENT.getText());
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}