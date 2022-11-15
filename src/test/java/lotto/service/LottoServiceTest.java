package lotto.service;

import lotto.dto.ScoreInfo;
import lotto.mock.MockScoreInfo;
import lotto.vo.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoService 테스트")
class LottoServiceTest {
	private final LottoService lottoService = new LottoServiceImpl();

	@Nested
	@DisplayName("주어진 로또 구매 개수만큼 로또를 발행하는 createLottos 테스트")
	class CreateLottosTest {
		@Test
		@DisplayName("주어진 LottoBuyingInfo 값만큼 새로운 Lotto 객체를 만들어 반환한다.")
		void givenLottoBuyingInfo_whenCreatingLotto_thenReturnsListOfLotto() {
			//given
			LottoBuyingInfo lottoBuyingInfo = new LottoBuyingInfo("10000");

			//when
			List<Lotto> result = lottoService.createLottos(lottoBuyingInfo);

			//then
			assertThat(result).hasSize(10);
		}
	}

	@Nested
	@DisplayName("주어진 로또와 당첨 번호 정보로 당첨 정보를 계산하는 makeScoreInfoBy 테스트")
	class MakeScoreInfoBy {
		@Test
		@DisplayName("발행한 로또 번호와 주어진 당첨 번호 정보를 비교해 당첨 정보를 반환한다.")
		void givenLottosAndWinning_whenMakingScoreInfo_thenReturnsScoreInfo() {
			// given
			List<Lotto> lottos = List.of(
					new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)),
					new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)),
					new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)),
					new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42)),
					new Lotto(Arrays.asList(13, 14, 16, 38, 42, 45)),
					new Lotto(Arrays.asList(7, 11, 30, 40, 42, 43)),
					new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45)),
					new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45))
			);
			WinningInfo winningInfo = new WinningInfo(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

			// when
			ScoreInfo scoreInfo = lottoService.makeScoreInfoBy(lottos, winningInfo);

			// then
			assertThat(scoreInfo.get(Score.FIRST)).isEqualTo(0);
			assertThat(scoreInfo.get(Score.SECOND)).isEqualTo(0);
			assertThat(scoreInfo.get(Score.THIRD)).isEqualTo(0);
			assertThat(scoreInfo.get(Score.FORTH)).isEqualTo(0);
			assertThat(scoreInfo.get(Score.FIFTH)).isEqualTo(1);
		}

		@Test
		@DisplayName("발행한 로또 번호로부터 여러 등수가 추출될 수 있더라도 정확한 등수를 계산한다.")
		void givenLottosAndWinningCausingMultipleResults_whenMakingScoreInfo_thenReturnsExactScoreInfo() {
			//given
			List<Lotto> lottos = List.of(
					new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)), // 1등
					new Lotto(Arrays.asList(1, 21, 23, 41, 42, 43)), // 2등
					new Lotto(Arrays.asList(7, 21, 23, 41, 42, 43)), // 3등
					new Lotto(Arrays.asList(1, 2, 23, 41, 42, 43)), // 4등
					new Lotto(Arrays.asList(1, 2, 3, 41, 42, 43)) // 5등
			);
			WinningInfo winningInfo = new WinningInfo(Arrays.asList(8, 21, 23, 41, 42, 43), 7);

			//when
			ScoreInfo scoreInfo = lottoService.makeScoreInfoBy(lottos, winningInfo);

			//then
			assertThat(scoreInfo.get(Score.FIRST)).isEqualTo(1);
			assertThat(scoreInfo.get(Score.SECOND)).isEqualTo(1);
			assertThat(scoreInfo.get(Score.THIRD)).isEqualTo(1);
			assertThat(scoreInfo.get(Score.FORTH)).isEqualTo(1);
			assertThat(scoreInfo.get(Score.FIFTH)).isEqualTo(1);
		}
	}

	@Nested
	@DisplayName("주어진 당첨 정보와 구매 정보를 바탕으로 수익률을 계산하는 calculateProfitBy 테스트")
	class calculateProfitByTest {
		@Test
		@DisplayName("로또 구매 금액과 점수 정보를 분석하여 수익률을 백분율로 계산한다.")
		void givenLottoBuyingInfoAndScoreInfo_whenCalculatingProfit_thenReturnsProfitAsPercentage() {
			//given
			LottoBuyingInfo lottoBuyingInfo = new LottoBuyingInfo("8000");
			MockScoreInfo mockScoreInfo = new MockScoreInfo();
			mockScoreInfo.setMockScore(Score.FIFTH, 1);

			//when
			Profit profit = lottoService.calculateProfitBy(lottoBuyingInfo, mockScoreInfo);

			//then
			assertThat(profit.getValue()).isEqualTo(62.5);
		}

		@Test
		@DisplayName("로또 수익률은 소수점 둘째 자리에서 반올림한다.")
		void givenLottoBuyingInfoAndScoreInfo_whenCalculatingProfit_thenReturnsProfitRoundedToFirstDigit() {
			//given
			LottoBuyingInfo lottoBuyingInfo = new LottoBuyingInfo("3000");
			MockScoreInfo mockScoreInfo = new MockScoreInfo();
			mockScoreInfo.setMockScore(Score.FIFTH, 1);
			mockScoreInfo.setMockScore(Score.THIRD, 1);
			//when
			Profit profit = lottoService.calculateProfitBy(lottoBuyingInfo, mockScoreInfo);

			//then
			assertThat(profit.getValue()).isEqualTo(50166.7);
		}
	}
}