package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameTest extends NsTest {


    @Test
    void gameStartTest() {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다."
                    );
                }
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}