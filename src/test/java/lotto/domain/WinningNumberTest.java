package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumberTest {
	@DisplayName("로또 당첨 번호와 보너스 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	@Test
	void createWinningNumberByDuplicated() {
		Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		BonusNumber bonusNumber = new BonusNumber(1);
		assertThatThrownBy(() -> new WinningNumber(winningLotto, bonusNumber))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest(name = "{index} : 로또 번호 당첨 순위 확인 테스트 (당첨 결과 : {1})")
	@MethodSource("parametersProvider")
	public void 로또_당첨_순위_확인_테스트(List<Integer> userNumbers, LottoRanking expected) {
	    //given
		Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		BonusNumber bonusNumber = new BonusNumber(7);
		WinningNumber winningNumber = new WinningNumber(winningLotto, bonusNumber);
		Lotto userLotto = new Lotto(userNumbers);
		//when
		LottoRanking actual = winningNumber.checkWinning(userLotto);
		//then
		assertThat(actual).isEqualTo(expected);
	}
	static Stream<Arguments> parametersProvider() {
		return Stream.of(
			arguments(List.of(1, 2, 3, 4, 5, 6), LottoRanking.FIRST),
			arguments(List.of(1, 2, 3, 4, 5, 7), LottoRanking.SECOND),
			arguments(List.of(1, 2, 3, 4, 5, 8), LottoRanking.THIRD),
			arguments(List.of(1, 2, 3, 4, 15, 16), LottoRanking.FOURTH),
			arguments(List.of(1, 2, 3, 14, 15, 16), LottoRanking.FIFTH),
			arguments(List.of(11, 12, 13, 14, 15, 16), LottoRanking.BLANK)
		);
	}
}
