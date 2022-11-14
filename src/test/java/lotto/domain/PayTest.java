package lotto.domain;

import lotto.domain.model.Pay;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PayTest {

	@Test
	void 천원배수가_아닐_떄(){
		assertSimpleTest(() ->
				assertThatThrownBy(() ->  new Pay(1234))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}

}