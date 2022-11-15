package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class LottoMachine {

	private static Lotto winningLotto;
	private static int bonusNumber;

	public List<Integer> generateLotto() {
		List<Integer> lotto = Randoms.pickUniqueNumbersInRange(Constant.FIRST_NUMBER_IN_LOTTO,
			Constant.LAST_NUMBER_IN_LOTTO,
			Constant.LOTTO_SIZE);
		Collections.sort(lotto);
		return lotto;
	}

	public void inputWinningNumber() {
		System.out.println(Message.INPUT_WINNING_NUMBER);
		String inputNumber = readLine();
		List<Integer> numbers = splitInputNumber(inputNumber);
		winningLotto = new Lotto(numbers);

		inputBonusNumber();
	}

	private void inputBonusNumber() {
		System.out.println(Message.INPUT_BONUS_NUMBER);
		String inputBonusNumber = readLine();
		bonusNumber = Valid.isDuplicateWithWinningNumber(winningLotto.getNumbers(), inputBonusNumber);
		Valid.hasCorrectRangeNumber(bonusNumber);
	}

	private List<Integer> splitInputNumber(String inputNumber) {
		StringTokenizer number = new StringTokenizer(inputNumber, ",");
		List<Integer> numbers = new ArrayList<>();
		while (number.hasMoreTokens()) {
			int lottoNumber = Integer.parseInt(number.nextToken());
			numbers.add(lottoNumber);
		}
		return numbers;
	}
}
