package lotto.views;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

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
}