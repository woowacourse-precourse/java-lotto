package lotto;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest extends NsTest {
    @DisplayName("구매 금액을 잘못 입력하여 예외가 발생하는지 체크")
    @Test
    void checkPurchasedMoneyTest() {
        assertSimpleTest(() -> {assertThatThrownBy(() -> runException("0000")).
        isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 구매 금액을 제대로 입력해 주세요.");
        });

        assertSimpleTest(() -> {assertThatThrownBy(() -> runException("300h")).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 구매 금액을 제대로 입력해 주세요.");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
