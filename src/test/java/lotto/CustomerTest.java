package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest extends NsTest {
	private static final String ERROR_MESSAGE = "[ERROR]";
	private static final Customer customer = new Customer();

	@DisplayName("로또 구매 시 금액이 정상적인 경우")
	@Test
	void validLottoAmount() {
		run("1000");
		customer.inputAmount();
		assertThat(customer.getAmount()).isEqualTo(1000);
	}

        input("1000");
        customer.inputAmount();

	@Override
	public void runMain() {
		return;
	}
}
