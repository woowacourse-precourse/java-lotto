package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

	// 아래에 추가 테스트 작성 가능
	@DisplayName("1000원 단위가 아닌 숫자는 예외가 발생한다.")
	@Test
	void inputMoneyMultiply1000() {
		assertThatThrownBy(
			() -> Exception.UserMoneyDivide1000(8500)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("구입한 로또 갯수에 맞게끔 발행이 잘 되었는지 확인한다")
	@Test
	void checkUserLotto() {
		UserLotto userLotto = new UserLotto(5);
		Assertions.assertThat(userLotto.getUserLottoes().size()).isEqualTo(5);
		for (Lotto lotto : userLotto.getUserLottoes()) {
			List<Integer> numbers = lotto.getNumbers();
			Assertions.assertThat(numbers.size()).isEqualTo(6);
			for (Integer number : numbers) {
				Assertions.assertThat(number).isBetween(1, 45);
			}
		}
	}

	@DisplayName("당첨번호 입력 테스트. ','로 나눴을떄 길이가 6이 나와야한다.")
	@Test
	void inputWinningLottoLength() {
		assertThatThrownBy(
			() -> Exception.validateLottoLength(new String[] {"1", "4", "6", "7", "4"})
		).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("당첨번호 입력 테스트. ','로 나눴을때, 각 문자열은 숫자이고, 1~45사이 수여야한다.")
	@Test
	void inputWinningLottoIntegerAndRange() {
		assertThatThrownBy(
			() -> Exception.validateLottoNumberRange(new String[] {"1", "4", "6", "7", "4", "0"})
		).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("당첨번호 또한, 중복된 번호가 없어야한다.")
	@Test
	void inputWinningLottoDuplicateCheck(){
		assertThatThrownBy(
			() -> Exception.validateDuplicateNumbers(new String[] {"1","2","3","4","5","1"})
		).isInstanceOf(IllegalArgumentException.class);
	}
}
