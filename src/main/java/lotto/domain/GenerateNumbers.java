package lotto.domain;

import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class GenerateNumbers {
	public static final int LOTTO_PRICE = 1000;
	public List<Integer> lottoNumbers;
	public static int bonusNumber;

	public List<Integer> lotto() {
		lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
		bonusNumber = Randoms.pickNumberInRange(1, 45);
		while (lottoNumbers.contains(bonusNumber)) {
			bonusNumber = Randoms.pickNumberInRange(1, 45);
		}
		lottoNumbers.add(bonusNumber);
		Collections.sort(lottoNumbers);
		return lottoNumbers;
	}
	
	public String winningNubmer() {
		System.out.println("구입 금액을 입력해 주세요.");
		String inputAmount = Console.readLine();
		int purchaseAmount = Integer.parseInt(inputAmount);
		int lotteryCount = purchaseAmount / LOTTO_PRICE;
		
		String winningNumbers = "";
		for (int repeat = 0; repeat < lotteryCount; repeat++) {
			winningNumbers += lotto() + "\n";
		}
		winningNumbers = lotteryCount + "개를 구매했습니다.\n" + winningNumbers;
		return winningNumbers;
	}
}
