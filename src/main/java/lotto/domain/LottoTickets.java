package lotto.domain;

import java.util.List;

import lotto.view.OutputView;

public class LottoTickets {

	private List<Lotto> lottos;

	public LottoTickets(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public void print() {
		OutputView.printLottos(lottos);
	}
}
