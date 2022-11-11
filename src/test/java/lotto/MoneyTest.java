package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Model.Money;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
class MoneyTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 문자열_포함_테스트() {
        assertThatThrownBy(() -> Money.setInputMoney("1000j"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 천원단위가_아닐때() {
        assertSimpleTest(() -> {
            runException("10014");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
