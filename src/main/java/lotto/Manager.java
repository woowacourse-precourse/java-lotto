package lotto;

import java.util.ArrayList;
import java.util.List;

public class Manager {

	public static LottoMachine lottoMachine;
	public static Lotto lotto;

	public void init(){
		showGeneratedLottos(buyLottos(userInput()));
		inputWinningNumbers(userInput());
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

	public static void inputWinningNumbers(String winningNumbers){
		printWinningNumbersInput();
		Validate.initialInputCheck(winningNumbers);
		lotto = new Lotto(formatting(winningNumbers));
	}

	public static void printWinningNumbersInput(){
		System.out.println(Message.INPUT_WINNING_NUMBER.getMessage());
	}

	public static List<Integer> formatting(String winningNumbers){
		List<Integer> numbers = new ArrayList<>();
		for (String number: winningNumbers.split(",")){
			numbers.add(Integer.parseInt(number));
		}
		return numbers;
	}

	public String inputBonusNumber(String bonusNumber) {
		printBonusNumberInput();
		Validate.checkBonusNumber(bonusNumber, lotto.getNumbers());
		return bonusNumber;
	}

	public static void printBonusNumberInput(){
		System.out.println(Message.INPUT_BONUS_NUMBER.getMessage());
	}


}
