package lotto;

import lotto.ui.ErrorMessage;
import lotto.ui.CustomerMessage;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Customer {
	private static final int UNIT = 1000;
	private int amount;

	public void inputAmount() {
		System.out.println(CustomerMessage.INSERT_AMOUNT.getMessage());
		String amount = readLine();
		try {
			validateAmount(amount);
			this.amount = Integer.parseInt(amount);
		} catch (IllegalArgumentException e) {
			System.out.println(ErrorMessage.IllegalArgumentException.getMessage());
		}
	}

	public int getAmount() {
		return amount;
	}
	
	private boolean validateAmount(String amount) {
		if (!Util.isInteger(amount) || Integer.parseInt(amount) % UNIT != 0)
			throw (new IllegalArgumentException());
		return true;
	}

	public int getLottoCount() {
		return amount / UNIT;
	}
	
	public void printLottoCount() {
		System.out.println(getLottoCount()+CustomerMessage.PRINT_LOTTO_COUNT.getMessage());
	}


}
