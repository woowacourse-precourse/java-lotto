package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import store.LottoMachine;
import user.Customer;

import java.lang.reflect.Method;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomerTest {

    @DisplayName("입력값이 숫자인 경우 Customer 객체 생성")
    @Test
    void case1_validate_unit() {
        assertThat(new Customer("1000"))
                .isInstanceOf(Customer.class);
    }

    @DisplayName("입력값이 숫자가 아닌 아닌 경우 예외 발생")
    @Test
    void case2_validate_unit() {
        assertThatThrownBy(() -> new Customer("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매내역 출력")
    @Test
    void case3_print_out_lotto_list() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            Customer input = new Customer("1000");
            String result = "1개를 구매했습니다.\n"+List.of(1, 2, 3, 4, 5, 6)+"\n";

            assertThat(input.toLottoString()).isEqualTo(result);
        }, List.of(1, 2, 3, 4, 5, 6));
    }
}
