package lotto;

import java.util.ArrayList;
import java.util.List;

public class Manager {

	public static String userInputMoney;
	public static LottoMachine lottoMachine;
	public static Lotto lotto;
	public static ArrayList<Integer> winningInfo;
	public static double totalRevenue;

	public void init(){
		showGeneratedLottos(buyLottos());
		inputWinningNumbers();
		showWinningStatus(lotto.getNumbers(), inputBonusNumber(), lottoMachine.getLottos());
		showRevenueRate();
	}

	public static int buyLottos(){
		printPurchaseAmount();
		userInputMoney = userInput();
		int totalBought;
		Validate.checkValidMoney(userInputMoney);
		totalBought = Integer.parseInt(userInputMoney) / Constant.LOTTO_PRICE.getNumber();
		Message.printBoughtAmount(totalBought);
		return totalBought;
	}

	public static void printPurchaseAmount(){
		System.out.println(Message.INPUT_PURCHASE_AMOUNT.getMessage());
	}

	public static String userInput(){
		return Input.readLine();
	}

	public static void showGeneratedLottos(int totalBought){
		lottoMachine = LottoMachine.generateLottos(totalBought);
		lottoMachine.printLottos();
	}

	public static void inputWinningNumbers(){
		printWinningNumbersInput();
		String winningNumbers = userInput();
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

	public int inputBonusNumber() {
		printBonusNumberInput();
		String bonusNumber = userInput();
		Validate.checkBonusNumber(bonusNumber, lotto.getNumbers());
		return Integer.parseInt(bonusNumber);
	}

	public static void printBonusNumberInput(){
		System.out.println("\n"+Message.INPUT_BONUS_NUMBER.getMessage());
	}

	public void showWinningStatus(List<Integer> winningNumbers, int bonusNumber, List<List<Integer>> lottos){
		winningInfo = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0));
		for (List<Integer> lotto : lottos){
			checkResult(lotto, winningNumbers, bonusNumber);
		}
		Message.printWinningStatus(winningInfo);
	}

	public void checkResult(List<Integer> lotto, List<Integer> winningNumbers, int bonusNumber){
		int count = 0;
		int bonusCount = 0;
		for (int number: lotto){
			if (winningNumbers.contains(number)) count++;
			if (number == bonusNumber) bonusCount++;
		}
		updateWinningInfo(checkRank(count, bonusCount));
	}

	public int checkRank(int count, int bonusCount){
		if (count < 3) return 5;
		if (count == 3) return 4;
		if (count == 4) return 3;
		if (count == 5 && bonusCount == 0) return 2;
		if (count == 5 && bonusCount == 1) return 1;
		return 0;
	}

	public void updateWinningInfo(int rank){
		winningInfo.set(rank, winningInfo.get(rank) + 1);
	}

	public static void showRevenueRate(){
		checkWinningInfo();
		Message.printTotalReturn(totalRevenue
			/ Integer.parseInt(userInputMoney)
			* Constant.DIVIDE_RATE.getNumber());
	}

	public static void checkWinningInfo(){
		for (int rank = 0; rank <= 4; rank++){
			totalRevenue += calculateRevenue(rank);
		}
	}

	public static double calculateRevenue(int rank){
		if (rank == 0){
			return winningInfo.get(rank) * Constant.FIRST_PRIZE.getNumber();
		}
		if (rank == 1){
			return winningInfo.get(rank) * Constant.SECOND_PRIZE.getNumber();
		}
		if (rank == 2){
			return winningInfo.get(rank) * Constant.THIRD_PRIZE.getNumber();
		}
		if (rank == 3){
			return winningInfo.get(rank) * Constant.FOURTH_PRIZE.getNumber();
		}
		return winningInfo.get(rank) * Constant.FIFTH_PRIZE.getNumber();
	}
}
