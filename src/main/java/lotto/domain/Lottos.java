package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.common.utils.LottoNumberGenerator;

public class Lottos {
	private static List<Lotto> lottos;

	public static void createUserLottos(int purchasedLottoCount) {
		List<Lotto> userLottos = new ArrayList<>(purchasedLottoCount);

		for (int i = 0; i < purchasedLottoCount; i++) {
			userLottos.add(Lotto.from(LottoNumberGenerator.generateLottoNumbers()));
		}

		lottos = userLottos;
	}

	public static List<Lotto> getLottos() {
		return lottos;
	}
}
