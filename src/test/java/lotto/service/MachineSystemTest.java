package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

class MachineSystemTest {
	WinningLotto winningLotto;

	@BeforeEach
	@DisplayName("당첨번호 셋팅")
	void setup() {
		winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		winningLotto.setBonusNumber("7");
	}

	@Test
	@DisplayName("6개가 일치할 때 1등을 반환해준다.")
	void matchFirstRank() {
		List<Lotto> lottos = new ArrayList<>();
		lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
		Buyer buyer = new Buyer(lottos);
		MachineSystem system = new MachineSystem(buyer, winningLotto);
		Assertions.assertThat(system.matchLotto(buyer.getLotto().get(0))).isEqualByComparingTo(Rank.RANK_1ST);
	}

	@Test
	@DisplayName("5개와 보너스 번호가 일치할 때 2등을 반환해준다.")
	void matchSecondRank() {
		List<Lotto> lottos = new ArrayList<>();
		lottos.add(new Lotto(Arrays.asList(1, 2, 3, 7, 5, 6)));
		Buyer buyer = new Buyer(lottos);
		MachineSystem system = new MachineSystem(buyer, winningLotto);
		Assertions.assertThat(system.matchLotto(buyer.getLotto().get(0))).isEqualByComparingTo(Rank.RANK_2ND);
	}

	@Test
	@DisplayName("2장을 구매했을 때 두 개의 순위 반환이 일치하는지 확인해주는 테스트")
	void matchAllRank() {
		List<Lotto> lottos = new ArrayList<>();
		lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))); // 1등
		lottos.add(new Lotto(Arrays.asList(1, 2, 3, 8, 5, 6))); // 3등
		Buyer buyer = new Buyer(lottos);
		MachineSystem system = new MachineSystem(buyer, winningLotto);
		Assertions.assertThat(system.matchLottos()).containsAll(Arrays.asList(Rank.RANK_1ST, Rank.RANK_3RD));
	}
}
