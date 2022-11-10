package lotto.repository;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

public class LottoRepository {

	public static Lotto makeAutoLotto() {
		return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
	}

}
