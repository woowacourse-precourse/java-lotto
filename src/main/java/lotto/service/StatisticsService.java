package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinnerNumber;
import lotto.repository.dto.UserLottoDto;

public class StatisticsService {

	public void updateStatistics(UserLottoDto userLottoDto, WinnerNumber winnerNumber) {
		for (Lotto lotto : userLottoDto.getUserLotto()) {
			updateRank(winnerNumber, lotto);
		}
	}

	private void updateRank(WinnerNumber winnerNumber, Lotto lotto) {
		int answerCount = lotto.countAnswer(winnerNumber.getAnswerNumbers());
		int bonusCount = lotto.countBonus(winnerNumber.getBonusNumber());
		updateRankCount(answerCount, bonusCount);
	}

	private void updateRankCount(int count, int bonusCount) {
		if (count == 6) {
			Rank.firstRank.updateCount(1);
			return;
		}
		if (count == 5 && bonusCount == 1) {
			Rank.secondRank.updateCount(1);
			return;
		}
		if (count == 5 && bonusCount == 0) {
			Rank.thirdRank.updateCount(1);
			return;
		}
		if (count == 4) {
			Rank.forthRank.updateCount(1);
			return;
		}
		if (count == 3) {
			Rank.fifthRank.updateCount(1);
			return;
		}
	}

}
