package lotto.model;

import java.util.List;

public class Wallet {

	private final int receiptLotto;

	private final List<Lotto> myLotto;

	public Wallet(List<Lotto> myLotto, int receiptLotto) {
		this.myLotto = myLotto;
		this.receiptLotto = receiptLotto;
	}

	public int getReceiptLotto() {
		return receiptLotto;
	}

	public List<Lotto> getMyLotto() {
		return myLotto;
	}
}
