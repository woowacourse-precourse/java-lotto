package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest extends NsTest {
    @DisplayName("입력된 보너스 번호가 숫자가 맞는지 확인.")
    @Test
    void checkBonusException1() {

        assertSimpleTest(()-> {
            runException("1000", "1,2,3,4,5,6", "   a    ");
            assertThat(output()).contains("[ERROR]");
        });

        assertSimpleTest(()-> {
            runException("1000", "1,2,3,4,5,6", " ");
            assertThat(output()).contains("[ERROR]");
        });

        assertSimpleTest(()-> {
            runException("1000", "1,2,3,4,5,6", "$");
            assertThat(output()).contains("[ERROR]");
        });

        assertSimpleTest(()-> {
            runException("1000", "1,2,3,4,5,6", null);
            assertThat(output()).contains("[ERROR]");
        });
    }

    @DisplayName("입력된 보너스 번호가 정답에 없는지 확인.")
    @Test
    void checkBonusException2() {
        assertSimpleTest(()-> {
            runException("1000", "1,2,3,4,5,6", "3");
            assertThat(output()).contains("[ERROR]");
        });

        assertSimpleTest(()-> {
            runException("1000", "1,2,3,4,5,6", "5");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @DisplayName("입력된 보너스 번호가 범위에 있는지 확인.")
    @Test
    void checkBonusException3() {
        assertSimpleTest(()-> {
            runException("1000", "1,2,3,4,5,6", "0");
            assertThat(output()).contains("[ERROR]");
        });

        assertSimpleTest(()-> {
            runException("1000", "1,2,3,4,5,6", "46");
            assertThat(output()).contains("[ERROR]");
        });

        assertSimpleTest(()-> {
            runException("1000", "1,2,3,4,5,6", "-4");
            assertThat(output()).contains("[ERROR]");
        });

        assertSimpleTest(()-> {
            runException("1000", "1,2,3,4,5,6", "45");
            //should be correct case
            //assertThat(output()).contains("[ERROR]");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}