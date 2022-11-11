package lotto.domain.lotteryseller;

import lotto.controller.LotteryRequestController;
import lotto.dto.lotterystore.MoneyForPurchase;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LotterySeller {
	private static final LotterySeller lotterySeller = new LotterySeller();
	private final LotteryRequestController requestController;
	private int money = 0;
	public List<List<Integer>> test;

	private LotterySeller() {
		requestController = LotteryRequestController.getController();
	}

	public static LotterySeller getLotterySeller() {
		return lotterySeller;
	}

	public void receiveInformationAboutPurchase(MoneyForPurchase moneyDto) {
		money = Integer.parseInt(moneyDto.getMoney());
	}

	public void sendGeneratedLotterySet() {
		int numberOfPurchases = getNumberOfPurchases();
		List<List<Integer>> randomNumbersSets = generateRandomNumbersSets(numberOfPurchases);
		test = randomNumbersSets;
		requestController.receiveRandomNumbersSets(randomNumbersSets);
	}

	private int getNumberOfPurchases() {
		return money / 1000;
	}

	private List<List<Integer>> generateRandomNumbersSets(int numberOfPurchases) {
		List<List<Integer>> randomNumbersSets = new ArrayList<>();

		for (int i = 0; i < numberOfPurchases; i++) {
			List<Integer> numbersSet = getOneSet();
			numbersSet = sortAscendingOrder(numbersSet);
			randomNumbersSets.add(numbersSet);
		}

		return randomNumbersSets;
	}

	private List<Integer> sortAscendingOrder(List<Integer> numbersSet) {
		List<Integer> sortedSet = new ArrayList<>();

		Stream<Integer> elementsForSort = numbersSet.stream();
		elementsForSort.sorted().forEach(sortedSet::add);

		return sortedSet;
	}

	private List<Integer> getOneSet() {
		return Randoms.pickUniqueNumbersInRange(1, 45, 6);
	}
}
