package lotto.repository;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

public class LottoRepository {

	private static final LottoRepository instance = new LottoRepository();

	private LottoRepository() {
	}

	public static LottoRepository getInstance() {
		return instance;
	}

	public Lotto makeAutoLotto() {
		return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
	}

}
