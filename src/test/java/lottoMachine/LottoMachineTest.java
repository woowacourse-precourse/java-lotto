package lottoMachine;

import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 당첨번호의_형식이_지켜지지_않을_경우_예외가_발생합니다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("5000", "1,2,3,4,5", "7"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 당첨번호가_중복될_경우_예외가_발생합니다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("5000", "1,2,3,4,5,5", "7"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 당첨번호의_범위가_1에서_45사이가_아닐_경우_예외가_발생합니다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("5000", "1,2,3,4,45,46", "7"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
