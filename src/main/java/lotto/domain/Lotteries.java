package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotteries {
	private final List<Lotto> lotteries = new ArrayList<>();
	private final List<List<Integer>> totalLottoNumbers = new ArrayList<>();

	public Lotteries(int numberOfTickets) {
		LottoGenerator lottoGenerator = new LottoGenerator();
		while (lotteries.size() != numberOfTickets) {
			lotteries.add(new Lotto(lottoGenerator.getLotto()));
		}
	}

	public List<Lotto> getLotteries() {
		return lotteries;
	}

	public List<List<Integer>> getTotalLottoNumbers() {
		lotteries.forEach(lotto -> totalLottoNumbers.add(lotto.getNumbers()));
		return totalLottoNumbers;
	}
}
