package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static Constant.ErrorMessage.POSITIVE_NUMBER;
import static Constant.ErrorMessage.UNITS_THOUSAND;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 예외 구현 사항
 * 1. 음수인데 1000으로 나눠떨어지는 경우
 * 2. 1000원 단위로 떨어지지 않는 경우
 */

public class PurchaseTest extends NsTest {
    @DisplayName("음수인데 1000으로 나눠떨어지는 경우")
    @Test
    void createPurchaseNegativeAmount() {
        assertSimpleTest(() -> {
            runException("-1000");
            assertThat(output()).contains(POSITIVE_NUMBER);
        });
    }

    @DisplayName("1000원 단위로 떨어지지 않는 경우")
    @Test
    void createNotDivideByThousand() {
        assertSimpleTest(() -> {
            runException("1010");
            assertThat(output()).contains(UNITS_THOUSAND);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
