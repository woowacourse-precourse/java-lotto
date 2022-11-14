package lotto.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

	@DisplayName("사용자가 로또 1만원을 구매했을 때 5등을 5번 했다면, 수익률은 250%여야 한다.")
	@Test
	void test() {
		// given : 사용자가 구매한 로또들의 결과가 5등 5번, 구매한 로또의 총 가격은 1만원이 들었을 때
		final Map<Rank, Long> lotteriesCountingResult = new HashMap<>() {{
			put(Rank.FIFTH, 5L); // 5등 5번
		}};
		LottoResult lottoResult = new LottoResult(lotteriesCountingResult);
		final int purchaseAmount = 10000;

		// when : 당첨결과에 따라서 나오는 수익률을 계산
		double result = lottoResult.getEarningRate(purchaseAmount);

		// then : 수익률을 맞게 계산했는지 검증
		final double expected = 250.0;
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("사용자가 로또 8천원을 구매했을 때 5등을 1번 했다면, 수익률은 62.5%여야 한다.")
	@Test
	void checkUserPurchaseAmount8000AndFifthRankOnceTest() {
		// given : 사용자가 구매한 로또들의 결과가 5등 1번, 구매한 로또의 총 가격은 8천원이 들었을 때
		final Map<Rank, Long> lotteriesCountingResult = new HashMap<>() {{
			put(Rank.FIFTH, 1L); // 5등 1번
		}};
		LottoResult lottoResult = new LottoResult(lotteriesCountingResult);
		final int purchaseAmount = 8000;

		// when : 당첨결과에 따라서 나오는 수익률을 계산
		double result = lottoResult.getEarningRate(purchaseAmount);

		// then : 수익률을 맞게 계산했는지 검증
		final double expected = 62.5;
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("사용자가 로또 5000원을 구매했을 때 순위권 안에 하나도 못 들어갔다면, 수익률은 0%여야 한다.")
	@Test
	void checkUserEarningRateWhenLotteriesAllOutOfRankTest() {
		// given : 사용자가 구매한 로또들의 결과가 모두 순위권 밖, 구매한 로또의 총 가격은 5천원이 들었을 때
		final Map<Rank, Long> lotteriesCountingResult = new HashMap<>();
		LottoResult lottoResult = new LottoResult(lotteriesCountingResult);
		final int purchaseAmount = 8000;

		// when : 당첨결과에 따라서 나오는 수익률을 계산
		double result = lottoResult.getEarningRate(purchaseAmount);

		// then : 수익률을 맞게 계산했는지 검증
		final double expected = 0.0;
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("사용자가 로또 6000원을 구매했을 때 5등을 1번 했다면, 수익률은 83.3%여야 한다.")
	@Test
	void checkUserEarningRateWhenFifthOnceRankTest() {
		// given : 사용자가 구매한 로또들의 결과가 5등 1번, 구매한 로또의 총 가격은 6천원이 들었을 때
		final Map<Rank, Long> lotteriesCountingResult = new HashMap<>() {{
			put(Rank.FIFTH, 1L); // 5등 1번
		}};
		LottoResult lottoResult = new LottoResult(lotteriesCountingResult);
		final int purchaseAmount = 6000;

		// when : 당첨결과에 따라서 나오는 수익률을 계산
		double result = lottoResult.getEarningRate(purchaseAmount);

		// then : 수익률을 맞게 계산했는지 검증
		final double expected = 83.3;
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("사용자가 로또 6000원을 구매했을 때 5등을 2번 했다면, 수익률은 166.7%여야 한다.")
	@Test
	void checkUserEarningRateWhenFifthTwiceRankTest() {
		// given : 사용자가 구매한 로또들의 결과가 5등 2번, 구매한 로또의 총 가격은 6천원이 들었을 때
		final Map<Rank, Long> lotteriesCountingResult = new HashMap<>() {{
			put(Rank.FIFTH, 2L); // 5등 2번
		}};
		LottoResult lottoResult = new LottoResult(lotteriesCountingResult);
		final int purchaseAmount = 6000;

		// when : 당첨결과에 따라서 나오는 수익률을 계산
		double result = lottoResult.getEarningRate(purchaseAmount);

		// then : 수익률을 맞게 계산했는지 검증
		final double expected = 166.7;
		assertThat(result).isEqualTo(expected);
	}
}