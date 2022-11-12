package lotto.service;

import lotto.controller.dto.WinnerNumberDto;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.dto.WinnerCountDto;
import lotto.repository.dto.UserLottoDto;

public class StatisticsService {

	public void updateStatistics(UserLottoDto userLottoDto, WinnerNumberDto winnerNumberDto) {
		for (Lotto lotto : userLottoDto.getUserLotto()) {
			updateRank(winnerNumberDto, lotto);
		}
	}

	private void updateRank(WinnerNumberDto winnerNumberDto, Lotto lotto) {
		WinnerCountDto winnerCountDto = lotto.countWinnerNumber(winnerNumberDto);
		updateRankCount(winnerCountDto);
	}

	private void updateRankCount(WinnerCountDto winnerCountDto) {
		int answerCount = winnerCountDto.getAnswerCount();
		int bonusCount = winnerCountDto.getBonusCount();

		if (answerCount == 6) {
			Rank.firstRank.updateCount(1);
			return;
		}
		if (answerCount == 5 && bonusCount == 1) {
			Rank.secondRank.updateCount(1);
			return;
		}
		if (answerCount == 5 && bonusCount == 0) {
			Rank.thirdRank.updateCount(1);
			return;
		}
		if (answerCount == 4) {
			Rank.forthRank.updateCount(1);
			return;
		}
		if (answerCount == 3) {
			Rank.fifthRank.updateCount(1);
			return;
		}
	}

}
