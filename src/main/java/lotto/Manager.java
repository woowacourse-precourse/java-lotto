package lotto;

public class Manager {

	public static LottoMachine lottoMachine;

	public void init(){
		showGeneratedLottos(buyLottos(userInput()));
	}

	public static int buyLottos(String userInputMoney){
		int totalBought;
		printPurchaseAmount();
		Validate.checkValidMoney(userInputMoney);
		totalBought = Integer.parseInt(userInputMoney) / Constant.LOTTO_PRICE.getNumber();
		Message.printBoughtAmount(totalBought);
		return totalBought;
	}

	public static void printPurchaseAmount(){
		System.out.println(Message.INPUT_PURCHASE_AMOUNT.getMessage());
	}

	public String userInput(){
		return Input.readLine();
	}

	public static void showGeneratedLottos(int totalBought){
		lottoMachine = LottoMachine.generateLottos(totalBought);
		lottoMachine.printLottos();
	}

}
