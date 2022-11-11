package lotto.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {

	@DisplayName("로또 번호 6개를 발급했을 때 모두 중복이 안된다면 테스트 성공. 실패 시 로또 번호 길이가 6이 아닌 것")
	@Test
	void checkValidLengthLottoNumberTest() {
		// given : 로또번호를 생성하는 로또공장 인스턴스가 주어졌을 때
		LottoFactory factory = new LottoFactory();

		// when : 로또 공장에서 중복이 없는 6개의 숫자를 생성할 때
		List<Integer> uniqueLottoNumber = factory.createUniqueLottoNumber();
		Set<Integer> result = new HashSet<>(uniqueLottoNumber);

		// then : 중복없이 6개의 숫자를 생성했기에 정상적으로 Lotto 번호가 만들어진다.
		final int NON_DUPLICATED_LOTTO_LENGTH = 6;
		assertThat(result.size()).isEqualTo(NON_DUPLICATED_LOTTO_LENGTH);
	}

	@ParameterizedTest(name = "로또 구입 금액:{0} ==> 발급할 수 있는 최대 로또 개수: {1}개. (로또 1개 1000원)")
	@CsvSource(value = {"1000:1", "2000:2", "999:0", "0:0", "3000:3", "5500:5", "91283:91", "1001:1", "2999:2"}, delimiter = ':')
	void issueValidLotteriesTest(int purchaseAmount, int expectedSize) {
		LottoFactory factory = new LottoFactory();

		List<Lotto> resultLotteries = factory.issueLottoNumbersByPurchaseAmount(purchaseAmount);

		assertThat(resultLotteries.size()).isEqualTo(expectedSize);
	}
}