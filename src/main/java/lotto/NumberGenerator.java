package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
	public List<ArrayList<Integer>> createRandomLotto(int lottocount) {
		List<ArrayList<Integer>> lottonumbersall = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < lottocount; i++) {
			List<Integer> lottonumbers;
			lottonumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
			lottonumbers = ascendingOrder(lottonumbers);
			lottonumbersall.add((ArrayList<Integer>) lottonumbers);
		}
		return lottonumbersall;
	}
	
	public List<Integer> ascendingOrder(List<Integer> lottonumbers) {
		lottonumbers.sort(Comparator.naturalOrder());
		return lottonumbers;
	}
}
