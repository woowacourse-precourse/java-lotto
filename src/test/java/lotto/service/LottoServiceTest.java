package lotto.service;

import lotto.domain.ScoreInfo;
import lotto.mock.MockScoreInfo;
import lotto.system.LottoApplication;
import lotto.vo.Lotto;
import lotto.vo.LottoAmount;
import lotto.vo.Score;
import lotto.vo.Winning;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
	private final LottoService lottoService = new LottoService();

	@BeforeEach
	void setup() {
		LottoApplication.initializeValidators();
		LottoApplication.initializeConverters();
	}

	@AfterEach
	void runAfter() {
		LottoApplication.doAfter();
	}

	@Test
	@DisplayName("주어진 LottoAmount 값만큼 새로운 Lotto 객체를 만들어 반환한다.")
	void givenLottoAmount_whenCreatingLotto_thenReturnsListOfLotto() {
		//given
		LottoAmount lottoAmount = new LottoAmount(10);

		//when
		List<Lotto> result = lottoService.createLottos(lottoAmount);

		//then
		assertThat(result).hasSize(10);
	}

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
		Winning winning = new Winning(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

		// when
		ScoreInfo scoreInfo = lottoService.makeScoreInfoBy(lottos, winning);

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
		Winning winning = new Winning(Arrays.asList(8, 21, 23, 41, 42, 43), 7);

		//when
		ScoreInfo scoreInfo = lottoService.makeScoreInfoBy(lottos, winning);

		//then
		assertThat(scoreInfo.get(Score.FIRST)).isEqualTo(1);
		assertThat(scoreInfo.get(Score.SECOND)).isEqualTo(1);
		assertThat(scoreInfo.get(Score.THIRD)).isEqualTo(1);
		assertThat(scoreInfo.get(Score.FORTH)).isEqualTo(1);
		assertThat(scoreInfo.get(Score.FIFTH)).isEqualTo(1);
	}

	@Test
	@DisplayName("로또 구매 금액과 점수 정보를 분석하여 수익률을 백분율로 계산한다.")
	void givenLottoAmountAndScoreInfo_whenCalculatingProfit_thenReturnsProfitAsPercentage() {
	    //given
		LottoAmount lottoAmount = new LottoAmount(8000);
		MockScoreInfo mockScoreInfo = new MockScoreInfo();
		mockScoreInfo.setMockScore(Score.FIFTH, 1);

		//when
		Double profit = lottoService.calculateProfitBy(lottoAmount, mockScoreInfo);

	    //then
		assertThat(profit).isEqualTo(62.5);
	}

	@Test
	@DisplayName("로또 수익률은 소수점 둘째 자리에서 반올림한다.")
	void givenLottoAmountAndScoreInfo_whenCalculatingProfit_thenReturnsProfitRoundedToFirstDigit() {
	    //given
		LottoAmount lottoAmount = new LottoAmount(3000);
		MockScoreInfo mockScoreInfo = new MockScoreInfo();
		mockScoreInfo.setMockScore(Score.FIFTH, 1);
		mockScoreInfo.setMockScore(Score.THIRD, 1);
	    //when
		Double profit = lottoService.calculateProfitBy(lottoAmount, mockScoreInfo);

	    //then
		assertThat(profit).isEqualTo(50166.7);
	}
}