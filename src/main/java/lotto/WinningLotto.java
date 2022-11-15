package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
	private final Lotto winningLotto;
	private final Integer bonusNumber;

	public WinningLotto() {
		Print.PrintTypingWinLotto();
		String stringInputNumbers = Console.readLine();

		String[] stringWinningNumbers = stringInputNumbers.split(",");
		validateWinningLotto(stringWinningNumbers);

		winningLotto = new Lotto(
			Arrays.stream(stringWinningNumbers).map(Integer::parseInt).collect(Collectors.toList())
		);

		Print.PrintTypingBonusNumber();
		String inputBonusNumber = Console.readLine();
		validateBonusNumber(inputBonusNumber);

		bonusNumber = Integer.parseInt(inputBonusNumber);
	}

	private void validateWinningLotto(String[] stringWinningNumbers) {
		Exception.validateLottoLength(stringWinningNumbers);
		Exception.validateLottoNumberRange(stringWinningNumbers);
		Exception.validateDuplicateNumbers(stringWinningNumbers);
	}

	private void validateBonusNumber(String inputBonusNumber) {
		Exception.validateNumber(inputBonusNumber);
		Exception.validateLottoNumberRange(inputBonusNumber);
		Exception.validateDuplicateNumbers(winningLotto, inputBonusNumber);
	}

	public List<Integer> getWinningLotto() {
		return winningLotto.getNumbers();
	}

	public Integer getBonusNumber() {
		return bonusNumber;
	}
}
