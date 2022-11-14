package lotto;

import lotto.domain.Customer;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomerTest {
    @DisplayName("번호가 5개 입력되면 예외가 발생한다")
    @Test
    void generateWinningNumberByFiveNumbers() {
        Customer customer = new Customer();

        assertThatThrownBy(() -> customer.generateWinningNumber(List.of(1, 2, 3, 4, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1과 45사이가 아닌 번호가 입력되면 예외가 발생한다")
    @Test
    void generateWinningNumberByOutOfRangeNumber() {
        Customer customer = new Customer();

        assertThatThrownBy(() -> customer.generateWinningNumber(List.of(1, 2, 3, 4, 5, 46), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("번호에 중복이 있으면 예외가 발생한다")
    @Test
    void generateWinningNumberByDuplicatedNumbers() {
        Customer customer = new Customer();

        assertThatThrownBy(() -> customer.generateWinningNumber(List.of(1, 2, 3, 4, 5, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1과 45사이의 중복없는 번호 6개 리스트와 번호 1개를 입력하면 당첨번호가 생성된다")
    @Test
    void generateWinningNumber() {
        Customer customer = new Customer();

        assertThat(customer.generateWinningNumber(List.of(1, 2, 3, 4, 5, 6), 7)).isInstanceOf(WinningNumber.class);
    }

    @DisplayName("1000원 단위가 아닌 값을 입력하면 예외가 발생한다")
    @Test
    void generateLottosByNotUnitOf1000() {
        Customer customer = new Customer();
        int money = 1100;

        assertThatThrownBy(() -> customer.purchaseLottos(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0원 이하의 값을 입력하면 예외가 발생한다")
    @Test
    void generateLottosByUnderZero() {
        Customer customer = new Customer();
        int money = 0;

        assertThatThrownBy(() -> customer.purchaseLottos(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈을 입력하면 금액만큼 로또를 생성한다")
    @Test
    void generateLottosByMoney() {
        Customer customer = new Customer();
        int money = 6000;
        int result = 6;

        Lottos lottos = customer.purchaseLottos(money);

        assertThat(lottos.getLottoCount()).isEqualTo(result);
    }
}
