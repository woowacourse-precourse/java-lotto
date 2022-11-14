package lotto.service;

import lotto.controller.dto.WinningNumberDto;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.RankGroup;
import lotto.domain.dto.LottoWinsCountDto;
import lotto.repository.dto.UserLottoDto;
import lotto.service.dto.StatisticsDto;

public class StatisticsService {

	private final RankGroup rankGroup;

	public StatisticsService(RankGroup rankGroup) {
		this.rankGroup = rankGroup;
	}

	public StatisticsDto updateStatistics(UserLottoDto userLottoDto, WinningNumberDto winningNumberDto,
		Integer inputPrice) {
		for (Lotto lotto : userLottoDto.getUserLottos()) {
			updateRank(winningNumberDto, lotto);
		}
		return new StatisticsDto(rankGroup.userTotalRankResult(), rankGroup.findYield(inputPrice));
	}

	private void updateRank(WinningNumberDto winningNumberDto, Lotto lotto) {
		LottoWinsCountDto lottoWinsCountDto = lotto.matchWinningNumber(winningNumberDto);
		updateRankCount(lottoWinsCountDto);
	}

	private void updateRankCount(LottoWinsCountDto lottoWinsCountDto) {
		Integer answerCount = lottoWinsCountDto.getAnswerCount();
		Integer bonusCount = lottoWinsCountDto.getBonusCount();
		updateFirstRankCount(answerCount);
		updateSecondRankCount(answerCount, bonusCount);
		updateThirdRankCount(answerCount, bonusCount);
		updateForthRankCount(answerCount);
		updateFifthRankCount(answerCount);
	}

	private void updateFifthRankCount(int answerCount) {
		if (answerCount == 3) {
			rankGroup.updateRankCount(Rank.fifthRank, 1);
		}
	}

	private void updateForthRankCount(int answerCount) {
		if (answerCount == 4) {
			rankGroup.updateRankCount(Rank.forthRank, 1);
		}
	}

	private void updateThirdRankCount(int answerCount, int bonusCount) {
		if (answerCount == 5 && bonusCount == 0) {
			rankGroup.updateRankCount(Rank.thirdRank, 1);
		}
	}

	private void updateSecondRankCount(int answerCount, int bonusCount) {
		if (answerCount == 5 && bonusCount == 1) {
			rankGroup.updateRankCount(Rank.secondRank, 1);
		}
	}

	private void updateFirstRankCount(int answerCount) {
		if (answerCount == 6) {
			rankGroup.updateRankCount(Rank.firstRank, 1);
		}
	}

}
