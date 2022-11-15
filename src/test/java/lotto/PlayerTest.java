package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

public class PlayerTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("입력 금액이 숫자로만 되어 있지 않으면 예외가 발생한다.")
    @Test
    void 입력금액_숫자로_이루어져있는지확인(){
        Manager m = new Manager();
        Player p = new Player(m);
        assertSimpleTest(() -> {
            runException("f32j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("입력 금액이 1000원보다 작으면 예외가 발생한다.")
    @Test
    void 구입최소금액_확인(){
        Manager m = new Manager();
        Player p = new Player(m);
        assertSimpleTest(() -> {
            runException("900");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("입력 금액이 1000단위가 아니면 예외가 발생한다.")
    @Test
    void 입력금액_단위_확인(){
        Manager m = new Manager();
        Player p = new Player(m);
        assertSimpleTest(() -> {
            runException("12003");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호가 쉼표 기준 6개로 분리되지 않는 경우 예외가 발생한다.")
    @Test
    void 당첨번호_6개로_구분되는지확인(){
        Manager m = new Manager();
        Player p = new Player(m);
        assertSimpleTest(() -> {
            runException("3000", "11,22,33,44,8.12");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호 중 숫자가 아닌 것이 있을 경우 예외가 발생한다.")
    @Test
    void 당첨번호중_숫자아닌것_있는지확인(){
        Manager m = new Manager();
        Player p = new Player(m);
        assertSimpleTest(() -> {
            runException("3000", "11,22,33,44,55,abc");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호 중 범위를 벗어난 것이 있는 경우 예외가 발생한다.")
    @Test
    void 당첨번호_범위_확인(){
        Manager m = new Manager();
        Player p = new Player(m);
        assertSimpleTest(() -> {
            runException("3000", "11,22,33,44,55,66");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호 중 중복된 것이 있는 경우 예외가 발생한다.")
    @Test
    void 당첨번호중_중복이_있는지확인(){
        Manager m = new Manager();
        Player p = new Player(m);
        assertSimpleTest(() -> {
            runException("3000", "11,22,33,44,22,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
