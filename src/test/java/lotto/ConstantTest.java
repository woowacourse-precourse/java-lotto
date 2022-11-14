package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConstantTest {
	@Test
	void 값이_잘_나오는지(){
		assertThat(Constant.MIN_VALUE.getNumber()).isEqualTo(1);
		assertThat(Constant.FIRST_PRIZE.getNumber()).isEqualTo(2000000000);
	}
}
