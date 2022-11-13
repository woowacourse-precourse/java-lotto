package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	@DisplayName("기존 로또 리스트와 유저의 로또 리스트는 동일")
	void addAndGetLottiesTest() {
		List<Lotto> lotties = new ArrayList<>();
		User user = new User();

		for (int lottoIndex = 0; lottoIndex < 10; lottoIndex++) {
			Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

			lotties.add(lotto);
			user.addLotto(lotto);
		}
		List<Lotto> userLotties = user.getLotties();
		Assertions.assertThat(userLotties).isEqualTo(lotties);
	}
}
