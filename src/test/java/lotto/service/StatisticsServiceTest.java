package lotto.service;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.controller.dto.WinningNumberDto;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.RankGroup;
import lotto.repository.UserLottoRepository;
import lotto.repository.dto.UserLottoDto;
import lotto.util.RankConst;

class StatisticsServiceTest {

	private StatisticsService statisticsService;
	private UserLottoRepository userLottoRepository;
	private RankGroup rankGroup;

	@BeforeEach
	void setUp() {
		rankGroup = new RankGroup();
		statisticsService = new StatisticsService(this.rankGroup);
		userLottoRepository = new UserLottoRepository();
	}

	@AfterEach
	void tearDown() {
		userLottoRepository.clear();
		rankGroup.clearRankGroupCount();
	}

	@DisplayName("사용자가 구매한 로또와 당첨번호의 일치 개수를 체크하여 당첨등수 횟수 확인하는 테스트")
	@Test
	public void updateStatisticsTest() {
		//given
		Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
		userLottoRepository.save(lotto1);
		userLottoRepository.save(lotto2);
		UserLottoDto userLottoDto = userLottoRepository.findUserLottoDto();
		WinningNumberDto winningNumberDto = new WinningNumberDto(List.of(1, 2, 3, 4, 5, 6));
		winningNumberDto.setBonusNumber(7);//
		Integer inputPrice = 1000;

		//when
		statisticsService.updateStatistics(userLottoDto, winningNumberDto, inputPrice);
		String userFirstRankStatisticsResult = rankGroup.userRankResultToString(Rank.firstRank);
		String userSecondRankStatisticsResult = rankGroup.userRankResultToString(Rank.secondRank);

		//then
		Assertions.assertThat(userFirstRankStatisticsResult)
			.isEqualTo(RankConst.FIRST_RANK_RESULT + 1 + RankConst.COUNT_STATEMENT);
		Assertions.assertThat(userSecondRankStatisticsResult)
			.isEqualTo(RankConst.SECOND_RANK_RESULT + 1 + RankConst.COUNT_STATEMENT);
	}

}
