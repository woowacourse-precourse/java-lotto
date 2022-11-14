package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.view.MainView;

public class LottoGroup {

	private final List<Lotto> lottos;

	public LottoGroup(List<Lotto> lottos) {
		this.lottos = lottos;
		MainView.purchaseLottoGroup(getLottosSize());
		MainView.printAllLotto(getLottos());
	}

	public int getLottosSize() {
		return lottos.size();
	}

	private List<Lotto> getLottos() {
		return Collections.unmodifiableList(this.lottos);
	}

	public List<Rank> winningStatistics(Lotto winnerLotto, int bonusNumber) {
		List<Rank> rankList = new ArrayList<>();
		for (Lotto purchaseLotto : this.lottos) {
			rankList.add(purchaseLotto.getRank(winnerLotto, bonusNumber));
		}
		return rankList;
	}

}
