package lotto.views;

import camp.nextstep.edu.missionutils.Console;
import lotto.models.Lotto;
import lotto.validation.SystemValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.Constant.*;

public class Reader {
	public static int readUserLottoPurchaseAmount() {
		String lottoPurchaseAmount = Console.readLine();

		SystemValidator.validateUserPurchaseAmount(lottoPurchaseAmount);

		return Integer.parseInt(lottoPurchaseAmount);
	}

	public static Lotto readUserLottoWinningNumber() {
		String userWinningLottoInput = Console.readLine();
		SystemValidator.validateAllLottoNumberInputElementsIsNumber(userWinningLottoInput);

		List<Integer> winningLotto = parsingLottoNumber(userWinningLottoInput);

		return new Lotto(winningLotto);
	}

	private static List<Integer> parsingLottoNumber(String lottoWinningNumber) {
		String[] splitLottoWinningNumber = lottoWinningNumber.split(SPLIT_LOTTO_DELIMITER);

		return Arrays.stream(splitLottoWinningNumber)
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}
}
