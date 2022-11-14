package lotto.domain;

import java.util.List;

public class LottoStore {
	final int LOTTO_PRICE = 1000;
	private final int quantity;
	private List<List<Integer>> lotto;

	public LottoStore(int money) {
		quantity = checkQuantityOfLotto(money);
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

	private int checkQuantityOfLotto(int money) {
		return (money / LOTTO_PRICE);
	}
}
