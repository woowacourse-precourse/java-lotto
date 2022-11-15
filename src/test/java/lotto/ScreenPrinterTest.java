package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ScreenPrinterTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    @Test
    public void 예외_테스트_당첨번호_형식() throws Exception{
        assertSimpleTest(() -> {
            runException("1000", "6,1,2,3,4, 5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("1000", "6,1,2,3,4,,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("1000", "6,1,2,3-4-5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    public void 예외_테스트_당첨번호_개수() throws Exception{
        assertSimpleTest(() -> {
            runException("1000", "6,1,2,3,4,5,7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    public void 예외_테스트_보너스번호_형식() throws Exception{
        assertSimpleTest(() -> {
            runException("1000", "6,1,2,3,4,5", "1a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}