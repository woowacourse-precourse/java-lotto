package lotto;

import jdk.jshell.execution.Util;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnitTest {

	@Test
	void 랜덤_숫자_추출_테스트(){
		int randomNum = Util.getRandomNum(1, 45);
		Assertions.assertThat(randomNum)
				.isGreaterThanOrEqualTo(1)
				.isLessThanOrEqualTo(45);
	}

}
