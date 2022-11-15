package lotto.model;

import lotto.enums.Constant;

public class Cash {
	private Long cash;


	public Cash(Long cash) {
		isValidate(cash);
		this.cash = cash;
	}

	public boolean canBuy() {
		return cash >= Constant.LOTTO_COST.getValue();
	}

	public void withdraw() {
		cash -= Constant.LOTTO_COST.getValue();
	}

	private void isValidate(Long cash) {
		isMoreThenZero(cash);
		isCorrectUnit(cash);
	}

	private void isCorrectUnit(Long cash) {
		if (cash % Constant.UNIT.getValue() != 0L){
			throw new IllegalArgumentException("It should be 1,000 unit");
		}
	}

	private void isMoreThenZero(Long cash) {
		if (cash <= 0L){
			throw new IllegalArgumentException("It should be more then 0");
		}
	}
}
