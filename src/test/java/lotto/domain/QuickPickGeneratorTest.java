package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class QuickPickGeneratorTest {

	@Test
	void 랜덤_로또_번호_생성기_테스트() {
		List<Integer> lottoNumberCandidates = new ArrayList<>();
		for (int i = 1; i <= 45; i++) {
			lottoNumberCandidates.add(i);
		}

		int count = 3;
		List<Lotto> lotteries = QuickPickGenerator.quickPick(count);

		//입력한 파라미터만큼의 수량을 발행하는가?
		assertThat(lotteries.size()).isEqualTo(count);
	}
}
