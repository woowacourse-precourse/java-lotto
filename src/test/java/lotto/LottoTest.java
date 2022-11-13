package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.controller.dto.WinnerNumberDto;
import lotto.domain.Lotto;
import lotto.domain.dto.WinnerCountDto;

class LottoTest {
	@DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
	@Test
	void createLottoByOverSize() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	@Test
	void createLottoByDuplicatedNumber() {
		// TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest(name = "로토 번호가 1~45 가 아닌 경우 테스트")
	@ValueSource(ints = {-1, 46, 0})
	public void createLottoByOverNumberSize() {
		assertThatThrownBy(() -> new Lotto(List.of(-1, 2, 3, 4, 5, 6)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("사용자가 구매한 로또번호가 몇개 맞췄는지와 보너스 번호 맞췄는지 확인하는 테스트")
	@Test
	public void check_countWinnerNumber() {
		//given
		Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
		WinnerNumberDto winnerNumberDto = new WinnerNumberDto(List.of(1, 2, 3, 4, 5, 6));
		winnerNumberDto.setBonusNumber(7);

		//when
		WinnerCountDto winnerCountDto = lotto.countWinnerNumber(winnerNumberDto);

		//then
		Assertions.assertThat(winnerCountDto.getAnswerCount()).isEqualTo(5);
		Assertions.assertThat(winnerCountDto.getBonusCount()).isEqualTo(1);
	}

	@DisplayName("로또 번호 문자열로 만드는 메서드 확인 테스트")
	@Test
	public void check_toString() {
		//given
		Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

		//when
		String lottoToString = lotto.toString();

		//then
		Assertions.assertThat(lottoToString).isEqualTo("[1, 2, 3, 4, 5, 7]");
	}

}
