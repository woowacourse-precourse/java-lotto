package lotto;

public class Manager {

	public void init(){
		buyLottos(userInput());
	}

	public static void buyLottos(String userInputMoney){
		printPurchaseAmount();
		Validate.checkValidMoney(userInputMoney);
		Message.printBoughtAmount(Integer.parseInt(userInputMoney) / Constant.LOTTO_PRICE.getNumber());
	}

	public static void printPurchaseAmount(){
		System.out.println(Message.INPUT_PURCHASE_AMOUNT.getMessage());
	}

	public String userInput(){
		return Input.readLine();
	}

}
