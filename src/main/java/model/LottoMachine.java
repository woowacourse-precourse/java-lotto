package model;

import static model.LottoMachineConstants.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {

	private final List<Lotto> lottos = new ArrayList<>();

	public void addLotto(Lotto lotto) {
		lottos.add(lotto);
	}

	public Map<Integer, Integer> calculateLottoResult(List<Integer> winningNumbers, int bonusNumber) {

		Map<Integer, Integer> lottoResult = new HashMap<>();
		initlottoWinningStatistics(lottoResult);

		for (Lotto lotto : lottos) {
			List<Integer> lottoNumbers = lotto.getNumbers();
			int sameNumberCount = calculateSameNumberCount(lottoNumbers, winningNumbers);
			int rank = getRank(sameNumberCount);

			if (rank == NONE) {
				continue;
			}
			if (rank == THIRD && isMatchBonusNumber(lottoNumbers, bonusNumber)) {
				rank = SECOND;
			}
			lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
		}
		return lottoResult;
	}

	private int calculateSameNumberCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
		int sameNumberCount = 0;
		for (int lottoNumber : lottoNumbers) {
			if (winningNumbers.contains(lottoNumber)) {
				sameNumberCount += 1;
			}
		}
		return sameNumberCount;
	}

	private int getRank(int sameNumberCount) {
		if (sameNumberCount == 6) {
			return FIRST;
		}
		if (sameNumberCount == 5) {
			return THIRD;
		}
		if (sameNumberCount == 4) {
			return FOURTH;
		}
		if (sameNumberCount == 3) {
			return FIFTH;
		}
		return NONE;
	}

	private boolean isMatchBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
		return lottoNumbers.contains(bonusNumber);
	}

	private void initlottoWinningStatistics(Map<Integer, Integer> lottoWinningStatistics) {
		lottoWinningStatistics.put(FIRST, 0);
		lottoWinningStatistics.put(SECOND, 0);
		lottoWinningStatistics.put(THIRD, 0);
		lottoWinningStatistics.put(FOURTH, 0);
		lottoWinningStatistics.put(FIFTH, 0);
	}
}
