package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoAmountTest{

	@ParameterizedTest
	@ValueSource(ints = {100, 10, 123, 1123, 1000012310})
	@DisplayName("값 입력 후 예외 로직 체크")
	void amountTest(int money) {
		assertThrows(IllegalArgumentException.class, () -> new LottoAmount(money));
	}

	@Test
	@DisplayName("결과 계산 로직 체크")
	void calculateTest() {
		List<LottoRanking> lottoRank = new ArrayList<>();
		lottoRank.add(LottoRanking.findLottoRank(5, true));
		lottoRank.add(LottoRanking.findLottoRank(6, false));

		int purchaseMoney = 5000;
		long prizeMoney =  2030000000;
		LottoAmount lottoAmount = new LottoAmount(purchaseMoney);
		LottoResult lottoResult = new LottoResult(lottoRank);
		double result = lottoAmount.calculatePrizeResult(lottoResult);
		double expected = (double)prizeMoney / purchaseMoney * 100;
		assertEquals(expected, result);
	}
}
