package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.user.Customer;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomerTest {

    @DisplayName("입력값이 숫자인 경우 Customer 객체를 생성한다.")
    @Test
    void case1_validate_unit() {
        assertThat(new Customer("1000"))
                .isInstanceOf(Customer.class);
    }

    @DisplayName("입력값이 숫자가 아닌 아닌 경우 예외가 발생한다.")
    @Test
    void case2_validate_unit() {
        assertThatThrownBy(() -> new Customer("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매내역을 출력한다.")
    @Test
    void case3_print_out_lotto_list() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            Customer input = new Customer("1000");
            String result = "1개를 구매했습니다.\n" + List.of(1, 2, 3, 4, 5, 6);

            assertThat(input.toLottoString()).isEqualTo(result);
        }, List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("당첨번호와 비교 후 맞는 번호 개수를 출력한다.")
    @Test
    void case4_count_the_duplicate_lotto_numbers() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            Customer input = new Customer("2000");
            List<Integer> winNumber = List.of(1,2,3,4,5,6);
            List<Integer> result = List.of(6,4);

            assertThat(input.matchWinNumbers(winNumber)).isEqualTo(result);
        }, List.of(1, 2, 3, 4, 5, 6),List.of(3,4,5,6,7,8));
    }

    @DisplayName("당첨번호와 비교 후 맞는 번호 개수를 출력한다.")
    @Test
    void case5_count_the_duplicate_bonus_number() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            Customer input = new Customer("2000");
            int bonusNumber = 1;
            List<Integer> result = List.of(1,0);

            assertThat(input.matchBonusNumber(bonusNumber)).isEqualTo(result);
        }, List.of(1, 2, 3, 4, 5, 6),List.of(3,4,5,6,7,8));
    }
}
