package lotto.ExceptionTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest extends NsTest {

    @DisplayName("로또 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByString() {
        assertThatThrownBy(() ->
                runException("1000", "1,2,3,4,5,A")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void createBonusByString() {
        assertThatThrownBy(() -> {
            runException("1000", "1,2,3,4,5,6", "a");
            assertThat(output()).contains("ERROR");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
