package lotto.repository;

import java.util.Collections;
import java.util.List;

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
		List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
		Collections.sort(lotto);
		return new Lotto(lotto);
	}

}
