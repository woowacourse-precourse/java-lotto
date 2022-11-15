package lotto.lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class randomNumber {
	public List<Integer> lotto;
	public randomNumber(){this.lotto = Randoms.pickUniqueNumbersInRange(1,45,6);
	}
}

