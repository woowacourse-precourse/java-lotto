package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

public class MoneyTest extends NsTest {
	private static final String ERROR_MESSAGE = "[ERROR]";

	@DisplayName("1000원 단위의 입력이 아니면 예외가 발생한다.")
	@Test
	public void rightUnitOfMoneyTest() {
		assertSimpleTest(() -> {
			runException("10100");
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@DisplayName("1000원 이하의 입력이면 예외가 발생한다.")
	@Test
	public void underThousandTest() {
		assertSimpleTest(() -> {
			runException("900");
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@DisplayName("숫자가 아닌 입력이면 예외가 발생한다.")
	@Test
	public void numericTest() {
		assertSimpleTest(() -> {
			runException("가나다");
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}
}
