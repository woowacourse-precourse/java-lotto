package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Seller;

public class Application {

	private static final String SELL_ANNOUNCEMENT = "구입금액을 입력해 주세요.";
	private static final Seller seller = new Seller();

	public static void main(String[] args) {
		final Integer money = readPurchaseAmount();
		final List<Lotto> tickets = seller.sellLottoTickets(money);
		writeLottoNumbers(tickets);
	}

	private static void writeLottoNumbers(List<Lotto> tickets) {
		tickets.stream()
			.map(Lotto::getNumbers)
			.map(List::toString)
			.forEach(System.out::println);
	}

	private static Integer readPurchaseAmount() {
		System.out.println(SELL_ANNOUNCEMENT);
		try {
			return Integer.valueOf(Console.readLine());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.isInvalidNumber());
		}
	}

}
