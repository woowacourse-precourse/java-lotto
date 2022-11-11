package lotto.service;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.repository.dto.UserLottoDto;

public class StatisticsService {

	public void updateStatistics(UserLottoDto userLottoDto, List<Integer> answers, Integer bonusNumber) {
		for (Lotto lotto : userLottoDto.getUserLotto()) {
			updateRank(lotto.getNumbers(), answers, bonusNumber);
		}
	}

	private void updateRank(List<Integer> numbers, List<Integer> answers, Integer bonusNumber) {
		int count = (int)numbers.stream().filter(number -> answers.contains(number)).count();
		int bonusCount = getBonusCount(numbers, bonusNumber);
		updateRankCount(count, bonusCount);
	}

	private int getBonusCount(List<Integer> numbers, Integer bonusNumber) {
		int bonusCount = 0;
		if (numbers.contains(bonusNumber)) {
			bonusCount++;
		}
		return bonusCount;
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
