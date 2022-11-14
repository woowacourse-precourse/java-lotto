package lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.testUtil;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest extends testUtil {
    @DisplayName("로또 구매 시 금액이 정상적인 경우")
    @Test
    void validLottoAmount() {
        Customer customer = new Customer();

        input("1000");
        customer.inputAmount();

        assertThat(customer.getAmount()).isEqualTo(1000);
    }
}
