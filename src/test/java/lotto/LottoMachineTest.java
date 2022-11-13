package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class LottoMachineTest extends NsTest {

    @Test
    void 입력받은_금액만큼_로또를_생성합니다() {
        assertSimpleTest(() -> {
            run("8000");
        });

        assertThat(output()).contains("8개를 구매했습니다.");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
