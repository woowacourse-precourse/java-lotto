package lotto.domain.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

	@Test
	void 제대로_동작(){
		Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
		List<Integer> answer = Arrays.asList(1,2,3,4,5,6);

		assertEquals(answer, lotto.getLotto());
	}

	@Test
	void 예외처리_크기(){
		assertSimpleTest(() ->
				assertThatThrownBy(() ->  new Lotto(Arrays.asList(1,2,3,4,5,6,7)))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 예외처리_크기2(){
		assertSimpleTest(() ->
				assertThatThrownBy(() ->  new Lotto(Arrays.asList(1,2,3)))						.isInstanceOf(IllegalArgumentException.class)
		);
	}
}