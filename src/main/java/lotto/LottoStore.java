package lotto;

public class LottoStore {

	private int moneyBuyLotto;

	public LottoStore() {
		moneyBuyLotto = 0;
	}

	public void open() {
		buy();
	}

	private void buy() {
		ConsoleOut.printInputMoney();
		moneyBuyLotto = Util.strToInt(ConsoleIn.readLine());
		Verify.verifyThousandUnit(moneyBuyLotto);
	}
}