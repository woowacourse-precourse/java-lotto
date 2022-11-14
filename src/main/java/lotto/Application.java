package lotto;

import static lotto.Constants.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LotteryMachine;
import lotto.domain.Lotto;
import lotto.domain.Seller;

public class Application {

	private static final String INPUT_PURCHASE_AMOUNT_ANNOUNCEMENT = "구입금액을 입력해 주세요.";
	private static final String INPUT_WINNING_NUMBERS_ANNOUNCEMENT = "당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_NUMBER_ANNOUNCEMENT = "보너스 번호를 입력해 주세요.";

	public static void main(String[] args) {
		final Integer money = readPurchaseAmount();
		final List<Lotto> tickets = Seller.sellLottoTickets(money);
		writeLottoNumbers(tickets);
		final LotteryMachine machine = drawAndGetMachine();
	}

	private static LotteryMachine drawAndGetMachine() {
		final List<Integer> numbers = readWinningNumbers();
		final LotteryMachine machine = LotteryMachine.of(numbers);
		final Integer bonusNumber = readBonusNumber();
		machine.setBonusNumber(bonusNumber);
		return machine;
	}

	private static Integer readBonusNumber() {
		System.out.println(INPUT_BONUS_NUMBER_ANNOUNCEMENT);
		try {
			return Integer.valueOf(Console.readLine());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.isInvalidNumber());
		}
	}

	private static List<Integer> readWinningNumbers() {
		System.out.println(INPUT_WINNING_NUMBERS_ANNOUNCEMENT);
		try {
			return Arrays.stream(Console.readLine()
					.split(COMMA))
				.map(Integer::valueOf)
				.collect(Collectors.toList());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.isInvalidNumber());
		}
	}

	private static void writeLottoNumbers(List<Lotto> tickets) {
		tickets.stream()
			.map(Lotto::getNumbers)
			.map(List::toString)
			.forEach(System.out::println);
	}

	private static Integer readPurchaseAmount() {
		System.out.println(INPUT_PURCHASE_AMOUNT_ANNOUNCEMENT);
		try {
			return Integer.valueOf(Console.readLine());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.isInvalidNumber());
		}
	}

}
