package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
	
	public List<List<Integer>> createRandomLotto(int lottocount) {
		ArrayList<List<Integer>> lottonumbersall = new ArrayList<>();
		for (int i = 0; i < lottocount; i++) {
			List<Integer> lottonumbers = new ArrayList<>();
			lottonumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
			lottonumbers = ascendingOrder(lottonumbers);
			lottonumbersall.add(lottonumbers);
		}
		return lottonumbersall;
	}
	
	public List<Integer> ascendingOrder(List<Integer> lottonumbers) {
		ArrayList<Integer> lottonumberslist = new ArrayList<Integer>();
		lottonumberslist.addAll(lottonumbers);
		lottonumberslist.sort(Comparator.naturalOrder());
		return lottonumberslist;
	}
}
