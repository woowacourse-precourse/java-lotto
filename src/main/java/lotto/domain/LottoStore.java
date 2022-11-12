package lotto.domain;

import java.util.List;

public class LottoStore {
	private static int quantity;
	private static List<List<Integer>> lotto;

	public LottoStore(int money) {
		this.quantity = checkQuantityOfLotto(money);
	}
	private int checkQuantityOfLotto(int money) {
		return money / 1000;
	}

	public void setLotto(List<List<Integer>> lotto) {
		this.lotto = lotto;
	}
	public static int getQuantity() {
		return quantity;
	}
	public static List<List<Integer>> getLotto() {
		return lotto;
	}
}
