package lotto;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;

public class CheckerTest extends NsTest {

	@Test
	void checkNumberOnlyException_메서드로_숫자외의_입력_예외처리() {

		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("ㅁ"))
				.isInstanceOf(IllegalArgumentException.class)
		);

	}

	@Test
	void checkMaxPrice_메서드로_10만원이상_구매시_예외처리() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("1000000"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}
