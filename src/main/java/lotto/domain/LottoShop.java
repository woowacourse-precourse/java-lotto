package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {
	private List<Lotto> lottos;

	public LottoShop(int numberOfLotto) {
		this.lottos = makeLottos(numberOfLotto);
	}

	private List<Lotto> makeLottos(int numberOfLotto) {
		List<Lotto> returnLottos = new ArrayList<>();

		while (numberOfLotto > 0) {
			returnLottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(Lotto.MIN_LOTTO_NUMBER, Lotto.MAX_LOTTO_NUMBER, Lotto.SIZE_OF_LOTTO)));
			numberOfLotto--;
		}

		return returnLottos;
	}

	public List<Lotto> getLottos() {
		return lottos;
	}
}
