package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoAutoGenerator {

	public Lotto createLottoByAuto() {
		List<Integer> numbers =Randoms.pickUniqueNumbersInRange(1, 45, 6);
		return new Lotto(numbers);
	}
}
