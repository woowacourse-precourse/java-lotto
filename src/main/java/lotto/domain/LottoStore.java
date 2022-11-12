package lotto.domain;

import java.util.List;

public class LottoStore {
	private final int quantity;
	private List<List<Integer>> lotto;

	public LottoStore(int money) {
		quantity = checkQuantityOfLotto(money);
	}
	private int checkQuantityOfLotto(int money) {
		return money / 1000;
	}

	public void setLotto(List<List<Integer>> lotto) {
		this.lotto = lotto;
	}
	public int getQuantity() {
		return quantity;
	}
	public List<List<Integer>> getLotto() {
		return lotto;
	}
}
