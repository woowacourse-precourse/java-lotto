package lotto;


import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class InputTest extends NsTest {
    @Test
    void 입력금액_숫자정규식_테스트(){
        assertSimpleTest(() -> {
            run("1000j");
            assertThat(output()).isEqualTo("[ERROR] 입력 값이 숫자가 아닙니다.");
        });
    }

    @Test
    void 입력금액단위_테스트(){
        assertSimpleTest(() -> {
            run("1010");
            assertThat(output()).isEqualTo("[ERROR] 입력하신 금액은 1,000원 단위가 아닙니다.");
        });
    }

    @Override
    protected void runMain() {
        try {
            Application.main(new String[]{
                    String.valueOf(new Input().getCash())
            });
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
