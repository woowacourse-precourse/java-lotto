package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoMachine {

	private static Lotto winningLotto;
	private static int bonusNumber;

	public List<Integer> generateLotto() {
		List<Integer> lotto = Randoms.pickUniqueNumbersInRange(Constant.FIRST_NUMBER_IN_LOTTO,
			Constant.LAST_NUMBER_IN_LOTTO,
			Constant.LOTTO_SIZE);

		return lotto.stream().sorted().collect(Collectors.toList());
	}

	public void inputWinningNumber() {
		View.printInputWinningLottoNumber();
		String inputNumber = readLine();
		List<Integer> numbers = splitInputNumber(inputNumber);
		winningLotto = new Lotto(numbers);

		inputBonusNumber();
	}

	private void inputBonusNumber() {
		View.printInputBonusNumber();
		String inputBonusNumber = readLine();
		bonusNumber = Valid.isDuplicateWithWinningNumber(winningLotto.getNumbers(), inputBonusNumber);
		Valid.hasCorrectRangeNumber(bonusNumber);
	}

	private List<Integer> splitInputNumber(String inputNumber) {
		StringTokenizer number = new StringTokenizer(inputNumber, ",");
		List<Integer> numbers = new ArrayList<>();
		while (number.hasMoreTokens()) {
			int lottoNumber = Valid.isDigit(number.nextToken());
			numbers.add(lottoNumber);
		}
		return numbers;
	}

	public int countHitNumber(Lotto userLotto) {
		return userLotto.getNumbers().stream()
			.filter(user -> winningLotto.getNumbers().stream().anyMatch(Predicate.isEqual(user)))
			.collect(Collectors.toList()).size();
	}

	public boolean hitBonusNumber(Lotto userLotto) {
		return userLotto.getNumbers().contains(bonusNumber);
	}

}
