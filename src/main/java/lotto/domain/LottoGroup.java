package lotto.domain;

import java.util.List;

public class LottoGroup {

	private final List<Lotto> lottos;

	public LottoGroup(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public int getLottosSize() {
		return lottos.size();
	}

}
