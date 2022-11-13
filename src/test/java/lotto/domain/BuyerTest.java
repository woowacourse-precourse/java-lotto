package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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

	@ParameterizedTest
	@DisplayName("구매자가 구입한 로또 수 만큼 금액을 반환해준다.")
	@ValueSource(ints = {1000, 3000, 12000})
	void checkTotalAmount(int amount) {
		List<Lotto> lottos = IntStream.range(0, amount / 1000)
			.mapToObj(i -> Lotto.generateLottoNumber())
			.collect(Collectors.toList());

		Buyer buyer = new Buyer(lottos);
		Assertions.assertThat(amount).isEqualTo(buyer.getLottosAmount());
	}
}
