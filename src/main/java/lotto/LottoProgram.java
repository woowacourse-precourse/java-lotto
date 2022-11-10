package lotto;

public class LottoProgram {

	public void start() {
		View.showPurchaseInputGuideMessage();
		String userInput = Input.userInput();
		Checker.checkUserInput(userInput);
	}
}
