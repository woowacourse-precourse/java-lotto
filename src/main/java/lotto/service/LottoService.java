package lotto.service;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoGroup;
import lotto.repository.LottoRepository;

public class LottoService {

	private static final LottoService instance = new LottoService();

	private LottoService() {
	}

	public static LottoService getInstance() {
		return instance;
	}

	private final LottoRepository lottoRepository = LottoRepository.getInstance();

	public LottoGroup makeLottoGroup(int purchaseQuantity) {
		List<Lotto> lottos = new ArrayList<>();
		for (int purchaseCount = 0; purchaseCount < purchaseQuantity; purchaseCount++) {
			lottos.add(lottoRepository.makeAutoLotto());
		}
		return new LottoGroup(lottos);
	}

}
