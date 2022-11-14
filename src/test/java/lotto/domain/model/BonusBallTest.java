package lotto.domain.model;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BonusBallTest {

	@Test
	void 제대로_동작(){
		BonusBall bonusBall = new BonusBall("45");
		assertEquals(45, bonusBall.getBonusBall());
	}

	@Test
	void 범위_예외처리_1미만(){
		assertSimpleTest(() ->
				assertThatThrownBy(() ->  new BonusBall("0"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 범위_예외처리_45초과(){
		assertSimpleTest(() ->
				assertThatThrownBy(() ->  new BonusBall("46"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 문자_예외처리(){
		assertSimpleTest(() ->
				assertThatThrownBy(() ->  new BonusBall("4a6"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}
}