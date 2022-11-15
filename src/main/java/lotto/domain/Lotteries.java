package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotteries {
	List<Lotto> lotteries = new ArrayList<>();
	LottoGenerator lottoGenerator = new LottoGenerator();

	public Lotteries(int numberOfTickets) {
		while (lotteries.size() != numberOfTickets) {
			lotteries.add(new Lotto(lottoGenerator.getLotto()));
		}
	}
	public List<Lotto> getLotteries() {
		return lotteries;
	}

	public List<List<Integer>> getTotalLottoNumbers() {
		List<List<Integer>> totalLottoNumbers = new ArrayList<>();
		lotteries.forEach(lotto -> totalLottoNumbers.add(lotto.getNumbers()));
		return totalLottoNumbers;
	}
}
