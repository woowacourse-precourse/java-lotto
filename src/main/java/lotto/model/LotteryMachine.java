package lotto.model;

import static lotto.model.LotteryInformation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LotteryMachine {
	private final int ticketQuantity;
	private final List<List<Integer>> lotteryTickets = new ArrayList<>();

	public LotteryMachine(int money) {
		this.ticketQuantity = exchangeMoneyToLottery(money);
		publishLotteryTickets();
	}

	private int exchangeMoneyToLottery(int money) {
		return money / UNIT_PRICE.getCode();
	}

	private void publishLotteryTickets() {
		for (int i = 0; i < ticketQuantity; i++) {
			List<Integer> numbers = new ArrayList<>(
				Randoms.pickUniqueNumbersInRange(START_NUMBER.getCode(), END_NUMBER.getCode(), TOTAL_NUMBER.getCode()));
			Collections.sort(numbers);
			lotteryTickets.add(numbers);
		}
	}

	public int getTicketQuantity() {
		return ticketQuantity;
	}

	public List<List<Integer>> getLotteryTickets() {
		return lotteryTickets;
	}

}
