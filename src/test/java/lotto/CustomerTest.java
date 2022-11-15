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

	@DisplayName("예외: 로또 구매 시 금액이 int가 아닌 경우")
	@Test
	void isIntegerAmount() {
		run("1000ㅇ");
		customer.inputAmount();
		assertThat(output()).contains(ERROR_MESSAGE);
	}
	
	@DisplayName("예외: 로또 구매 시 금액이 정해진 단위로 나누어 떨어지지 않는 경우")
	@Test
	void isUnitAmount() {
		run("1300");
		customer.inputAmount();
		assertThat(output()).contains(ERROR_MESSAGE);
	}

	@Override
	public void runMain() {
		return;
	}
}
