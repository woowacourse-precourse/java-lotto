package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumberGenerator {

	public static List<Integer> generate() {
		return Randoms.pickUniqueNumbersInRange(1, 45, 6);
	}

}
