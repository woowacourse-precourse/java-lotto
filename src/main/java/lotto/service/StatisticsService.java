package lotto.service;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.repository.dto.UserLottoDto;

public class StatisticsService {

	public void updateStatistics(UserLottoDto userLottoDto, List<Integer> answers, Integer bonusNumber) {
		for (Lotto lotto : userLottoDto.getUserLotto()) {
			int answerCount = lotto.countAnswer(answers);
			int bonusCount = lotto.countBonus(bonusNumber);
			updateRankCount(answerCount, bonusCount);
		}
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
