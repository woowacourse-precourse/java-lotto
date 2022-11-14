package lotto;

public class Controller {
	Service service = new Service();
	PrintMessage printMesseg = new PrintMessage();

	public void run() {
		buyLotto();
		printBuyLotto();
		inputNumber();
		lottoNumberCompareAfterStore();
		printResult();
	}

	public void buyLotto() {
		printMesseg.purchasePriceMessage();
		service.userInputMoney();
		service.lottoIssued();
	}

	public void printBuyLotto() {
		printMesseg.purchaseMessage(service.count);
		printMesseg.printPurchaseLotto(service.purchaseLotto);
	}

	public void inputNumber() {
		printMesseg.InputNumberMessage();
		service.inputLotto(service.userInputNumber());
		printMesseg.bonusInputNumberMessage();
		service.inputLottoBonusNumber();
	}

	public void lottoNumberCompareAfterStore() {
		service.setPrize();
		service.numberComparAferStore();
	}

	public void printResult() {
		printMesseg.printResultPrize(service.prize);
		printMesseg.printTotalPrize(service.yield());
	}
}