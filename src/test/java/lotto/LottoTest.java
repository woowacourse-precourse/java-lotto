package lotto;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
	void inputWinningLottoDuplicateCheck() {
		assertThatThrownBy(
			() -> Exception.validateDuplicateNumbers(new String[] {"1", "2", "3", "4", "5", "1"})
		).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("보너스번호 또한,숫자 이외의 엽력을 받을 수 없다.")
	@Test
	void inputWinningLottoBonusNumberIntegerCheck() {
		assertThatThrownBy(
			() -> Exception.validateNumber("12j")
		).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("보너스번호 또한, 1부터 45 이내의 숫자여야만 한다.")
	@Test
	void inputWinningLottoBonusNumberRange() {
		assertThatThrownBy(
			() -> Exception.validateLottoNumberRange("46")
		).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("보너스번호 또한, 발행된 당첨번호와 중복되어선 안된다.")
	@Test
	void inputWinningLottoBonusNumberDuplicateCheck() {
		assertThatThrownBy(
			() -> Exception.validateDuplicateNumbers(
				new Lotto(List.of(1, 2, 3, 4, 5, 6)), "3")
		).isInstanceOf(IllegalArgumentException.class);
	}

	//유저의 발행된 로또 셋과, 당첨번호간 비교 테스트.
	//로직 -> 유저로또set과 당첨번호를 발급 받으면, 유저 로또 하나와 당첨번호 하나를 compare한다
	//해당 과정은 3개, 4개, 5개, 6개(보너스포함) , 6개를 통해 5,4,3,2,1등을 판별하고, 이를 user의 당첨등수에 더한다.
	//이 "몇개"를 통과받았는지에 대한 테스트 코드를 먼저 적는다.

	@DisplayName("당첨 로또번호와 3개가 일치하면, 0번째원소가 1 증가한다.")
	@Test
	void matchCorrect3Numbers(){
		List<Integer> userLotto = List.of(1,2,3,4,5,6);
		List<Integer> winningLotto = List.of(1,2,3,45,44,43);
		Integer bonusNumber = 6;

		CorrectLottoNumber correctLottoNumber = new CorrectLottoNumber();
		correctLottoNumber.calculateCorrectNumber(userLotto,winningLotto,bonusNumber);

		assertThat(correctLottoNumber.getCorrectLottoNumber().get(0)).isEqualTo(1);
	}

	@DisplayName("당첨 로또번호 4개와 일치하면, 1번째원소가 1 증가한다.")
	@Test
	void matchCorrect4Numbers(){
		List<Integer> userLotto = List.of(1,2,3,4,5,6);
		List<Integer> winningLotto = List.of(1,2,3,4,44,43);
		Integer bonusNumber = 6;

		CorrectLottoNumber correctLottoNumber = new CorrectLottoNumber();
		correctLottoNumber.calculateCorrectNumber(userLotto,winningLotto,bonusNumber);

		assertThat(correctLottoNumber.getCorrectLottoNumber().get(1)).isEqualTo(1);
	}
	@DisplayName("당첨 로또번호 5개와 일치하면, 2번째원소가 1 증가한다.")
	@Test
	void matchCorrect5Numbers(){
		List<Integer> userLotto = List.of(1,2,3,4,5,6);
		List<Integer> winningLotto = List.of(1,2,3,5,4,43);
		Integer bonusNumber = 6;

		CorrectLottoNumber correctLottoNumber = new CorrectLottoNumber();
		correctLottoNumber.calculateCorrectNumber(userLotto,winningLotto,bonusNumber);

		assertThat(correctLottoNumber.getCorrectLottoNumber().get(2)).isEqualTo(1);
	}
	@DisplayName("당첨 로또번호 5개 + 보너스번호와 일치하면, 3번째원소가 1 증가한다.")
	@Test
	void matchCorrect6NumbersContainBonusNumber(){
		List<Integer> userLotto = List.of(1,2,3,4,5,6);
		List<Integer> winningLotto = List.of(1,2,3,5,4,43);
		Integer bonusNumber = 6;

		CorrectLottoNumber correctLottoNumber = new CorrectLottoNumber();
		correctLottoNumber.calculateCorrectNumber(userLotto,winningLotto,bonusNumber);

		assertThat(correctLottoNumber.getCorrectLottoNumber().get(3)).isEqualTo(1);
	}
	@DisplayName("당첨 로또번호 6개와 일치하면, 4번째원소가 1 증가한다.")
	@Test
	void matchCorrect6Numbers(){
		List<Integer> userLotto = List.of(1,2,3,4,5,6);
		List<Integer> winningLotto = List.of(1,2,3,4,5,6);
		Integer bonusNumber = 9;

		CorrectLottoNumber correctLottoNumber = new CorrectLottoNumber();
		correctLottoNumber.calculateCorrectNumber(userLotto,winningLotto,bonusNumber);

		assertThat(correctLottoNumber.getCorrectLottoNumber().get(4)).isEqualTo(1);
	}
}
