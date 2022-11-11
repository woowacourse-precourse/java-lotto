package lotto.views;

import lotto.constants.Message;
import lotto.models.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ReaderTest {
	public static InputStream generateInputStream(String input) {
		return new ByteArrayInputStream(input.getBytes());
	}

	@DisplayName("사용자가 로또 정상적인 구입 금액을 입력하는 테스트")
	@Test
	void inputUserValidPurchaseAmount() {
		// given : 사용자가 구입할 금액을 다음과 같이 입력한다고 가정.
		final String PURCHASE_AMOUNT_INPUT = "3000";
		InputStream inputStream = generateInputStream(PURCHASE_AMOUNT_INPUT);
		System.setIn(inputStream);

		// when : 사용자의 구입금액을 입력받을 때
		int result = Reader.readUserLottoPurchaseAmount();

		// then : int type 으로 정상적으로 반환하는지 확인
		final int expected = 3000;
		assertThat(result).isEqualTo(expected);
	}

	@ParameterizedTest(name = "사용자가 적절하지 않은 로또 구입금액''''{0}''''을 입력했을 경우 예외를 던짐")
	@ValueSource(strings = {" ", " \n ", "123", "01000", "1000a", "999", "0", "500", "1500"})
	void checkInvalidPurchaseAmountTest(String purchaseAmount) {
		InputStream inputStream = generateInputStream(purchaseAmount);
		System.setIn(inputStream);

		assertThatThrownBy(Reader::readUserLottoPurchaseAmount)
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(Message.ERROR_PREFIX);
	}

	@DisplayName("사용자가 정상적인 로또 당첨 번호를 입력했을 때 확인하는 테스트")
	@Test
	void inputUserValidWinningLottoNumberTest() {
		final String WINNING_LOTTO_NUMBER = "1,2,3,4,5,6";
		InputStream inputStream = generateInputStream(WINNING_LOTTO_NUMBER);
		System.setIn(inputStream);

		Lotto lotto = Reader.readUserLottoWinningNumber();
		List<Integer> winningLottoNumber = lotto.getLottoNumber();

		final List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
		assertThat(winningLottoNumber).hasSameElementsAs(expected);
	}

	@ParameterizedTest(name = "콤마 안에 숫자가 아닌 문자가 존재={0} ==> 예외를 던짐")
	@ValueSource(strings = {"1,2,3,4,a,6", "1, 2, 3, 4, 5, 6", "a,b,c,d,e,f"})
	void checkWinningLottoNumberHasNotOnlyNumericValueTest(String input) {
		InputStream inputStream = generateInputStream(input);
		System.setIn(inputStream);

		assertThatThrownBy(Reader::readUserLottoWinningNumber)
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(Message.ERROR_IS_NOT_NUMERIC_VALUE);
	}

	@DisplayName("공백만 포함된 원소들을 입력으로 받을 때 예외를 던짐 => 입력 숫자는 빈 문자열이면 안되기 때문")
	@Test
	void checkWinningLottoNumberInputHasBlankTest() {
		final String input = " , , , , , ";
		InputStream inputStream = generateInputStream(input);
		System.setIn(inputStream);

		assertThatThrownBy(Reader::readUserLottoWinningNumber)
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(Message.ERROR_EMPTY_INPUT);
	}

	@ParameterizedTest(name = "공백과 숫자가 아닌 문자를 6개를 ,로 구분하여 입력했을 때 예외를 던짐''''{0}'''' " +
			"=> 숫자만 입력되어야 하기 때문")
	@ValueSource(strings = {"1,2,a,4,5,6", "-,1,2,3,4,5", "o,a,g, d, 4, 15"})
	void checkWinningLottoNumberInputIsNotNumericTest(String input) {
		InputStream inputStream = generateInputStream(input);
		System.setIn(inputStream);

		assertThatThrownBy(Reader::readUserLottoWinningNumber)
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(Message.ERROR_IS_NOT_NUMERIC_VALUE);
	}

	@DisplayName("모든 원소는 숫자지만 콤마가 5개가 아닐 때 예외를 던짐 => 로또 번호가 6개가 안되기 때문")
	@Test
	void checkWinningLottoNumberSizeTest() {
		final String input = "1,2,5,3,45";
		InputStream inputStream = generateInputStream(input);
		System.setIn(inputStream);

		assertThatThrownBy(Reader::readUserLottoWinningNumber)
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(Message.ERROR_INVALID_LOTTO_LENGTH);
	}

	@DisplayName("숫자만 입력된 6개 원소를 가지는 입력에 대해, 0으로 시작하는 원소가 존재하면 예외 던진다.")
	@Test
	void checkWinningLottoNumberHasZeroValueTest() {
		final String input = "1,09,2,34,5,6";
		InputStream inputStream = generateInputStream(input);
		System.setIn(inputStream);

		assertThatThrownBy(Reader::readUserLottoWinningNumber)
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(Message.ERROR_FIRST_CHAR_IS_ZERO);
	}

	@ParameterizedTest(name = "숫자만 입력된 6개 원소를 가지는 입력에 대해''''{0}'''', 1~45 사이의 원소가 아니면 예외를 던진다.")
	@ValueSource(strings = {"1,2,3,46,7,8", "100,101,102,103,104,105"})
	void checkWinningLottoNumberHasInvalidRangeValue(String input) {
		InputStream inputStream = generateInputStream(input);
		System.setIn(inputStream);

		assertThatThrownBy(Reader::readUserLottoWinningNumber)
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(Message.ERROR_HAS_INVALID_LOTTO_NUMBER_VALUE);
	}

	@DisplayName("중복된 숫자들을 입력했을 경우 예외를 던짐")
	@Test
	void checkDuplicatedWinningLottoNumberTest() {
		final String input = "1,1,2,3,4,5";
		InputStream inputStream = generateInputStream(input);
		System.setIn(inputStream);

		assertThatThrownBy(Reader::readUserLottoWinningNumber)
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(Message.ERROR_HAS_DUPLICATED_LOTTO_NUMBER);
	}
}