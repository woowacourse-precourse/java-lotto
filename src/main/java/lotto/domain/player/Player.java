package lotto.domain.player;

import lotto.domain.ValidationConfig;
import lotto.ui.ConsoleInput;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Integer.*;
import static lotto.ui.ConsoleOutput.*;

public class Player {

	public static List<Integer> winningNumbers;
	public static List<Integer> bonusNumber;

	public String receivePurchaseAmount() {
		PrintRequestMessage(REQUEST_TOTAL_AMOUNT);
		String amountInput = ConsoleInput.readLine();
		return amountInput;
	}

	public Stream<Integer> receiveLottoNumber() {
		PrintRequestMessage(REQUEST_LOTTO_NUMBER);
		String lottoNumber = ConsoleInput.readLine();
		validateLottoNumber(lottoNumber);
		storeWinningNumbers(lottoNumber);
		return getNumbers(lottoNumber);
	}

	public int receiveBonusNumber(Stream lottoNumbers) {
		PrintRequestMessage(REQUEST_BONUS_NUMBER);
		String bonusNumber = ConsoleInput.readLine();
		validateBonusNumber(bonusNumber, lottoNumbers);
		storeBonusNumber(bonusNumber);
		return parseInt(bonusNumber);
	}

	private void validateLottoNumber(String numberInput) {
		if (!ValidationConfig.isLottoNumberCorrectlyFormatted(numberInput)) {
			PrintErrorMessage(LOTTO_NUMBER_NOT_CORRECTLY_FORMATTED);
		}

		if (!ValidationConfig.isLottoNumberCountCorrectlyProvided(numberInput)) {
			PrintErrorMessage(LOTTO_NUMBER_NOT_CORRECTLY_COUNTED);
		}

		if (!ValidationConfig.isLottoNumberCorrectlyRanged(numberInput)) {
			PrintErrorMessage(LOTTO_NUMBER_NOT_IN_BETWEEN_1_45);
		}

		if (ValidationConfig.isLottoNumberDuplicateExists(numberInput)) {
			PrintErrorMessage(LOTTO_NUMBER_DUPLICATED);
		}
	}

	private void validateBonusNumber(String numberInput, Stream lottoNumbers) {
		if (!ValidationConfig.isBonusNumberCorrectlyRanged(numberInput)) {
			PrintErrorMessage(BONUS_NUMBER_NOT_IN_BETWEEN_1_45);
		}

		if (!ValidationConfig.isBonusNumberCountCorrectlyProvided(numberInput)) {
			PrintErrorMessage(BONUS_NUMBER_NOT_CORRECTLY_COUNTED);
		}

		if (ValidationConfig.isBonusNumberDuplicateExists(numberInput, lottoNumbers)) {
			PrintErrorMessage(BONUS_NUMBER_DUPLICATED);
		}
	}

	public static Stream<Integer> getNumbers(String input) {
		return Pattern.compile(",").
				splitAsStream(input).
				map(Integer::parseInt);
	}

	public static void storeWinningNumbers(String input){
		winningNumbers =  Arrays.stream(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
	}

	public static void storeBonusNumber(String input){
		bonusNumber = Arrays.stream(input.split("")).map(Integer::parseInt).collect(Collectors.toList());
	}

}
