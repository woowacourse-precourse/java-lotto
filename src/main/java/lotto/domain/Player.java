package lotto.domain;

import lotto.ui.ConsoleInput;

import static java.lang.Integer.*;
import static lotto.ui.ConsoleOutput.*;

public class Player {
	public long receiveTotalAmount() {
		PrintRequestMessage(REQUEST_TOTAL_AMOUNT);
		String amountInput = ConsoleInput.readLine();
		validateAmount(amountInput);
		return (long) valueOf(amountInput);
	}

	public int receiveLottoNumber(){
		PrintRequestMessage(REQUEST_LOTTO_NUMBER);
		String lotteryNumber = ConsoleInput.readLine();
		validateLottoNumber(lotteryNumber);
		return parseInt(lotteryNumber);
	}

	private void validateAmount(String amountInput) {
		if (amountInput.isEmpty()) {
			PrintErrorMessage(EMPTY);
		}

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
		if (numberInput.isEmpty()){
			PrintErrorMessage(EMPTY);
		}

		if(!Validation.isCorrectlyFormatted(numberInput)){
			PrintErrorMessage(NUMBER_NOT_CORRECTLY_FORMATTED);
		}

		if(!Validation.isCountCorrectlyProvided(numberInput)){
			PrintErrorMessage(NUMBER_NOT_CORRECTLY_COUNTED);
		}

		if(!Validation.isCorrectlyRanged(numberInput)){
			PrintErrorMessage(NUMBER_NOT_IN_BETWEEN_1_45);
		}

		if(Validation.isDuplicateExists(numberInput)){
			PrintErrorMessage(NUMBER_DETECTED_DUPLICATE);
		}
	}

}
