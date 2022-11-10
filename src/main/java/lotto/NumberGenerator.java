package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
	public List<List<Integer>> createRandomLotto(int lottocount) {
		List<List<Integer>> lottonumbersall = new ArrayList<List<Integer>>();
		for(int i = 0; i < lottocount; i++) {
			List<Integer> lottonumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
			lottonumbersall.add(lottonumbers);
		}
		return lottonumbersall;
	}
	
	public void ascendingOrder() {
		
	}
}
