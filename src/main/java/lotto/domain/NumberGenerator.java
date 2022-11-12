package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumberGenerator {

	List<Integer> createRandomNumbers(){
		return Randoms.pickUniqueNumbersInRange(1, 45, 6);
	}

}
