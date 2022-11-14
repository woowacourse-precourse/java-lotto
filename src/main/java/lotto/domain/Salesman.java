package lotto.domain;

public class Salesman {

	private final static int LOTTO_PRICE = 1000;

	public int sellLotto(int purchaseBudget) {
		return purchaseBudget / LOTTO_PRICE;
	}
}
