package lotto.domain.lotteryseller;

import lotto.controller.LotteryRequestController;
import lotto.dto.lotto.Lotto;
import lotto.dto.lotteryseller.LottoSetsDto;
import lotto.dto.lotterystore.MoneyDto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LotterySeller {

	private int money = 0;

	public void receiveMoney(MoneyDto money) {
		this.money = Integer.parseInt(money.getMoney());
	}

	public void sendGeneratedLotterySets(LotteryRequestController requestController) {
		int numberOfPurchases = getNumberOfPurchases();

		List<List<Integer>> orderedLottoSets = generateLottoSets(numberOfPurchases);
		int orderedLottoSetsSize = orderedLottoSets.size();

		LottoSetsDto lottoSetsDto =
			new LottoSetsDto(orderedLottoSets, orderedLottoSetsSize);
		requestController.receiveLottoSets(lottoSetsDto);
	}

	private int getNumberOfPurchases() {
		return money / 1000;
	}

	private List<List<Integer>> generateLottoSets(int numberOfPurchases) {
		List<List<Integer>> orderedLottoSets = new ArrayList<>();

		for (int i = 0; i < numberOfPurchases; i++) {
			Lotto lotto = getOneSet();
			orderedLottoSets.add(sortAscendingOrder(lotto));
		}

		return orderedLottoSets;
	}

	private Lotto getOneSet() {
		return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
	}

	private List<Integer> sortAscendingOrder(Lotto lotto) {
		List<Integer> lottoNumbers = lotto.getNumbers();
		List<Integer> orderedNumbers = new ArrayList<>();

		lottoNumbers.stream().sorted().forEach(orderedNumbers::add);

		return orderedNumbers;
	}
}
