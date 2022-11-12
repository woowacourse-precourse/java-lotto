package lotto.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

	@DisplayName("사용자의 로또 번호가 당첨번호와 6개 일치한다면 Rank.FIRST 를 가진다.")
	@Test
	void checkRankFirstFromUserLottoTest() {
		/*
		  ==== given ====
		  winning : 당첨 로또
		  bonusNumber : 당첨 로또 보너스 번호
		  userLotto : 사용자가 산 로또
		 */
		final Lotto winning = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		final int bonusNumber = 7;
		final Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

		WinningLotto winningLotto = new WinningLotto(winning, bonusNumber);

		// when : 사용자 로또와 당첨로또를 비교할 때 전부 일치하는 로또번호이기에 1등을 반환해야 한다.
		Rank result = winningLotto.compareTo(userLotto);

		// then : 1등을 반환하는지 확인
		final Rank expected = Rank.FIRST;
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("사용자의 로또 번호가 당첨번호와 5개 일치하고 보너스 번호가 일치한다면 Rank.SECOND 를 가진다.")
	@Test
	void checkRankSecondFromUserLottoTest() {
		/*
		  ==== given ====
		  winning : 당첨 로또
		  bonusNumber : 당첨 로또 보너스 번호
		  userLotto : 사용자가 산 로또
		 */
		final Lotto winning = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		final int bonusNumber = 7;
		final Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

		WinningLotto winningLotto = new WinningLotto(winning, bonusNumber);

		// when : 사용자 로또와 당첨로또를 비교할 때 5개가 일치하고, 사용자 로또 번호가 보너스 번호를 포함하기에 2등을 반환.
		Rank result = winningLotto.compareTo(userLotto);

		// then : 2등을 반환하는지 확인
		final Rank expected = Rank.SECOND;
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("사용자의 로또 번호가 당첨번호와 5개 일치하고 보너스 번호는 불일치한다면 Rank.THIRD 를 가진다.")
	@Test
	void checkRankThirdFromUserLottoTest() {
		/*
		  ==== given ====
		  winning : 당첨 로또
		  bonusNumber : 당첨 로또 보너스 번호
		  userLotto : 사용자가 산 로또
		 */
		final Lotto winning = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		final int bonusNumber = 7;
		final Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 30));

		WinningLotto winningLotto = new WinningLotto(winning, bonusNumber);

		// when : 사용자 로또와 당첨로또를 비교할 때 5개가 일치하고, 사용자 로또 번호가 보너스 번호를 포함 안하기에 3등을 반환.
		Rank result = winningLotto.compareTo(userLotto);

		// then : 3등을 반환하는지 확인
		final Rank expected = Rank.THIRD;
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("사용자의 로또 번호가 당첨번호와 4개 일치하고 보너스 번호는 포함 안하면 Rank.FOURTH 를 가진다.")
	@Test
	void checkRankFourthFromUserLottoTest() {
		/*
		  ==== given ====
		  winning : 당첨 로또
		  bonusNumber : 당첨 로또 보너스 번호
		  userLotto : 사용자가 산 로또
		 */
		final Lotto winning = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		final int bonusNumber = 7;
		final Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 21, 31));

		WinningLotto winningLotto = new WinningLotto(winning, bonusNumber);

		// when : 사용자 로또와 당첨로또를 비교할 때 4개가 일치하고, 사용자 로또 번호가 보너스 번호를 포함 안하기에 4등을 반환.
		Rank result = winningLotto.compareTo(userLotto);

		// then : 4등을 반환하는지 확인
		final Rank expected = Rank.FOURTH;
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("사용자의 로또 번호가 당첨번호와 4개 일치하고 보너스 번호는 포함해도 Rank.FOURTH 를 가진다.")
	@Test
	void checkRankFourthWithBonusNumberFromUserLottoTest() {
		/*
		  ==== given ====
		  winning : 당첨 로또
		  bonusNumber : 당첨 로또 보너스 번호
		  userLotto : 사용자가 산 로또
		 */
		final Lotto winning = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		final int bonusNumber = 7;
		final Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 21, 7));

		WinningLotto winningLotto = new WinningLotto(winning, bonusNumber);

		// when : 사용자 로또와 당첨로또를 비교할 때 4개가 일치하고, 사용자 로또 번호가 보너스 번호를 포함해도 4등을 반환.
		Rank result = winningLotto.compareTo(userLotto);

		// then : 4등을 반환하는지 확인
		final Rank expected = Rank.FOURTH;
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("사용자의 로또 번호가 당첨번호와 3개 일치하고 보너스 번호는 포함해도 안해도 Rank.FIFTH 를 가진다.")
	@Test
	void checkRankFifthFromUserLottoTest() {
		/*
		  ==== given ====
		  winning : 당첨 로또
		  bonusNumber : 당첨 로또 보너스 번호
		  userLotto : 사용자가 산 로또
		 */
		final Lotto winning = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		final int bonusNumber = 7;
		final Lotto userLotto = new Lotto(List.of(1, 2, 3, 11, 21, 31));

		WinningLotto winningLotto = new WinningLotto(winning, bonusNumber);

		// when : 사용자 로또와 당첨로또를 비교할 때 3개가 일치하고, 사용자 로또 번호가 보너스 번호를 포함 여부 상관없이 5등을 반환.
		Rank result = winningLotto.compareTo(userLotto);

		// then : 5등을 반환하는지 확인
		final Rank expected = Rank.FIFTH;
		assertThat(result).isEqualTo(expected);
	}

	@ParameterizedTest(name = "사용자의 로또 번호가 1개 또는 2개만 일치하거나 아예 일치하는게 없을 경우 " +
			"보너스 번호에 관계없이 Rank.NONE 를 가진다")
	@MethodSource("generateLottoNumbers")
	void checkRankNoneTest(Lotto winning, Lotto userLotto) {
		WinningLotto winningLotto = new WinningLotto(winning, 45);

		Rank result = winningLotto.compareTo(userLotto);

		final Rank expected = Rank.NONE;
		assertThat(result).isEqualTo(expected);
	}

	private static Stream<Arguments> generateLottoNumbers() {
		final List<Integer> winning = List.of(1, 2, 3, 4, 5, 6);

		return Stream.of(
				Arguments.of(new Lotto(winning), new Lotto(List.of(1, 2, 13, 14, 15, 16))),
				Arguments.of(new Lotto(winning), new Lotto(List.of(1, 12, 13, 14, 15, 16))),
				Arguments.of(new Lotto(winning), new Lotto(List.of(11, 12, 13, 14, 15, 16)))
		);
	}
}