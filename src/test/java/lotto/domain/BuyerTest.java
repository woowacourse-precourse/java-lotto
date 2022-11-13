package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BuyerTest {



	@ParameterizedTest
	@DisplayName("로또 구입 금액만큼 로또 장수가 일치하는지 확인하는 테스트")
	@ValueSource(ints = {1000, 5000, 123000})
	void checkLottoCountTest(int input) {
		Buyer buyer = Buyer.buyLottos(input);
		Assertions.assertThat(input / ConstValue.LOTTO_PRICE).isEqualTo(buyer.getLotto().size());
	}
}
