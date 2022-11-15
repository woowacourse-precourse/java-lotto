package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotteries {
	private final LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
	private final List<Lotto> lotteries = new ArrayList<>();
	private final List<List<Integer>> totalLottoNumbers = new ArrayList<>();

	public Lotteries(int numberOfTickets) {
		init(numberOfTickets);
	}
	private void init(int numberOfTickets) {
		while (lotteries.size() != numberOfTickets) {
			lotteries.add(new Lotto(lottoNumbersGenerator.getLottoNumbers()));
		}
		lotteries.forEach(lotto -> totalLottoNumbers.add(lotto.getNumbers()));
	}

	public List<Lotto> getLotteries() {
		return lotteries;
	}

	public List<List<Integer>> getTotalLottoNumbers() {
		return totalLottoNumbers;
	}
}
