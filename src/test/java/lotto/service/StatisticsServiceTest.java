package lotto.service;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.controller.dto.WinnerNumberDto;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.repository.UserLottoRepository;
import lotto.repository.dto.UserLottoDto;
import lotto.util.RankConst;

class StatisticsServiceTest {

	private StatisticsService statisticsService;
	private UserLottoRepository userLottoRepository;

	@BeforeEach
	void setUp() {
		statisticsService = new StatisticsService();
		userLottoRepository = new UserLottoRepository();
	}

	@DisplayName("사용자가 구매한 로또와 당첨번호의 일치 개수를 체크하여 당첨등수 횟수 확인하는 테스트")
	@Test
	public void updateStatisticsTest() {
		//given
		Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
		userLottoRepository.updateLotto(lotto1);
		userLottoRepository.updateLotto(lotto2);
		UserLottoDto userLottoDto = userLottoRepository.findUserLottoDto();
		WinnerNumberDto winnerNumberDto = new WinnerNumberDto(List.of(1, 2, 3, 4, 5, 6));
		winnerNumberDto.setBonusNumber(7);//

		//when
		statisticsService.updateStatistics(userLottoDto, winnerNumberDto);
		String userFirstRankStatisticsResult = Rank.firstRank.getUserStatisticsResult();
		String userSecondRankStatisticsResult = Rank.secondRank.getUserStatisticsResult();

		//then
		Assertions.assertThat(userFirstRankStatisticsResult)
			.isEqualTo(RankConst.FIRST_RANK_RESULT + 1 + RankConst.COUNT);
		Assertions.assertThat(userSecondRankStatisticsResult)
			.isEqualTo(RankConst.SECOND_RANK_RESULT + 1 + RankConst.COUNT);
	}

}
