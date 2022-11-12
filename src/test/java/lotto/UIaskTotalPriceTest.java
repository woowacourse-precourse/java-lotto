package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;

class UIaskTotalPriceTest extends NsTest {
	private static final String ERROR_MESSAGE = "[ERROR]";
	
	@DisplayName("가격을 입력받을 때 가격이 1000이상의 숫자가 아니면 예외가 발생한다.")
	@Test
	void PriceShouldBeLess1000() {
		assertSimpleTest(() -> 
			assertThatThrownBy(() -> runException("999"))
            	.isInstanceOf(IllegalArgumentException.class)
            	.hasMessageContaining(ERROR_MESSAGE)
		);
	}
	
	@DisplayName("가격을 입력받을 때 가격이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
	@Test
	void PriceShouldBeDividedBy1000() {
		assertSimpleTest(() -> 
		assertThatThrownBy(() -> runException("1983"))
        	.isInstanceOf(IllegalArgumentException.class)
        	.hasMessageContaining(ERROR_MESSAGE)
	);
	}

	@Override
	protected void runMain() {
		Application.main(new String[]{});
	}

}
