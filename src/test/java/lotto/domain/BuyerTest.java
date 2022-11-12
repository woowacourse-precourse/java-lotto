package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BuyerTest {

	@Test
	@DisplayName("로또를 입력 받을 경우 정렬이 되는지 확인하는 테스트")
	void checkSortedNumberTest() {
		Buyer buyer = new Buyer("1000");
		Assertions.assertThat(buyer.getLotto().get(0).getNumbers()).isSorted();
	}

	@ParameterizedTest
	@DisplayName("로또 구입 금액만큼 로또 장수가 일치하는지 확인하는 테스트")
	@ValueSource(strings = {"1000", "5000", "123000"})
	void checkLottoCountTest(String input) {
		Buyer buyer = new Buyer(input);
		Assertions.assertThat(Integer.parseInt(input) / 1000).isEqualTo(buyer.lottoCount());
	}
}
