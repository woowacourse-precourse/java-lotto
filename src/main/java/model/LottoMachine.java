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

			if (rank == RANK_NONE) {
				continue;
			}
			if (rank == RANK_THIRD && isMatchBonusNumber(lottoNumbers, bonusNumber)) {
				rank = RANK_SECOND;
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
		if (sameNumberCount == LOTTO_SIX_NUMBER_SAME) {
			return RANK_FIRST;
		}
		if (sameNumberCount == LOTTO_FIVE_NUMBER_SAME) {
			return RANK_THIRD;
		}
		if (sameNumberCount == LOTTO_FOUR_NUMBER_SAME) {
			return RANK_FOURTH;
		}
		if (sameNumberCount == LOTTO_THREE_NUMBER_SAME) {
			return RANK_FIFTH;
		}
		return RANK_NONE;
	}

	private boolean isMatchBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
		return lottoNumbers.contains(bonusNumber);
	}

	private void initlottoWinningStatistics(Map<Integer, Integer> lottoWinningStatistics) {
		lottoWinningStatistics.put(RANK_FIRST, 0);
		lottoWinningStatistics.put(RANK_SECOND, 0);
		lottoWinningStatistics.put(RANK_THIRD, 0);
		lottoWinningStatistics.put(RANK_FOURTH, 0);
		lottoWinningStatistics.put(RANK_FIFTH, 0);
	}
}
