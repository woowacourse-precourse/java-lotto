package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

	public List<List<Integer>> createRandomLotto(int lottoCount) {
		ArrayList<List<Integer>> lottoNumbersAll = new ArrayList<>();

		for (int i = 0; i < lottoCount; i++) {
			List<Integer> lottoNumbers = new ArrayList<>();
			lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			lottoNumbers = ascendingOrder(lottoNumbers);
			lottoNumbersAll.add(lottoNumbers);
		}
		return lottoNumbersAll;
	}

	public List<Integer> ascendingOrder(List<Integer> lottoNumbers) {
		ArrayList<Integer> lottoNumbersList = new ArrayList<Integer>();

		lottoNumbersList.addAll(lottoNumbers);
		lottoNumbersList.sort(Comparator.naturalOrder());

		return lottoNumbersList;
	}
}
