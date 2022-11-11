package lotto.domain;

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

	public long receiveTotalAmount() {
		PrintRequestMessage(REQUEST_TOTAL_AMOUNT);
		String amountInput = ConsoleInput.readLine();
		validateAmount(amountInput);
		return (long) valueOf(amountInput);
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


	private void validateAmount(String amountInput) {
		if (Validation.isNotANumber(amountInput)) {
			PrintErrorMessage(AMOUNT_NOT_A_NUMBER);
		}

		if (Validation.isLessThan1000(amountInput)) {
			PrintErrorMessage(AMOUNT_LESS_THAN_1000);
		}

		if (!Validation.isAssignedCurrencyUnit(amountInput)) {
			PrintErrorMessage(AMOUNT_NOT_ASSIGNED_CURRENCY_UNIT);
		}
	}

	private void validateLottoNumber(String numberInput) {
		if (!Validation.isLottoNumberCorrectlyFormatted(numberInput)) {
			PrintErrorMessage(LOTTO_NUMBER_NOT_CORRECTLY_FORMATTED);
		}

		if (!Validation.isLottoNumberCountCorrectlyProvided(numberInput)) {
			PrintErrorMessage(LOTTO_NUMBER_NOT_CORRECTLY_COUNTED);
		}

		if (!Validation.isLottoNumberCorrectlyRanged(numberInput)) {
			PrintErrorMessage(LOTTO_NUMBER_NOT_IN_BETWEEN_1_45);
		}

		if (Validation.isLottoNumberDuplicateExists(numberInput)) {
			PrintErrorMessage(LOTTO_NUMBER_DUPLICATED);
		}
	}

	private void validateBonusNumber(String numberInput, Stream lottoNumbers) {
		if (!Validation.isBonusNumberCorrectlyRanged(numberInput)) {
			PrintErrorMessage(BONUS_NUMBER_NOT_IN_BETWEEN_1_45);
		}

		if (!Validation.isBonusNumberCountCorrectlyProvided(numberInput)) {
			PrintErrorMessage(BONUS_NUMBER_NOT_CORRECTLY_COUNTED);
		}

		if (Validation.isBonusNumberDuplicateExists(numberInput, lottoNumbers)) {
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
