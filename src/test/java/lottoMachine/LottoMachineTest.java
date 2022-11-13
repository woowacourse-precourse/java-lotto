package lottoMachine;

import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.Test;

public class LottoMachineTest extends NsTest {

    @Test
    void 입력받은_금액만큼_로또를_생성합니다() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,6", "7");
        });

        assertThat(output()).contains("8개를 구매했습니다.");
    }

    @Test
    void 당첨번호의_형식이_지켜지지_않을_경우_에러메세지_출력() {
        assertSimpleTest(() -> {
            run("5000", "1,2,3,4,5", "7");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Test
    void 당첨번호가_중복될_경우_에러메세지_출력() {
        assertSimpleTest(() -> {
            run("5000", "1,2,3,4,5,5", "7");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Test
    void 당첨번호의_범위가_1에서_45사이가_아닐_경우_에러메세지_출력() {
        assertSimpleTest(() -> {
            run("5000", "1,2,3,4,45,46", "7");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Test
    void 보너스번호가_하나가_아니면_에러메세지_출력() {
        assertSimpleTest(() -> {
            run("5000", "1,2,3,4,5,6", "7,8");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Test
    void 보너스번호가_당첨번호와_중복되면_에러메세지_출력() {
        assertSimpleTest(() -> {
            run("5000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
