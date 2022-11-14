package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LotteryMachineTest {

	@DisplayName("로또를 자동으로 발행한다.")
	@Test
	void 로또_자동_발행_테스트() {
		Lotto lotto = LotteryMachine.autoGenerate();
		assertThat(lotto).isNotNull();
	}

	@DisplayName("로또를 지정한 개수 만큼 자동으로 발행한다.")
	@Test
	void 로또_지정_개수_발행_테스트() {
		int lottoSize = 10;
		List<Lotto> lottos = LotteryMachine.autoGenerate(10);
		assertThat(lottos.size()).isEqualTo(lottoSize);
	}
}
