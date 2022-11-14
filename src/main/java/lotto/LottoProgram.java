package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoProgram {

	Exception exception = new Exception();
	Lotto lotto;
	MessagePrint messagePrint = new MessagePrint();
	List<List<Integer>> randomNumbers = new ArrayList<>();
	List<Integer> lottoNumbers = new ArrayList<>();
	int count = 0;
	int bonusNum;

	public int countLotto(String price) {
		int count = conversion(price);
		return count / Constants.DIVIDE;
	}

	public int conversion(String input) {
		return Integer.parseInt(input);
	}

	public void purchaseLotto() {
		messagePrint.purchaseLottoPrint();
		String inputPrice = Console.readLine();
		checkPrize(inputPrice);
		messagePrint.countLottoPrint(inputPrice);
		for (int i = 0; i < countLotto(inputPrice); i++) {
			randomNumbers.add(Randoms.pickUniqueNumbersInRange(Constants.START_INCLUSIVE, Constants.END_INCLUSIVE, 6));
		}
	}

	public void message(List<List<Integer>> randomNumbers) {
		for (List<Integer> list : randomNumbers) {
			List<Integer> sortRandomNumbers = new ArrayList<>();
			sortRandomNumbers.addAll(list);
			Collections.sort(sortRandomNumbers);
			messagePrint.changeList(sortRandomNumbers);
		}
	}

	public void lottoNum() {
		messagePrint.inputWinNumPrint();
		String winningNumber = Console.readLine();
		String[] winNum = winningNumber.split(",");
		for (int i = 0; i < winNum.length; i++) {
			checkWinningNumber(winNum[i]);
			lottoNumbers.add(Integer.parseInt(winNum[i]));
		}
	}

	public void matchLotto(List<Integer> lottoNumbers) {
		lotto = new Lotto(lottoNumbers);
	}

	public void inputBonus() {
		messagePrint.inputBonusNumPrint();
		String bonusNumber = Console.readLine();
		checkBonusNum(bonusNumber);
		bonusNum = Integer.parseInt(bonusNumber);
		exception.lottoOverLap(lotto.getLotto(), bonusNum);
	}

	public int checkWinNum(List<Integer> oneLotto, List<Integer> winLotto) {
		for (int i = 0; i < oneLotto.size(); i++) {
			if (oneLotto.contains(winLotto.get(i))) {
				count++;
			}
		}
		return count;
	}
}