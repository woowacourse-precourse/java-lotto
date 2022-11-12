package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest extends NsTest {
    @DisplayName("구매 금액에 한글이 들어있는 경우 예외가 발생한다.")
    @Test
    void koreanInFee() {
        assertThatThrownBy(() -> run("2000원"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액에 영어가 들어있는 경우 예외가 발생한다.")
    @Test
    void englishInFee() {
        assertThatThrownBy(() -> run("2000Won"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 1000원 단위가 아닌 경우 예외가 발생한다.")
    @Test
    void notDividedBy1000() {
        assertThatThrownBy(() -> run("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        Customer customer = new Customer();
        customer.pay();
    }
}