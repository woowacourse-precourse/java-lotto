package lotto.domain.util;

import static lotto.ui.ConsoleOutput.*;

public class ExceptionHandler {

	public static void handlePlayer(String ExceptionMessage) {
		PrintErrorMessage(ExceptionMessage);
		throw new ValidationException(ExceptionMessage);
	}

	public static void handleLottoMachine(String ExceptionMessage) {
		throw new ValidationException(ExceptionMessage);
	}
}
