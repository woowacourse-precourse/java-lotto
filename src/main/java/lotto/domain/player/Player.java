package lotto.domain.player;

import lotto.domain.Validator;
import lotto.ui.ConsoleInput;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Integer.*;
import static lotto.ui.ConsoleOutput.*;

public class Player {

	public static List<Integer> winningNumber;
	public static List<Integer> bonusNumber;

	public String receivePurchaseAmount() {
		PrintRequestMessage(REQUEST_TOTAL_AMOUNT);
		return ConsoleInput.readLine();
	}

	public String receiveWinningNumber() {
		PrintRequestMessage(REQUEST_WINNING_NUMBER);
		return ConsoleInput.readLine();
	}

	public String receiveBonusNumber() {
		PrintRequestMessage(REQUEST_BONUS_NUMBER);
		return ConsoleInput.readLine();

	}
}
