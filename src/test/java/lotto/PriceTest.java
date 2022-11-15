package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PriceTest extends NsTest {
    @Test
    void 구입금액이_정상적인_경우_테스트() {
        Price price = new Price("8000");
        assertThat(price.get()).isEqualTo(8000);
    }

    @Test
    void 구입금액이_음수인_경우_테스트() {
        assertThatThrownBy(() -> new Price("-8000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입금액이_숫자가_아닌_경우_테스트() {
        assertThatThrownBy(() -> new Price("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입금액이_1000으로_나누어_떨어지지_않는_경우_테스트() {
        assertThatThrownBy(() -> new Price("8100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        return;
    }
}
