package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;

import org.junit.jupiter.api.Test;

class PurchaseTest extends NsTest {

    @Test
    void 양수가_아닌경우_예외처리() {
        assertThatThrownBy(() -> new Purchase(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 조건대로_나누어떨어지지_않는경우_예외처리() {
        assertThatThrownBy(() -> new Purchase(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}