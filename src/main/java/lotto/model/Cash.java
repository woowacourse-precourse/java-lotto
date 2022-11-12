package lotto.model;

public class Cash {
	private Long cash;
	private final int UNIT = 1000;
	private final int PRICE = 1000;

	public Cash(Long cash) {
		isValidate(cash);
		this.cash = cash;
	}

	public boolean canBuy(){
		return cash >= PRICE;
	}

	public void withdraw(){
		cash -= PRICE;
	}

	private void isValidate(Long cash){
		isMoreThenZero(cash);
		isCorrectUnit(cash);
	}

	private void isCorrectUnit(Long cash){
		if (cash % UNIT != 0L){
			throw new IllegalArgumentException("It should be 1,000 unit");
		}
	}

	private void isMoreThenZero(Long cash){
		if (cash <= 0L){
			throw new IllegalArgumentException("It should be more then 0");
		}
	}
}
