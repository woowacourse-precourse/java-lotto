package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Manager {
	private List<Lotto> lottos;
	
	private Lotto makeLotto() {
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
		return new Lotto(numbers);
	}

	public void setLottos(int count) {
		lottos.clear();
		for (int i = 0; i < count; i++) {
			lottos.add(makeLotto());
		}
	}
	
	
}
