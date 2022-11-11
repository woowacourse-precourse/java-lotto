package lotto.views;

import lotto.models.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
				.isInstanceOf(IllegalArgumentException.class);
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
}