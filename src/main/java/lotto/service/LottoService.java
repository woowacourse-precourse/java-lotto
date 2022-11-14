package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Rank;
import lotto.domain.Lotto;

public class LottoService {
	final int NUMBER_JUDGMENT_RANKED_BY_BONUS = 5;
	final int PERCENT = 100;

	public List<List<Integer>> publishLotteries(int quantity) {
		List<List<Integer>> candidate = new ArrayList<>();

		for (int i = 0; i < quantity; i++) {
			Lotto lotto = new Lotto(pickLottoNumbers());

			publishLotto(candidate, lotto.getNumbers());
		}

		return candidate;
	}

	private List<Integer> pickLottoNumbers() {
		List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));

		Collections.sort(lottoNumbers);

		return lottoNumbers;
	}

	private void publishLotto(List<List<Integer>> candidateLotto, List<Integer> candidate) {
		candidateLotto.add(candidate);
	}

	public Map<Rank, Integer> countWinningNumber(List<List<Integer>> candidate, List<Integer> winningNumbers,
			int bonusNumber) {
		Map<Rank, Integer> rank = new EnumMap<>(Rank.class);

		for (List<Integer> integers : candidate) {
			int count = compareNumbers(integers, winningNumbers);

			Rank key = Rank.of(count, judgementRankByBonus(count, integers, bonusNumber));
			rank.put(key, rank.getOrDefault(key, 0) + 1);
		}

		return rank;
	}

	private boolean judgementRankByBonus(int count, List<Integer> lotto, int bonusNumber) {
		boolean haveBonus = false;

		if (count == NUMBER_JUDGMENT_RANKED_BY_BONUS) {
			haveBonus = checkBonus(lotto, bonusNumber);
		}

		return haveBonus;
	}

	public int getPrizeMoney(Map<Rank, Integer> rank) {
		int prizeMoney = 0;

		for (Map.Entry<Rank, Integer> entry : rank.entrySet()) {
			prizeMoney += entry.getKey().getPrizeMoney() * entry.getValue();
		}

		return prizeMoney;
	}

	private boolean checkBonus(List<Integer> candidate, int bonusNumber) {
		return candidate.contains(bonusNumber);
	}

	private int compareNumbers(List<Integer> candidate, List<Integer> winningNumbers) {
		int count = 0;

		for (int i = 0; i < candidate.size(); i++) {
			if (candidate.contains(winningNumbers.get(i))) {
				count++;
			}
		}

		return count;
	}

	public String getRateOfReturn(int prizeMoney, double money) {

		return String.format("%.1f", (prizeMoney / money) * PERCENT);
	}

	public List<Integer> convertStringToList(String numbers) {
		List<String> lotto = Arrays.asList(numbers.split(","));

		return lotto.stream()
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}
}
