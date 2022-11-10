package lotto.domain;

import java.util.List;

import lotto.controller.LottoController;

public class LottoSeller {
	private static int quantity;
	private static List<List<Integer>> lotto;

	public LottoSeller(int money) {
		this.quantity = checkQuantityOfLotto(money);
		setLotto();
	}
	private int checkQuantityOfLotto(int money) {
		return money / 1000;
	}

	private void setLotto() {
		//controller에게 요청한다. 발행하라고
		this.lotto = LottoController.publishLotteries(quantity);
	}
	public static int getQuantity() {
		return quantity;
	}
	public static List<List<Integer>> getLotto() {
		return lotto;
	}
}
