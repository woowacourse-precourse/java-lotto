package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LotteryMachineTest {

	@DisplayName("로또를 자동으로 발행한다.")
	@Test
	void 로또_자동_발행_테스트() {
		Lotto lotto = LotteryMachine.autoGenerate();
		assertThat(lotto).isNotNull();
	}
}
